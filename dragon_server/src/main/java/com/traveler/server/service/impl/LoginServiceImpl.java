package com.traveler.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.traveler.server.mapper.LoginMapper;
import com.traveler.server.model.entity.User;
import com.traveler.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;


    @Override
    public User selectByName(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("username",username);
        User user = loginMapper.selectOne(wrapper);
        if (user != null) return user;
        return null;
    }
}
