package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.Book;

@SpringBootApplication
public class MavenDemo1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MavenDemo1Application.class, args);
		//Book bean = context.getBean(Book.class );
		Book bean=new Book();
		System.out.println("First Object" +bean);
		
	//	Book bean2 = context.getBean(Book.class);
		
		Book bean2 =new Book();
		System.out.println("Second Object" +bean2);
	}

}
