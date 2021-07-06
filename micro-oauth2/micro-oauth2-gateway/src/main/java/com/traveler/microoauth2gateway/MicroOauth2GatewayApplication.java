package com.traveler.microoauth2gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroOauth2GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroOauth2GatewayApplication.class, args);
    }

}
