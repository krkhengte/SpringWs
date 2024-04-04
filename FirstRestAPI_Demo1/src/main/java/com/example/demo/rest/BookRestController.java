package com.example.demo.rest;

import java.awt.geom.Area;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

	// Path Param
	
	/* It is used for retrive some specific/unique data we will use Path Params */
	
	
	
	@GetMapping("/book/{name}")
	public ResponseEntity<String> getBookData(@PathVariable("name") String name){
		
		String strName= name + " Price is 400 $";
		
		return new ResponseEntity<>(strName, HttpStatus.OK);
		
	}
	
	@GetMapping("/book/name/{bName}/author/{bAuthor}")
	public ResponseEntity<String> getBookInfo(@PathVariable("bName") String bName,@PathVariable("bAuthor")String bAuthor){
		
		String strName= bName +" by " + bAuthor + " is not available..";
		
		return new ResponseEntity<String>(strName, HttpStatus.OK);
	}
}
