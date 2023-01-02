package com.sprint4.productdetails;

import com.sprint4.productdetails.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductdetailsApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean frb=new 	FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/mart/product");
		return frb;
	}
}