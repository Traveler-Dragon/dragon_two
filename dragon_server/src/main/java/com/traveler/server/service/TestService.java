package com.traveler.server.service;

import com.traveler.server.model.entity.Config;

import java.util.List;

public interface TestService {
    int addOrderSn(String concat);

    List<Config> getOrderSn();

    void redissonTest(String lockKey);
}
