package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.binding.Product;

@RestController
public class ProductRestController {

	/* Produces are represent a format which client wants */
	
	@GetMapping(value = "/product" ,produces = {"application/xml","application/json"})
	public ResponseEntity<Product> getProductInfo(){
		
		Product product=new Product();
		product.setPid(101);
		product.setPname("Mouse");
		product.setPrice(4000.00);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
		
		
	}
	
}
