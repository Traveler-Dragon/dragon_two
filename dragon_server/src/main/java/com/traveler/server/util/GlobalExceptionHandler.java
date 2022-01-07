package com.traveler.server.util;

import com.baomidou.mybatisplus.extension.api.R;
import com.traveler.server.model.bo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 请求方式不支持
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    public R handleException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        return R.failed("不支持' " + e.getMethod() + "'请求");
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) throws Exception {
        log.error(e.getMessage(), e);
        return R.failed(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
//        return CommonResult.validateFailed(message);
//
//        //日志记录错误信息
//        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        log.error("=================校验器触发错误================" + message);
//        //将错误信息返回给前台
        return BaseResponse.error("500",message);
    }

}
