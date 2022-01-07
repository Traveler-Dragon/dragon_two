package com.traveler.server.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Map;

@Slf4j
@Component
@Aspect
public class AspectRed {

    @Pointcut(value = "execution(public * com.traveler.server.controller.AspectController.web*(..))")
    public void pointcut(){}


    @Before("pointcut()")
    public void auth(){
       log.info("切面拦截到web相关接口--------------------------------------");

    }

}
