package com.niit.project;

import com.niit.project.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ProductDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDetailsApplication.class, args);
	}
		@Bean
		public FilterRegistrationBean jwtFilter(){
			FilterRegistrationBean frb = new FilterRegistrationBean();

			frb.setFilter(new JwtFilter());
			frb.addUrlPatterns("http://localhost:65100/api/v1/user/userName/products");

			return frb;
		}
	}
