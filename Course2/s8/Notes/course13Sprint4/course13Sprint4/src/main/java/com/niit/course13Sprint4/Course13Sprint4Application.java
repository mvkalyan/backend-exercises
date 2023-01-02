package com.niit.course13Sprint4;

import com.niit.course13Sprint4.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Course13Sprint4Application {

	public static void main(String[] args) {
		SpringApplication.run(Course13Sprint4Application.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter(){
		//return list of incerpted URLs with defined JwtFilter class

		FilterRegistrationBean frb=new 	FilterRegistrationBean();
		frb.setFilter(new JwtFilter());
		//frb.addUrlPatterns("/customerdata/customer");//addCustomer
		frb.addUrlPatterns("/customerdata/*");//addCustomer
		return frb;
	}

}
