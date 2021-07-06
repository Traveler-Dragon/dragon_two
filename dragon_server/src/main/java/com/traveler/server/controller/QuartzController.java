package com.traveler.server.controller;

import com.traveler.server.model.entity.QuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/quartz")
@Slf4j
public class QuartzController {
    @Resource(name = "jobDetail")
    private JobDetail jobDetail;

    @Resource(name = "jobTrigger")
    private CronTrigger cronTrigger;

    @Resource(name = "scheduler")
    private Scheduler scheduler;

    @PostMapping("/update")
    public void scheduleUpdateCronTrigger(@RequestBody QuartzJob quartzJob) throws SchedulerException {
        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzJob.getCron());
        // 按新的cronExpression表达式重新构建trigger
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
        trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey())
                .withSchedule(scheduleBuilder).build();
        // 按新的trigger重新设置job执行
        scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
    }
}
