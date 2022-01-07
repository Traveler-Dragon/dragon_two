package com.traveler.server.util;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
//@ConfigurationProperties(prefix = "dragon")
public class XxlJobConfig {

    @Value("${dragon.admin.address}")
    private String adminAddresses;

    @Value("${dragon.accessToken}")
    private String accessToken;

    @Value("${dragon.executor.appname}")
    private String appname;

    @Value("${dragon.executor.address}")
    private String address;

    @Value("${dragon.executor.ip}")
    private String ip;

    @Value("${dragon.executor.port}")
    private Integer port;

    @Value("${dragon.executor.logpath}")
    private String logPath;

    @Value("${dragon.executor.logretentiondays}")
    private Integer logRetentionDays;

    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appname);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobSpringExecutor;
    }
}
