package com.traveler.server.rabbitmq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * @author haoyabo
 */
@Slf4j
@Configuration
public class MQConfig {

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }

    /**
     * 充值订单交换机(延迟队列)
     */
    @Bean
    DirectExchange rechargeOrderTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_TTL_RECHARGE_ORDER.getExchange())
                .durable(true)
                .delayed()
                .build();
    }

    /**
     * 充值订单队列(延迟队列)
     */
    @Bean
    public Queue rechargeOrderTtlQueue() {
        return QueueBuilder
                .durable(QueueEnum.QUEUE_TTL_RECHARGE_ORDER.getQueue())
                .build();
    }

    /**
     * 将充值订单队列绑定到交换机(延迟队列)
     */
    @Bean
    Binding rechargeOrderTtlBinding(DirectExchange rechargeOrderTtlDirect, Queue rechargeOrderTtlQueue){
        return BindingBuilder
                .bind(rechargeOrderTtlQueue)
                .to(rechargeOrderTtlDirect)
                .with(QueueEnum.QUEUE_TTL_RECHARGE_ORDER.getRouteKey());
    }
}
