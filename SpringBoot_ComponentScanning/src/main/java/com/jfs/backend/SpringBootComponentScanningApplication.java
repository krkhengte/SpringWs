package com.jfs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.jfs.backend.Security.Security;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jfs.backend","com.st.backend"}) // To Create the More than one base Package
public class SpringBootComponentScanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootComponentScanningApplication.class, args);
	}


	
}
