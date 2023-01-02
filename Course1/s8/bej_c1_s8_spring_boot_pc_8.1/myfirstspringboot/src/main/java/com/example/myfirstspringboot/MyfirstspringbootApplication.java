package com.example.myfirstspringboot;

import com.example.myfirstspringboot.services.Greet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyfirstspringbootApplication {

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(MyfirstspringbootApplication.class, args);
		Greet greet=ac.getBean("greet", Greet.class);
		System.out.println(greet.greetingMessage());
	}

}
