package com.traveler.server.util;

import com.alipay.api.AlipayApiException;
import com.ijpay.wxpay.WxPayApiConfig;
import com.ijpay.wxpay.WxPayApiConfigKit;
import com.traveler.server.aliPay.AliPayApiConfig;
import com.traveler.server.aliPay.AliPayApiConfigKit;
import com.traveler.server.model.entity.AliPayBean;
import com.traveler.server.model.entity.WxPayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PayConfigHandler implements CommandLineRunner {
    @Autowired
    private WxPayBean wxPayBean;

    @Autowired
    private AliPayBean aliPayBean;

    @Override
    public void run(String... args) throws Exception {
        getWxApiConfig();
        getAliApiConfig();
    }

    public void getAliApiConfig() throws AlipayApiException {
//        AliPayApiConfig aliPayApiConfig;
//        try {
//            aliPayApiConfig = AliPayApiConfigKit.getApiConfig(aliPayBean.getAppId());
//        } catch (Exception e) {
//            aliPayApiConfig = AliPayApiConfig.builder()
//                    .setAppId(aliPayBean.getAppId())
//                    .setAliPayPublicKey(aliPayBean.getPublicKey())
//                    .setAppCertPath(aliPayBean.getAppCertPath())
//                    .setAliPayCertPath(aliPayBean.getAliPayCertPath())
//                    .setAliPayRootCertPath(aliPayBean.getAliPayRootCertPath())
//                    .setCharset("UTF-8")
//                    .setPrivateKey(aliPayBean.getPrivateKey())
//                    .setServiceUrl(aliPayBean.getServerUrl())
//                    .setSignType("RSA2")
//                    // 普通公钥方式
//                    .build();
//            // 证书模式
////                    .buildByCert();
//
//        }
//        AliPayApiConfigKit.setThreadLocalAliPayApiConfig(aliPayApiConfig);
    }

    public void getWxApiConfig() {
        WxPayApiConfig apiConfig;

        try {
            apiConfig = WxPayApiConfigKit.getApiConfig(wxPayBean.getAppId());
        } catch (Exception e) {
            apiConfig = WxPayApiConfig.builder()
                    .appId(wxPayBean.getAppId())
                    .mchId(wxPayBean.getMchId())
                    .partnerKey(wxPayBean.getPartnerKey())
                    .certPath(wxPayBean.getCertPath())
                    .domain(wxPayBean.getDomain())
                    .build();
        }
        WxPayApiConfigKit.setThreadLocalWxPayApiConfig(apiConfig);
    }
}
