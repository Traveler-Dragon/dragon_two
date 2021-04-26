package com.traveler.dragon.controller;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import com.traveler.dragon.model.bo.ResponseBo;
import com.traveler.dragon.model.entity.ImageCache;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

@RestController
@RequestMapping("/dragon")
@Slf4j
public class TestController {
    TimedCache<String,String> timedCache = CacheUtil.newTimedCache(1000);
    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/test")
    public ResponseBo getTest(@Param("access_token") String access_token){
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

        return new ResponseBo("200",result,"success");
    }
    @GetMapping("/addr")
    @ResponseBody
    public ResponseBo getAddr(HttpServletRequest request){
        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCaptchaVerification("123213");
        ResponseModel verification = captchaService.verification(captchaVO);
        String repCode = verification.getRepCode();

        log.info("###########   {}",repCode);

        log.info("##### 获取的addr为: "+request.getRemoteAddr());
        log.info("##### 获取的host为: "+request.getRemoteHost());
        return new ResponseBo("200","","success");
    }


}
