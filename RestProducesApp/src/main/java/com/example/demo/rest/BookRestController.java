package com.example.demo.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.binding.Book;

@RestController
public class BookRestController {

	@GetMapping(value = "/book" ,produces = {"application/json"})
	public ResponseEntity<Book> getBookData(){
		
		Book book=new Book();
		book.setBookId(101);
		book.setBookPrice(300.00);
		book.setBookName("Keyboard");
		
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		/* return new ResponseEntity<Book>(book, HttpStatus.OK); */
		
	}
	
	@GetMapping(value = "/books"/* , produces = {"application/json"} */) // if i dont define a produces it will take default as a json format
	public ResponseEntity<List<Book>> getBooksData(){
		
		Book b1=new Book(101,"Spring",400.00);
		Book b2=new Book(102,"Python",500.00);
		Book b3=new Book(103,"Java",700.00);
		
		List<Book> asList = Arrays.asList(b1,b2,b3);
		
		return new ResponseEntity<List<Book>>(asList,HttpStatus.OK);
	}
		
	}
	

