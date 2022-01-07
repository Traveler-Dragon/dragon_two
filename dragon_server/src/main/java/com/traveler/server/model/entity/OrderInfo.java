package com.traveler.server.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderInfo {


    @NotNull(message = "订单ID不能为空")
    @Range(message = "id只能是0或者1",min = 0,max = 1)
    private Integer order_id;

    @NotBlank(message = "渠道ID不能为空")
    private String channel;

    @NotBlank(message = "游戏ID不能为空")
    private String appid;

    private String appname;

    @NotNull(message = "用户ID不能为空")
    private Integer uid;

    private String openId;

    @NotBlank(message = "订单号不能为空")
    private String cpOrderId;

    private String pay_ordernum;

    private Integer pay_platform;

    @NotNull(message = "重置金额不能为空")
    private Integer money;//单位: 分

    private String obj;

    private Integer fcmoney_pt;

    @NotNull(message = "支付时间戳不能为空")
    private Integer pay_time;

    @NotBlank(message = "签名不能为空")
    private String sign;
}
