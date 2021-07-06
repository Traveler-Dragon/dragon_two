package com.traveler.server.model.entity;

import lombok.Data;

@Data
public class QuartzJob {
    private String cron;
    private String jobName;
    private String jobGroup;

}
