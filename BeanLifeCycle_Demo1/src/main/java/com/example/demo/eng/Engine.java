package com.example.demo.eng;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


//Bean Life Cycle Through Annotation Approch

@Component
public class Engine {
	
	public Engine() {
	
		System.out.println("Engine :: Constructor");
	}

	@PostConstruct
	public void start() {
		
		System.out.println("Engine Started");
	}
	
	@PreDestroy
	public void stop() {
		System.out.println("Engine Stopped");
	}
	
}
