package com.jfs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jfs.backend.service.ReportService;

@SpringBootApplication
public class SpringBootAutowiringWithAnnotationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootAutowiringWithAnnotationApplication.class, args);
		ReportService rs = context.getBean(ReportService.class);
		rs.generateReport();
	
	}

}
