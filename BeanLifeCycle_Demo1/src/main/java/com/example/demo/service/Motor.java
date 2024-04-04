package com.example.demo.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


	// Bean Life Cycle Through Interface Approch

@Component
public class Motor implements InitializingBean,DisposableBean {
	
	public Motor() {
	System.out.println("Motor :: Constructor");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(" destroy() method called");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() method Called");
		
	}

}
