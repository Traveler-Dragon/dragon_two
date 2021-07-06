package com.traveler.dragon_oauth2_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@EnableOAuth2Sso
@SpringBootApplication
public class DragonOauth2ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DragonOauth2ClientApplication.class, args);
    }

}
