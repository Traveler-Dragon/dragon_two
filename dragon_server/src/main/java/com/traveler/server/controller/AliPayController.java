package com.traveler.server.controller;

import cn.hutool.core.io.IoUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.traveler.server.aliPay.AliPayApiConfig;
import com.traveler.server.aliPay.AliPayApiConfigKit;
import com.traveler.server.model.bo.BaseResponse;
import com.traveler.server.model.entity.AliPayBean;
import com.traveler.server.service.FamilyMallService;
import com.traveler.server.util.AlipayUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/aliPay")
@Slf4j
public class AliPayController {

    @Autowired
    private AliPayBean aliPayBean;

    @Autowired
    private FamilyMallService familyMallService;

    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    public String pay() throws JsonProcessingException, AlipayApiException {
        AlipayUtil alipayUtil = new AlipayUtil();
        String result = alipayUtil.generateAliPayTradePagePayRequestForm("12345678911", "雪乃", 1000.01);

        return result;
    }

    @RequestMapping("/redirect")
    public BaseResponse redirect(HttpServletRequest request) throws AlipayApiException {
        String auth_code = request.getParameter("auth_code");
        String app_id = request.getParameter("app_id");
        log.info("获取的auth_code: {}",auth_code);
        log.info("获取的app_id: {}",app_id);
        InputStream config = getClass().getResourceAsStream("/production/alipay.properties");
        ArrayList<String> strings = IoUtil.readLines(config, "UTF-8", new ArrayList<>());
        strings.forEach(str ->{
            log.info("获取的map: {}",str);
        });

        AlipayClient alipayClient = new DefaultAlipayClient(aliPayBean.getServerUrl(),app_id,aliPayBean.getPrivateKey(),"json","GBK",aliPayBean.getPublicKey(),"RSA2");
        AlipaySystemOauthTokenRequest requestAli = new AlipaySystemOauthTokenRequest();
        requestAli.setGrantType("authorization_code");
        requestAli.setCode(auth_code);
        AlipaySystemOauthTokenResponse response = alipayClient.execute(requestAli);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return BaseResponse.success(response);
    }

    @RequestMapping(value = "callBack",method = RequestMethod.POST)
    public BaseResponse callBack(HttpServletRequest request){
        return BaseResponse.success(request);
    }

    @RequestMapping(value = "/IPay",method = RequestMethod.GET)
    public void IPay(HttpServletResponse response) throws IOException, AlipayApiException {
        AliPayApiConfig aliPayApiConfig = getApiConfig();
        AliPayApiConfigKit.setThreadLocalAliPayApiConfig(aliPayApiConfig);
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setSubject("雪之下雪乃");
        model.setOutTradeNo(getOutTradeNo());
        model.setTotalAmount("888.88");
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
//        model.setBody("Javen IJPay PC支付测试");
//        model.setPassbackParams("passback_params");

//        AliPayApi.tradePage(response,model,notifyUrl,returnUrl);
    }

    public  static String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);
        key = key + System.currentTimeMillis();
        key = key.substring(0, 15);
        return key;
    }

    public AliPayApiConfig getApiConfig() throws AlipayApiException {
        AliPayApiConfig aliPayApiConfig;
        try {
            aliPayApiConfig = AliPayApiConfigKit.getApiConfig(aliPayBean.getAppId());
        } catch (Exception e) {
            aliPayApiConfig = AliPayApiConfig.builder()
                    .setAppId(aliPayBean.getAppId())
                    .setAliPayPublicKey(aliPayBean.getPublicKey())
                    .setAppCertPath(aliPayBean.getAppCertPath())
                    .setAliPayCertPath(aliPayBean.getAliPayCertPath())
                    .setAliPayRootCertPath(aliPayBean.getAliPayRootCertPath())
                    .setCharset("UTF-8")
                    .setPrivateKey(aliPayBean.getPrivateKey())
                    .setServiceUrl(aliPayBean.getServerUrl())
                    .setSignType("RSA2")
                    // 普通公钥方式
                    .build();
            // 证书模式
//                    .buildByCert();

        }

        return aliPayApiConfig;
    }

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    @SneakyThrows
    public BaseResponse pay(HttpServletRequest request, HttpServletResponse response, @RequestParam("payType") Integer payType){
        familyMallService.pay(payType,request,response);
        return BaseResponse.success();
    }

    @RequestMapping("/ali/accesstoken")
    public BaseResponse aliAccessToken(@RequestParam("accessToken") String accessToken) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayBean.getServerUrl(),aliPayBean.getAppId(),aliPayBean.getPrivateKey(),"json","GBK",aliPayBean.getPublicKey(),"RSA2");
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("authorization_code");
        request.setCode(accessToken);
        AlipaySystemOauthTokenResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return BaseResponse.success(response);
    }



    @RequestMapping("/ali/userLogin")
    public BaseResponse aliUserLogin(@RequestParam("accessToken") String accessToken) throws AlipayApiException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayBean.getServerUrl(),aliPayBean.getAppId(),aliPayBean.getPrivateKey(),"json","GBK",aliPayBean.getPublicKey(),"RSA2");
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        AlipayUserInfoShareResponse response = alipayClient.execute(request,accessToken);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return BaseResponse.success(response);
    }

    @GetMapping("/getAliLoginUrl")
    public BaseResponse getAliLoginUrl() throws UnsupportedEncodingException {
        String appId = aliPayBean.getAppId();
        String url = "http://f057-222-128-10-75.ngrok.io/family/familyRed/withdrawal/bindingAli";
        String result = "alipays://platformapi/startapp?appId="+appId+"&" +
                "url=https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?" +
                "app_id="+appId+"&" +
                "scope=auth_user&" +
                "redirect_uri="+ URLEncoder.encode(url,"UTF-8")+"&" +
                "state=traveler";
        return BaseResponse.success(result);
    }

}
