package com.traveler.server.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@TableName(value = "config")
public class Config {

    private Long id;
    private String cron;

}
