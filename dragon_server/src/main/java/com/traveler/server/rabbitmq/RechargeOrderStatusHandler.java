package com.traveler.server.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 伏守龙
 */
@Slf4j
@Component
@RabbitListener(queues = "recharge.order.status.queue")
public class RechargeOrderStatusHandler {

    @RabbitHandler
    public void rechargeOrderStatusHandler(String info, Message msg, Channel channel) throws IOException {
        Integer delay = msg.getMessageProperties().getDelay();
        log.info("RechargeOrderStatusHandler -> 过期时间为:  {}",delay);
        log.info("RechargeOrderStatusHandler -> 接收的消息为:  {}",info);
    }
}
