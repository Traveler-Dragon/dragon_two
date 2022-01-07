package com.traveler.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.traveler.server.mapper.ConfigMapper;
import com.traveler.server.model.entity.Config;
import com.traveler.server.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private RedissonClient redissonClient;

    private int count = 50;

    @Override
    public int addOrderSn(String concat) {
        Config config = new Config();
//        config.setId(Long.parseLong(concat));
        config.setOrderSn(concat);
        return configMapper.insert(config);
    }

    @Override
    public List<Config> getOrderSn() {
        QueryWrapper<Config> configQueryWrapper = new QueryWrapper<>();
        configQueryWrapper.last("limit 0,10");
        return configMapper.selectList(configQueryWrapper);
    }

    @Override
    public void redissonTest(String lockKey) {
        int waitTimeout = 1;
        int leaseTime = 2;
        RLock rLock = redissonClient.getLock(lockKey);
        try {
            /**
             * 4.尝试获取锁
             * waitTimeout 尝试获取锁的最大等待时间，超过这个值，则认为获取锁失败
             * leaseTime   锁的持有时间,超过这个时间锁会自动失效（值应设置为大于业务处理的时间，确保在锁有效期内业务能处理完）
             */
            boolean res = rLock.tryLock((long)waitTimeout, (long)leaseTime, TimeUnit.SECONDS);
            if (res) {
                //成功获得锁，在这里处理业务
                log.info(Thread.currentThread().getName() + "获得了锁");
                log.info("业务处理的次数为: {}",--count);
            }
        } catch (Exception e) {
            throw new RuntimeException("aquire lock fail");
        }finally{
            //无论如何, 最后都要解锁
            rLock.unlock();
        }
    }
}
