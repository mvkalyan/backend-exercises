package com.niit.project.config;

import com.niit.project.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig
{
    @Bean
    public FilterRegistrationBean jwtFilterBean(){
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();

        filterRegistration.setFilter(new JwtFilter());
        filterRegistration.addUrlPatterns("/api/v1/user/*");

        return filterRegistration;
    }
}
