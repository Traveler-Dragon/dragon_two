package com.traveler.server.controller;

import com.traveler.server.model.bo.BaseResponse;
import com.traveler.server.model.dto.LoginDto;
import com.traveler.server.model.entity.User;
import com.traveler.server.model.enums.PlatformEnum;
import com.traveler.server.service.LoginService;
import com.traveler.server.util.BusinessLog;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/server")
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录",notes = "登录")
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code = 602, message = "用户名或密码错误!"),
            @ApiResponse(code = 601, message = "用户不存在!"),
    })
    @BusinessLog(value = "登录",platForm = PlatformEnum.WEB,param = "username")
    @PostMapping("login")
    public BaseResponse login(@Valid @RequestBody LoginDto login){
        log.info("获取的用户:{}",login.getUsername());

        User user = loginService.selectByName(login.getUsername());
        if (user == null){
            return BaseResponse.error("601","用户不存在!");
        }
        if (login.getPassword().equals(user.getPassword())){
            return BaseResponse.success();
        }
        return BaseResponse.error("602","用户名或密码错误!");

    }
}
