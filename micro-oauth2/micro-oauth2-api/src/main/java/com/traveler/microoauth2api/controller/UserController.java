package com.traveler.microoauth2api.controller;

import com.traveler.microoauth2api.domain.UserDTO;
import com.traveler.microoauth2api.holder.LoginUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取登录用户信息接口
 * Created by macro on 2021/7/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LoginUserHolder loginUserHolder;

    @GetMapping("/currentUser")
    public UserDTO hello(){
        return loginUserHolder.getCurrentUser();
    }
}
