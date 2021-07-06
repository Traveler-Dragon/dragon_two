package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {
    @TableField(value = "username",strategy = FieldStrategy.NOT_NULL)
    private String username;
    @TableField(value = "password",strategy = FieldStrategy.NOT_NULL)
    private String password;
}
