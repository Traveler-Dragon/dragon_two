package com.traveler.gateway.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebMvcConfigurerConfig implements WebMvcConfigurer {


//    // UI界面的配置
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
////        原始的swagger 如果没有用到原始的可以不用谢
//        registry.addResourceHandler("swagger-ui.html")
//              .addResourceLocations("classpath:/META-INF/resources/");
//
////        registry.addResourceHandler("doc.html").
////                addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**").
//                addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("doc.html").
                addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
