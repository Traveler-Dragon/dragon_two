package com.traveler.server;

import com.traveler.server.util.SnowFlake;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(basePackages = "com.traveler.server")
@SpringBootApplication
@MapperScan("com.traveler.server.mapper")
@EnableAsync
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

//    @Bean
//    public SnowFlake snowFlake(){
//        return new SnowFlake(1,1);
//    }

}
