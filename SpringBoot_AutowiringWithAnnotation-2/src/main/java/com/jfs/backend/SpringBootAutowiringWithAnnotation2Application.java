package com.jfs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jfs.backend.service.ServiceDemo;

@SpringBootApplication
public class SpringBootAutowiringWithAnnotation2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringBootAutowiringWithAnnotation2Application.class, args);
		ServiceDemo bean = context.getBean(ServiceDemo.class);
		bean.displayData();
	}

}
