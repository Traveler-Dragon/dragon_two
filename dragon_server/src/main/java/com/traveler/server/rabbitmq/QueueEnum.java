package com.traveler.server.rabbitmq;

import lombok.Getter;

/**
 * @author 伏守龙
 */
@Getter
public enum QueueEnum {
    /**
     * 订单状态查询(延迟队列)
     */
    QUEUE_TTL_RECHARGE_ORDER("recharge.order.status.exchange","recharge.order.status.queue","recharge.order.status.routeKey");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String queue;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String queue, String routeKey) {
        this.exchange = exchange;
        this.queue = queue;
        this.routeKey = routeKey;
    }
}
