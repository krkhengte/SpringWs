package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.service.EmployeeService;

@SpringBootApplication
public class DataJpaCompositPkTransactionMngApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DataJpaCompositPkTransactionMngApplication.class, args);
		
		EmployeeService bean = context.getBean(EmployeeService.class);
		bean.saveData();
	}

}
