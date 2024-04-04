
package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourceRestController {

	/* It is used for retrieve more than one data/record we will use Query Params */
	
	@GetMapping("/cource")
	
	/* RequestParam is Used for Read The Query Params */
	
	public ResponseEntity<String> getCourceMsg(@RequestParam("cName") String cName,@RequestParam("tName") String tName) {

		String courceData = cName + " By " + tName + " Fees is 2000 Rs";

		return new ResponseEntity<String>(courceData, HttpStatus.OK);

	}
}
