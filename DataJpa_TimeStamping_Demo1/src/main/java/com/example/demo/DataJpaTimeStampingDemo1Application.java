package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootApplication
public class DataJpaTimeStampingDemo1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DataJpaTimeStampingDemo1Application.class, args);
		ProductRepository bean = context.getBean(ProductRepository.class);
		
		Product p1=new Product();
	
		p1.setPName("Mouse");
		p1.setPrice(600.00);
		
		
		bean.save(p1);
	}

}
