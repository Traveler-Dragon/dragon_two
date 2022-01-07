package com.traveler.server.controller;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.traveler.server.model.bo.BaseResponse;
import com.traveler.server.model.dto.LoginDto;
import com.traveler.server.model.dto.ShandwDto;
import com.traveler.server.model.entity.Config;
import com.traveler.server.model.entity.ImageCache;
import com.traveler.server.model.entity.OrderInfo;
import com.traveler.server.model.entity.User;
import com.traveler.server.service.TestService;
import com.traveler.server.util.IdWorker;
import com.traveler.server.util.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/dragon")
@Slf4j
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TestService testService;


//    @GetMapping("getOrderId")
//    public BaseResponse getOrderId(){
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
//        String concat = format.format(new Date()).concat(Long.toString());
//        testService.addOrderSn(concat);
//        log.info("订单长度为: {}",concat.length());
//        return BaseResponse.success(concat);
//    }

    @PostMapping("/redissonTest")
    public BaseResponse redissonTest(){
        testService.redissonTest("lockKey");
        return BaseResponse.success();
    }

    @GetMapping("/setOrderSn")
    public BaseResponse setOrderSn(){
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String concat = format.format(date).concat(String.valueOf(System.currentTimeMillis()).substring(11)).concat(createNonceStr(2));
        int result = testService.addOrderSn(concat);
        log.info("添加订单结果: "+result);
        return BaseResponse.success(concat);
    }

    @GetMapping("/getOrderSn")
    public BaseResponse getOrderSn(){
        List<Config> configs = testService.getOrderSn();
        log.info("添加订单结果: "+configs);
        return BaseResponse.success(configs);
    }

    @GetMapping("/redisZSet")
    public BaseResponse redisZSet(){
        redisTemplate.opsForZSet().add("test","test01",1);
        redisTemplate.opsForZSet().add("test","test02",1);
        redisTemplate.opsForZSet().add("test","test03",1);
        return BaseResponse.success();
    }

    @GetMapping("/redisZCount")
    public BaseResponse redisZCount(@RequestParam("value") String value){
        Double score = redisTemplate.opsForZSet().score("test", value);
        redisTemplate.opsForZSet().add("test",value,score++);
        return BaseResponse.success();
    }

    @GetMapping("/redisZRange")
    public BaseResponse redisZRange(){
        Set test = redisTemplate.opsForZSet().reverseRange("test", 0, -1);
        return BaseResponse.success(test);
    }

    @GetMapping("/redisSize")
    public BaseResponse redisSize(){
        long count = redisTemplate.opsForZSet().size("test");
        return BaseResponse.success(count);
    }

    @GetMapping("/redisHash")
    public BaseResponse redisHash(@RequestParam("categoryId") Integer categoryId,
                                  @RequestParam("goodsId") Integer goodsId){
        redisTemplate.opsForHash().put("family_goods:"+categoryId,goodsId,"goodsClass");
        return BaseResponse.success();
    }
    @GetMapping("/redisHashGet")
    public BaseResponse redisHashGet(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                                  @RequestParam(value = "goodsId",required = false) Integer goodsId){
//        redisTemplate.opsForHash().put("family_goods:"+categoryId,goodsId,"goodsClass");
        Set keys = redisTemplate.opsForHash().keys("family_goods:"+categoryId);
//        String c = redisTemplate.opsForHash().get("family_goods:"+categoryId, null).toString();
        Map entries = redisTemplate.opsForHash().entries("family_goods:" + categoryId);
        redisTemplate.opsForHash();
        log.info("数据:   "+entries);
        return BaseResponse.success(entries);
    }

    @PostMapping("/orderInfo")
    public BaseResponse orderInfo(@Valid @RequestBody OrderInfo orderInfo){
        log.info(orderInfo.toString());
        boolean flag = checkSign(orderInfo);
        if (!flag) {
            return BaseResponse.error();
        }
        return BaseResponse.success();
    }

    private boolean checkSign(OrderInfo orderInfo) {
        String apikey = "f89f3c3f345f4643a80d63a009c1b9b5";
        StringBuffer signStr = new StringBuffer();
        signStr.append("order_id="+orderInfo.getOrder_id());
        signStr.append("&channel="+orderInfo.getChannel());
        signStr.append("&appid="+orderInfo.getAppid());
        if (StringUtils.isNotBlank(orderInfo.getAppname())) signStr.append("&appname="+orderInfo.getAppname());
        signStr.append("&uid="+orderInfo.getUid());
        if (StringUtils.isNotBlank(orderInfo.getAppname())) signStr.append("&openId="+orderInfo.getOpenId());
        signStr.append("&cpOrderId="+orderInfo.getCpOrderId());
        if (StringUtils.isNotBlank(orderInfo.getAppname())) signStr.append("&pay_ordernum="+orderInfo.getPay_ordernum());
        if (orderInfo.getPay_platform() != null) signStr.append("&pay_platform="+orderInfo.getPay_platform());
        signStr.append("&money="+orderInfo.getMoney());
        if (StringUtils.isNotBlank(orderInfo.getAppname())) signStr.append("&obj="+orderInfo.getObj());
        if (orderInfo.getFcmoney_pt() != null) signStr.append("&fcmoney_pt="+orderInfo.getFcmoney_pt());
        signStr.append("&pay_time="+orderInfo.getPay_time());
        signStr.append("&key="+apikey);
        System.out.println(signStr);
        return orderInfo.getSign().equals(DigestUtils.md5Hex(signStr.toString()).toLowerCase());
    }

    @GetMapping("/test")
    public BaseResponse getTest(@Param("access_token") String access_token){
        String result = null;
        if (StringUtils.isNotBlank(ImageCache.getCache("access_token"))){
            System.out.println("获取的参数:  "+ImageCache.getCache("access_token"));
            result = ImageCache.getCache(access_token);
        }else {
            System.out.println("发送请求");
            System.out.println("获取校验参数");
            ImageCache.setCache("access_token","24.ee319bc31b412125c1afd04f52c39699.2592000.1620806198.282335-23975269");
            result = "24.ee319bc31b412125c1afd04f52c39699.2592000.1620806198.282335-23975269";
        }

        return new BaseResponse("200",result,"success");
    }


    @GetMapping("getInt")
    public String getInt(@RequestParam(value = "code",required = false) Integer code){
        if (null == code){
            log.info("###############"+code);
            return "error";
        }
        return "success";
    }


    @PostMapping("io")
    public String getInt(HttpServletRequest request, @RequestBody LoginDto loginDto) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String inputStr;
        while ( (inputStr = bufferedReader.readLine()) != null) {
            stringBuffer.append(inputStr);
        }
        return stringBuffer.toString();
    }

    @GetMapping("getShandw")
    public String getShandw(ShandwDto shandw) throws IOException {
        shandw.setOpenid(UUID.randomUUID().toString().replace("-",""));
        shandw.setTime(System.currentTimeMillis()/1000+"");
        String sign = getSign(shandw.getChannel(),shandw.getOpenid(),shandw.getNick(),shandw.getTime(),shandw.getAvatar(),shandw.getSex(),shandw.getPhone());
        Map<String,Object> param = new HashMap<>();
        param.put("channel",shandw.getChannel());
        param.put("openid",URLEncoder.encode(shandw.getOpenid(),"utf-8"));
        param.put("time",shandw.getTime());
        param.put("nick",URLEncoder.encode(shandw.getNick(),"utf-8"));
        param.put("avatar",URLEncoder.encode(shandw.getAvatar(),"utf-8"));
        param.put("sex",shandw.getSex());
        param.put("phone",shandw.getPhone());
        param.put("sign",sign);
        String urlParam = "channel="+param.get("channel")+"&openid="+param.get("openid")+"&time="+param.get("time")+"&nick="+param.get("nick")+"&avatar="+param.get("avatar")+"&sex="+param.get("sex")+"&phone="+param.get("phone")+"&sign="+param.get("sign");
        String url = "http://www.shandw.com/auth?"+urlParam+"&sdw_simple=2"+"&sdw_ld=1"+"&sdw_kf=1"+"&sdw_dl=1"+"&sdw_bt=1"+"&sdw_sy=1";
        log.info(url);
//        String result = HttpUtil.get(url);

//        HttpResponse execute = HttpRequest.get("http://www.shandw.com/auth").form(param).execute();
//        log.info(execute.body());


//        log.info(result);
        return url;
    }
    private static String getSign(String channel, String openid, String nick, String time, String avatar, String sex, String phone) throws UnsupportedEncodingException {
        String openidEncode = URLEncoder.encode(openid, "utf-8");
        String appKey = "f89f3c3f345f4643a80d63a009c1b9b5";
        String sign = "channel="+channel+"&"+"openid="+openidEncode+"&"+"time="+time+"&"+"nick="+nick+"&"+"avatar="+avatar+"&"+"sex="+sex+"&"+"phone="+phone+appKey;
//        String sign = "channel=12285&openid=100054&time=1557292378&nick=100054&avatar=http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLulCY6cfQwbttEgfbB8FhvnEjreK0xyQ64kvpxBDoPtpu91zca698msIkKpaBQPf8lkq1cm76gZA/132&sex=0&phone=59fd17f5fe6c41f192f20a577e8fad34";
        System.out.println(sign);
        return DigestUtils.md5Hex(sign).toLowerCase();
    }

    private String createNonceStr(int size) {
        StringBuilder res = new StringBuilder();
        String chars = "0123456789";
        for (int i = 0; i < size; i++)
        {
            Random rd = new Random();
            res.append(chars.charAt(rd.nextInt(chars.length() - 1)));
        }
        return res.toString();
    }

}
