package jfs.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestApi {

	@GetMapping("/msg")
	public String getMessage() {
		
		String msg="Welcome To Microservices";
		return msg;
		
	}
	
}
