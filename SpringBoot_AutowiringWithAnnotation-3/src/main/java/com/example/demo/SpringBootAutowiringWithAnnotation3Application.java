package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.details.Parent;

@SpringBootApplication
public class SpringBootAutowiringWithAnnotation3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootAutowiringWithAnnotation3Application.class, args);
		Parent bean = context.getBean(Parent.class);
		bean.display();
	
	}

}
