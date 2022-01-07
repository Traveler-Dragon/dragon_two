package com.traveler.server.controller;

import com.alibaba.excel.EasyExcel;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.traveler.server.aliPay.AliPayApi;
import com.traveler.server.model.bo.BaseResponse;
import com.traveler.server.model.entity.FamilyGoods;
import com.traveler.server.model.entity.GoodsExcel;
import com.traveler.server.service.FamilyMallService;
import com.traveler.server.util.CommentWriteHandler;
import com.traveler.server.util.GoodsExcelListener;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/family/familyMall")
public class FamilyMallController {

    @Autowired
    private FamilyMallService familyMallService;

    @RequestMapping("/diamond/add")
    public BaseResponse list(){
        return BaseResponse.success(familyMallService.diamondAdd());
    }

    @RequestMapping(value = "/diamond/exchangeGold",method = RequestMethod.POST)
    public BaseResponse exchangeGold(@RequestParam("userId") String userId,
                                     @RequestParam("diamondAmount") Integer diamondAmount,
                                     @RequestParam("goldAmount") Integer goldAmount){
//        familyMallService.exchangeGold(userId,diamondAmount,goldAmount);

        return BaseResponse.success();
    }

    @RequestMapping("/getExcel")
    public BaseResponse getExcel(){
        String path = "C:\\Users\\DELL\\Desktop\\shopItem.xlsx";
        List<GoodsExcel> goodsExcels = new ArrayList<>();
        EasyExcel.write(path, GoodsExcel.class).inMemory(Boolean.TRUE).registerWriteHandler(new CommentWriteHandler()).sheet("商品模板").doWrite(goodsExcels);
        return BaseResponse.success();
    }

//    @RequestMapping("/diamond/list/{system}")
//    public BaseResponse list(@PathVariable Integer system){
//        return BaseResponse.success()
//    }

    @RequestMapping(value = "importGoodsExcel")
    public BaseResponse importGoodsExcel(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        EasyExcel.read(inputStream, GoodsExcel.class, new GoodsExcelListener(familyMallService)).sheet().doRead();
        return BaseResponse.success();
    }

    @RequestMapping(value = "/diamond/exchangeGold",method = RequestMethod.GET)
    public BaseResponse exchangeGold(@RequestParam("userId") String userId,
                                     @RequestParam("goldId") String goldId){
//        int count = familyMallService.exchangeGold(userId,goldId);
        return BaseResponse.success();
    }


    @RequestMapping(value = "/payReturn",method = RequestMethod.GET)
    public String payReturn(HttpServletRequest request){
        try {
            // 获取支付宝GET过来反馈信息
            Map<String, String> map = AliPayApi.toMap(request);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

            boolean verifyResult = AlipaySignature.rsaCheckV1(map, "aliPayBean.getPublicKey()", "UTF-8",
                    "RSA2");

            if (verifyResult) {
                // TODO 请在这里加上商户的业务逻辑程序代码
                System.out.println("return_url 验证成功");
                AlipayTradeQueryModel model = new AlipayTradeQueryModel();
                if (StringUtils.isNotEmpty(map.get("out_trade_no"))) {
                    model.setOutTradeNo(map.get("out_trade_no"));
                }
                if (StringUtils.isNotEmpty(map.get("trade_no"))) {
                    model.setTradeNo(map.get("trade_no"));
                }
                String body = AliPayApi.tradeQueryToResponse(model).getBody();

                return body;
            } else {
                System.out.println("return_url 验证失败");
                // TODO
                return "failure";
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return "failure";
        }
    }

//    @PassToken
//    @CrossOrigin
//    @RequestMapping("/recharge/pcPayTest")
//    public void pcPayTest(HttpServletResponse response) throws ImcoreBusinessException {
//        RechargePayDTO rechargePayDTO = new RechargePayDTO();
//        rechargePayDTO.setHomeId("20862549");
//        rechargePayDTO.setDiamondId("15cb31a539fe4fae8e7ba36ebb5c9268");
//        rechargePayDTO.setChannel(3);
//        rechargePayDTO.setPayType(1);
//        rechargePayDTO.setPayCount(1);
//        familyMallService.rechargePay(rechargePayDTO,response);
//    }
//
//    @PassToken
//    @RequestMapping(value = "/test")
//    public BaseResponse test(@RequestParam("orderId") Integer orderId){
//        String test = familyMallService.test(orderId);
//        return BaseResponse.success(test);
//    }

    /**
     * @Override
     *     public void homeCommoditySell() throws ImcoreBusinessException {
     *         Map<String,Object> bizContentParam = new HashMap<>();
     *         bizContentParam.put("phoneNumber","15204179543");
     *         bizContentParam.put("worksId","317");
     *         bizContentParam.put("commodityId","516");
     *         bizContentParam.put("price",new BigDecimal("100"));
     *         bizContentParam.put("amount",1);
     *         bizContentParam.put("copyrightTransfer",1);
     *         String bizContent = JSONObject.toJSONString(bizContentParam);
     *         Map<String, Object> infoCentParam = getInfoCentParam(bizContent);
     *         String infoCentParamJson = JSON.toJSONString(infoCentParam);
     *         log.info("发送的请求数据为: {}",infoCentParam);
     *         String post = HttpUtil.post("http://172.16.171.23:6006/openapi/homeCommoditySell", infoCentParamJson);
     *         Map body = JSON.parseObject(post, Map.class);
     *         log.info("ntf响应的数据:  "+post);
     *         if (Integer.parseInt(body.get(ConstantType.ERWEI_IMCORE_CODE).toString()) != ConstantType.NUMBER_VALUE_0){
     *             throw new ImcoreBusinessException("813",body.get("msg").toString(),null);
     *         }
     *         Map data = JSONObject.parseObject(body.get("data").toString(), Map.class);
     *         log.info(""+JSONObject.parseObject(data.get("bizContent").toString(),Map.class));
     *     }
     *
     *     @Override
     *     public void offShelf() throws ImcoreBusinessException {
     *         Map<String,Object> bizContentParam = new HashMap<>();
     *         bizContentParam.put("phoneNumber","15204179543");
     *         bizContentParam.put("commodityId","516");
     *         String bizContent = JSONObject.toJSONString(bizContentParam);
     *         Map<String, Object> infoCentParam = getInfoCentParam(bizContent);
     *         String infoCentParamJson = JSON.toJSONString(infoCentParam);
     *         log.info("发送的请求数据为: {}",infoCentParam);
     *         String post = HttpUtil.post("http://172.16.171.23:6006/openapi/offShelf", infoCentParamJson);
     *         Map body = JSON.parseObject(post, Map.class);
     *         log.info("ntf响应的数据:  "+post);
     *         if (Integer.parseInt(body.get(ConstantType.ERWEI_IMCORE_CODE).toString()) != ConstantType.NUMBER_VALUE_0){
     *             if ("您来晚了一步，作品已售完".equals(body.get("msg").toString())){
     *                 throw new ImcoreBusinessException(ResultCode.MALL_GOODS_NOT_STOCK);
     *             }
     *             throw new ImcoreBusinessException(ResultCode.MALL_NTF_NOT_GOODS_LIST);
     *         }
     *         Map data = JSONObject.parseObject(body.get("data").toString(), Map.class);
     *         log.info(""+JSONObject.parseObject(data.get("bizContent").toString(),Map.class));
     *     }
     */
}
