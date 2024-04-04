package jfs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jfs.backend.service.CategoryService;

@SpringBootApplication
public class JpaManyToManyMapping2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JpaManyToManyMapping2Application.class, args);
		
		CategoryService ca = context.getBean(CategoryService.class);
		System.out.println("0");
		ca.categoryData();
	}

}
