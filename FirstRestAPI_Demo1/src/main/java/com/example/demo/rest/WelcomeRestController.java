package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@GetMapping("/welcome")                           // First Approach   (First Approach is Recommended)
	public ResponseEntity<String> getWelcomeMsg(@RequestParam("name") String name ){
		
		String resPayload= name + ", Welcome To JFS 2023";
		
		return new ResponseEntity<String>(resPayload, HttpStatus.OK);
	}
	
	@GetMapping("/greet")                             // Second Approach
	public String getAnotherMsg() {
		
		String name="Mr.Kartik";
		
		return name;
	}
}
