package com.traveler.gateway.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Primary
public class DocumentConfig implements SwaggerResourcesProvider {

    @Autowired
    private ZuulProperties zuulProperties;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> swaggerResources = new ArrayList<>();
        Map<String, ZuulProperties.ZuulRoute> routes = zuulProperties.getRoutes();
//        swaggerResources.add(initSwaggerResource("user111","/user/v2/api-doces","1.0.0"));
//        swaggerResources.add(initSwaggerResource("auth","/auth/v2/api-doces","1.0.0"));

        for (String serviceName : routes.keySet()) {

            SwaggerResource swaggerResource = initSwaggerResource(serviceName,
                      "/"+serviceName + "/v2/api-docs", "2.0.0");
            swaggerResources.add(swaggerResource);
        }
        return swaggerResources;
    }

    private SwaggerResource initSwaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}