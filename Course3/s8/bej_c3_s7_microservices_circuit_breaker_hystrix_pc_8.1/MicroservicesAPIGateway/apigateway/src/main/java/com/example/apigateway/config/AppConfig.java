package com.example.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator getRealRoute(RouteLocatorBuilder rlb){
        return rlb.routes().
                route(p->
                        p.path("/api/jwt/**").
                                uri("http://localhost:8085/*")).
                route(p->
                        p.path("/mart/**").
                                uri("http://localhost:65100/*")).
                build();
    }
}