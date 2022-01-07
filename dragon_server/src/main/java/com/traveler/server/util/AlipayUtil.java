package com.traveler.server.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author huyoufu
 * @TIME 2019/5/14 19:41
 * @description
 */
@Component
public class AlipayUtil {
    private static  AlipayClient ALIPAY_CLIENT_PAGE=null;
    private static  AlipayClient ALIPAY_CLIENT_QUERY=null;
    @Value("${aliPay.appId}")
    private String appId="2016102600762260";
    @Value("${aliPay.serverUrl}")
    private  String serverUrl="https://openapi.alipaydev.com/gateway.do";
    @Value("${aliPay.privateKey}")
    private  String privateKey="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCEcW4i9r4ZB1s9pAs1iEb9a689hgZvfT9R3PqtiH3lLjG6nABEKUNkf6DBJeG3RCwtQiRhRraHso1SVZ5sEx1XlQHh25M6rrofST5NbcrSBEiKO1uTBTkKAvPI6yrDsobKtuKnKQAc17cu21LP4KZsfZ7/VKgrW1FJXbRYvBR0zLU0dWOpk15yWF1TGRJ5C1YbXybsSpxhiM4kw8RP7/g9WAZtu90/ElM6S1tWoE0XqxuR8I6NP+y5nEBN4O0gBDXVjSIrYeTiADrILAD2KCQRqddK8nlG9S37A+U0sB0csqvsHxgYAK8sxEqzBc/CYzJY9iluZtmkatU9Bdr+Oh7XAgMBAAECggEAE7tikUr5n3j9Gv3pvZwEF5WHkj75jnq2iFfH8Tq4pwBu4EKFt6H+LGbnaF9gdZFuk3+bM/L5FtZ/P5kJ9UgTwwysLx4rnT6S9D5RTe/hm9CPjiixyAGrMdamw3Rl9qoOcv00X3s4TRPGcvCyMc5ifR9qJNhUBcGhJrETQXUkBxKRtZIXsXYuISiTRvOKG7qoidOYv6mMcnmT8UyyYzWaMycefrcOG++GuzZ+ouFjTLnQJxJk/jXexfOtjY+Wx3T7f4+uoOTOzWGsIrjYbDybvDzqvH0KdZmfU9iyjYvENgpeVqywLdnNmeedhgQskAL3PbVvF7AOvN3OmtOvY6CT4QKBgQC+5YU7UOTIuAK7rQwHXOh+7puInrWPEEBSVmW5uH/L4YH6qs1PBGdXiiS+hu+KNDNMeht366suvSm3G2ZV6svpG6omBhvvWmbQEsl1++SKO2kVdlLMIW3p23BQJvH8y5faT5Ml+mV4k0g6WAU61jmZ/SdTKupioFWZ+fjBBYyUAwKBgQCxnI0Efadb9YSaomlOP8YE4z5BMYU2iGTyPU7yk99opGAEr83QHf5/p2n/rCMfcBOGfxFI9JEmjRxXdDShTQhmMk4BRPXXsBGQWSyN/ZfQ+qCjzKi5I1LovRkhUVOG8S5rpUbc+B0q91Dez8nfzGXQImxxcwRRwtYcTqHcbYJznQKBgGLNaKfKtp8snj2E0zT8YVlRJi8P9eiWALSdAwmc9IgRr7SNsrWzEcm9Nkdmj5R4cBSlHpJy56bJQU4EYHMXk3KTXv1PLCY2JACNuLfYJ/Fjzn/NPg1pP/pKGVdi0NyGg5H6na6Kavp9QGTyKcLKHgYVgMUK8UUatzN6rcU5mgkBAoGALRfhGbXJSuivzQ7VC5/XZ6BGSwkGmEzSzEnShHYUr52kHyx/ZYpn9gMMP3R1ymKLIoeaXNpzC8Wh33ZKcnV7X28ALQRUInm6S9rIHBi5db5cEJpCcBbO0vZHrhTWzxjmvz/MGQgJZ8I4zwkUaPSdGNXUkI0yGIwODkvMfolzKGUCgYBY2R6Kd/KYgsMdk3eYQ3npdFpwGLSVH/V7F30lpc8dL9s3ZDNI4mmZLs/Unqla+mwaAN5+uadHfTz1334naFhOHiXrU6fjnrEL7Il9xf9v9rCEldY/q9fg4AWIk4czxxpmGx65IXA40V5T2loNo8kNmxGwkd+zJ9kgl0AAS7OTpQ==";
    @Value("${aliPay.publicKey}")
    private  String publicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhHFuIva+GQdbPaQLNYhG/WuvPYYGb30/Udz6rYh95S4xupwARClDZH+gwSXht0QsLUIkYUa2h7KNUlWebBMdV5UB4duTOq66H0k+TW3K0gRIijtbkwU5CgLzyOsqw7KGyrbipykAHNe3LttSz+CmbH2e/1SoK1tRSV20WLwUdMy1NHVjqZNeclhdUxkSeQtWG18m7EqcYYjOJMPET+/4PVgGbbvdPxJTOktbVqBNF6sbkfCOjT/suZxATeDtIAQ11Y0iK2Hk4gA6yCwA9igkEanXSvJ5RvUt+wPlNLAdHLKr7B8YGACvLMRKswXPwmMyWPYpbmbZpGrVPQXa/joe1wIDAQAB";
    @Value("${aliPay.aliPublicKey}")
    private  String aliPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4V9lxzO9ocOwippX6MUCER0HZGILOSzGwUmOd1MACDrbTdySovgLvsvzRg+jQ9uZbH1YTIWg9V0tPyXdQSp6kEbNQl4x7nAuYZSZ5JqQXEVU6zy+M1xl3sZ5eqvuf7BMK4nd4b1fbuV9Ht8QhdbPrTTdUvYdLeMl57wBZF9oR9qjkZi+L0JhtxX7eHbrZqlnGCSSCmvrHMkqokvxRjb1z2UzgU2vPEr5ijyFosHdrSCm8iE+xdoXpkyX53/Zm8W6InQ3Ls2ASWN4npfEB/bymM5CgaFQEuvV5aNBKjUNmpWXFFnk3z/3YOHuh4I6IfMgHMrR6zFv/Ob8hWW57+pvGwIDAQAB";
    @Value("${aliPay.format}")
    private  String format="JSON";
    @Value("${aliPay.charset}")
    private  String charset="UTF-8";
    @Value("${aliPay.signType}")
    private  String signType="RSA2";
    @Value("${aliPay.returnUrl}")
    private  String returnUrl="http://localhost:8080/aliPay/callBack";
    @Value("${aliPay.notifyUrl}")
    private  String notifyUrl="http://localhost:8080/aliPay/callBack";

