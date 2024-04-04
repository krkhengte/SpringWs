package com.jfs.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jfs.backend.repository.AccountRepository;
import com.jfs.backend.service.AccountService;
import com.jfs.backend.service.LoginAccount;

@SpringBootApplication
public class FirstBankApplicationSbiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstBankApplicationSbiApplication.class, args);
		AccountRepository ar = context.getBean(AccountRepository.class);
		AccountService as = context.getBean(AccountService.class);
		as.display();

	}

}
