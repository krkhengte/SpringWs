package jfs.backend.bms.theater.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookMyShowTheaterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowTheaterServiceApplication.class, args);
	}

}
