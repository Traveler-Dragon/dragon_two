package com.traveler.server.controller;

import com.alibaba.fastjson.JSON;
import com.traveler.server.model.bo.BaseResponse;
import com.traveler.server.rabbitmq.QueueEnum;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("push")
    public BaseResponse push(){
        rabbitTemplate.convertAndSend(QueueEnum.QUEUE_TTL_RECHARGE_ORDER.getExchange(), QueueEnum.QUEUE_TTL_RECHARGE_ORDER.getRouteKey(), "test", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                message.getMessageProperties().setDelay(6000);
                return message;
            }
        });
        return BaseResponse.success();
    }
}
