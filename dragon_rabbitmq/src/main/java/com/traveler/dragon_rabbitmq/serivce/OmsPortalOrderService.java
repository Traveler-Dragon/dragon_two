package com.traveler.dragon_rabbitmq.serivce;

import com.traveler.dragon_rabbitmq.common.dto.CommonResult;
import com.traveler.dragon_rabbitmq.common.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
