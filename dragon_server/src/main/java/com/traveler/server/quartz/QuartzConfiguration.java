package com.traveler.server.quartz;

import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfiguration {

    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask task){// ScheduleTask为需要执行的任务
        MethodInvokingJobDetailFactoryBean jobDetail  = new MethodInvokingJobDetailFactoryBean();

        jobDetail.setConcurrent(false);//true 不论任务是否执行完成 下一个任务都会执行  false 等待上一个任务执行完 在执行下一个任务
        jobDetail.setName("dragon-job-one");//设置任务名字
        jobDetail.setGroup("traveler");//设置任务的分组, 这些属性都可以存储在数据库中, 再多任务时使用
        jobDetail.setTargetObject(task);//执行的实体类对象

        jobDetail.setTargetMethod("sayHello");
        return jobDetail;
    }
    /**
          * attention:
          * Details：配置定时任务的触发器，也就是什么时候触发执行定时任务
          */
    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(jobDetail.getObject());
        tigger.setCronExpression("0/30 * * * * ?");// 初始时的cron表达式
        tigger.setName("dragon-trigger-one");// trigger的name
        return tigger;

    }

    /**
          * attention:
          * Details：定义quartz调度工厂
          */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger cronJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        bean.setOverwriteExistingJobs(true);
        // 延时启动，应用启动1秒后
        bean.setStartupDelay(1);
        // 注册触发器
        bean.setTriggers(cronJobTrigger);
        return bean;
    }


}
