package com.traveler.server.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
public class WebAspect {

    @Pointcut(value = "@annotation(com.traveler.server.util.BusinessLog)")
    public void pointcut(){}


    @Around("pointcut()")
    public Object writeLog(ProceedingJoinPoint point ) throws Throwable {

        Object proceed = point.proceed();

        try {
            handle(point);
        }catch (Exception e){
            log.error("日志记录出错",e);
        }

        return proceed;
    }

    private void handle(ProceedingJoinPoint point) throws NoSuchMethodException, IOException {
        MethodSignature ms = (MethodSignature) point.getSignature();
        Object target = point.getTarget();
        Method method = target.getClass().getMethod(ms.getName(), ms.getParameterTypes());

        BusinessLog annotation = method.getAnnotation(BusinessLog.class);
        String value = annotation.value();
        String param = annotation.param();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String inputStr;
        while ( (inputStr = bufferedReader.readLine()) != null) {
            stringBuffer.append(inputStr);
        }

        Map<String,String> map = JSONObject.parseObject(stringBuffer.toString(), Map.class);


        log.info("{} | {} - {} {} 请求参数: {}", value, request.getRemoteAddr(),request.getMethod(),request.getRequestURI(),map.get(param));
    }

}
