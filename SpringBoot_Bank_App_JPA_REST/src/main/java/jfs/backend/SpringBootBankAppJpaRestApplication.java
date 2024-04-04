package jfs.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class SpringBootBankAppJpaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBankAppJpaRestApplication.class, args);

	}

	@Bean
	public org.modelmapper.ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
