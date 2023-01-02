package com.niit.usermovieservice;

import com.niit.usermovieservice.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class UserProductServiceApplication {

	public static void main(String[] args) {
		//entry point
		SpringApplication.run(UserProductServiceApplication.class, args);

	}
	//filtering JWT token
	@Bean
	FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new JwtFilter());
		frb.addUrlPatterns("http://localhost:8085/shopping/product");
		return frb;
	}
}
