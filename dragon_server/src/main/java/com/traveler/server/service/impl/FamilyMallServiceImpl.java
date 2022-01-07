package com.traveler.server.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ijpay.core.enums.SignType;
import com.ijpay.core.enums.TradeType;
import com.ijpay.core.kit.IpKit;
import com.ijpay.core.kit.WxPayKit;
import com.ijpay.wxpay.WxPayApi;
import com.ijpay.wxpay.WxPayApiConfig;
import com.ijpay.wxpay.WxPayApiConfigKit;
import com.ijpay.wxpay.model.UnifiedOrderModel;
import com.traveler.server.aliPay.AliPayApi;
import com.traveler.server.mapper.FamilyBalanceMapper;
import com.traveler.server.mapper.FamilyGoodsMapper;
import com.traveler.server.mapper.GoodsExcelMapper;
import com.traveler.server.model.entity.FamilyGoods;
import com.traveler.server.model.entity.GoodsExcel;
import com.traveler.server.repository.FamilyGoodsRepository;
import com.traveler.server.service.FamilyDiamondService;
import com.traveler.server.service.FamilyMallService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FamilyMallServiceImpl implements FamilyMallService {
    @Autowired
    private FamilyDiamondService familyDiamondService;

    @Autowired
    private FamilyBalanceMapper familyBalanceMapper;

    @Autowired
    private GoodsExcelMapper goodsExcelMapper;

    @Autowired
    private FamilyGoodsRepository goodsRepository;

    @Autowired
    private FamilyGoodsMapper familyGoodsMapper;

    @Override
    public boolean diamondAdd() {
        familyDiamondService.add();
        return true;
    }

    private final String wx_notify_url = "/pay/payNotify";
    private final String ali_notify_url = "http://www.dragon.8080/pay/aliPayNtify";

    @Override
    public void addGoods(List<GoodsExcel> list) {
        List<Long> itemList = new ArrayList<>();
        for (GoodsExcel goodsExcel : list) {
            goodsExcelMapper.insert(goodsExcel);
            itemList.add(goodsExcel.getItemId());
        }
        QueryWrapper<FamilyGoods> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.in("item_id",itemList);
        List<FamilyGoods> familyGoods = familyGoodsMapper.selectList(goodsQueryWrapper);
        for (FamilyGoods familyGood : familyGoods) {
            goodsRepository.save(familyGood);
        }

    }

    @Override
    public List<GoodsExcel> selectItemList(List<Integer> itemList) {
        QueryWrapper<GoodsExcel> existWrapper = new QueryWrapper<>();
        existWrapper.in("item_id",itemList);
        return goodsExcelMapper.selectList(existWrapper);
    }

    @Override
    public void updateGoods(List<GoodsExcel> updateGoods) {
        for (GoodsExcel updateGood : updateGoods) {
            UpdateWrapper<GoodsExcel> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("item_id",updateGood.getItemId());
            goodsExcelMapper.update(updateGood,updateWrapper);
        }
    }

    @SneakyThrows
    @Override
    public void pay(Integer payType, HttpServletRequest request, HttpServletResponse response) {
        switch (payType){
            case 0:
                break;
            case 2:
                String s = wxPay(request);
                log.info("微信的返回参数为: "+s);
                break;
            case 3:
                String s1 = aliPay();
                log.info("支付宝的返回参数为: "+s1);
                break;
            default:

        }

    }

    private String aliPay() throws AlipayApiException {
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是测试数据-By Javen");
        model.setSubject("App支付测试-By Javen");
        model.setOutTradeNo("081415044916289");
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        model.setPassbackParams("callback params");
        model.setProductCode("QUICK_MSECURITY_PAY");
        String orderInfo = AliPayApi.appPayToResponse(model, ali_notify_url).getBody();
        return orderInfo;
    }

    private String wxPay(HttpServletRequest request){
        String ip = IpKit.getRealIp(request);
        if (StringUtils.isBlank(ip)) {
            ip = "127.0.0.1";
        }

        WxPayApiConfig wxPayApiConfig = WxPayApiConfigKit.getWxPayApiConfig();

        Map<String, String> params = UnifiedOrderModel
                .builder()
                .appid(wxPayApiConfig.getAppId())
                .mch_id(wxPayApiConfig.getMchId())
                .nonce_str(WxPayKit.generateStr())
                .body("IJPay 让支付触手可及-App支付")
                .out_trade_no(WxPayKit.generateStr())
                .total_fee("1000")
                .spbill_create_ip(ip)
                .notify_url(wxPayApiConfig.getDomain().concat(wx_notify_url))
                .trade_type(TradeType.APP.getTradeType())
                .build()
                .createSign(wxPayApiConfig.getPartnerKey(), SignType.HMACSHA256);

        String xmlResult = WxPayApi.pushOrder(false, params);

        log.info(xmlResult);
        Map<String, String> result = WxPayKit.xmlToMap(xmlResult);

        String returnCode = result.get("return_code");
        String returnMsg = result.get("return_msg");
        if (!WxPayKit.codeIsOk(returnCode)) {
            return returnMsg;
        }
        String resultCode = result.get("result_code");
        if (!WxPayKit.codeIsOk(resultCode)) {
            return returnMsg;
        }
        // 以下字段在 return_code 和 result_code 都为 SUCCESS 的时候有返回
        String prepayId = result.get("prepay_id");

        Map<String, String> packageParams = WxPayKit.appPrepayIdCreateSign(wxPayApiConfig.getAppId(), wxPayApiConfig.getMchId(), prepayId,
                wxPayApiConfig.getPartnerKey(), SignType.HMACSHA256);

        String jsonStr = JSON.toJSONString(packageParams);
        log.info("返回apk的参数:" + jsonStr);
        return jsonStr;
    }
}
