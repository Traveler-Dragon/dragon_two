package com.traveler.server.service;

import com.traveler.server.model.entity.User;

public interface LoginService {
    User selectByName(String username);
}