    public AlipayUtil() {
        ALIPAY_CLIENT_PAGE= new DefaultAlipayClient(serverUrl,appId,privateKey,format,charset,publicKey,signType);
        ALIPAY_CLIENT_QUERY= new DefaultAlipayClient(serverUrl,appId,privateKey,format,charset,aliPublicKey,signType);
    }

    public String generateAliPayTradePagePayRequestForm(String orderId, String orderSubject, double price) throws AlipayApiException, JsonProcessingException {
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        aliPayRequest.setReturnUrl(returnUrl);
        aliPayRequest.setNotifyUrl(notifyUrl);//在公共参数中设置回跳和通知地址
        BizContent bizContent = new BizContent(orderId, price, orderSubject);
        String s = new ObjectMapper().writeValueAsString(bizContent);
        aliPayRequest.setBizContent(s);

        return ALIPAY_CLIENT_PAGE.pageExecute(aliPayRequest).getBody(); //调用SDK生成表单
    }
    public static boolean generateAlipayTradeQueryRequest(String orderId) throws AlipayApiException {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\""+orderId+"\"" +
                "  }");
        AlipayTradeQueryResponse response = ALIPAY_CLIENT_QUERY.execute(request);
        if(response.isSuccess()){
            String tradeStatus = response.getTradeStatus();
            if (TradeStatus.TRADE_SUCCESS.name().equals(tradeStatus)){
                return true;
            }
            System.out.println(tradeStatus);
        }

        return false;
    }

    public boolean check(Map<String,String[]> requestParams){
        try {
            return AlipaySignature.rsaCheckV1(convert(requestParams), aliPublicKey, charset, signType);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean check_(Map<String,String[]> requestParams){
        try {
            return AlipaySignature.rsaCheckV2(convert(requestParams), aliPublicKey, charset, signType);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws AlipayApiException, JsonProcessingException {


    }
    private static Map<String,String> convert(Map<String,String[]> requestParams){
        Map<String,String> result=new HashMap<>();
        if (requestParams!=null&&requestParams.size()>0){
            Set<Map.Entry<String, String[]>> entrySet = requestParams.entrySet();
            for (Map.Entry<String, String[]> entry : entrySet) {
                if (!entry.getKey().equals("func")){
                    result.put(entry.getKey(),entry.getValue()[0]);
                }

            }
        }
        return result;
    }
    public static enum TradeStatus {
        WAIT_BUYER_PAY,TRADE_CLOSED,TRADE_SUCCESS,TRADE_FINISHED
    }
    public static class BizContent{
        //商户交易订单号
        private String out_trade_no;
        //销售产品码，与支付宝签约的产品码名称。
        //注：目前仅支持FAST_INSTANT_TRADE_PAY
        private String product_code="FAST_INSTANT_TRADE_PAY";
        //订单的总金额
        private double total_amount;
        //订单标题 必选
        private String subject;
        //	订单描述 可选
        private String body;

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getProduct_code() {
            return product_code;
        }

        public void setProduct_code(String product_code) {
            this.product_code = product_code;
        }

        public double getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(double total_amount) {
            this.total_amount = total_amount;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        private  BizContent(String out_trade_no, double total_amount, String subject) {
            this.out_trade_no = out_trade_no;
            this.total_amount = total_amount;
            this.subject = subject;
        }

    }


}
