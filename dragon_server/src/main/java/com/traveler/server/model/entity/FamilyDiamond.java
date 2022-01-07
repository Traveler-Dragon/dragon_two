package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDiamond extends BaseString {

    @TableField(value = "diamond_name")
    private String diamondName;

    @TableField(value = "diamond_amount")
    private BigDecimal diamondAmount;

    @TableField(value = "pay_amount")
    private BigDecimal payAmount;

    @TableField(value = "icon")
    private String icon;

    @TableField(value = "system")
    private Integer system;

    @TableField(value = "discounts")
    private String discounts;
}
