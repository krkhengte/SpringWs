package jfs.backend.bms.apigateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookMyShowApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApiGatewayApplication.class, args);
	}

}
