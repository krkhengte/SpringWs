package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.bindings.Book;

@Controller
public class BookController {

	@GetMapping("/book")
	public String getBookData(Model model) {
		
		// setting data to binding object
		Book bookObj1 = new Book(101, "Spring", 450.00);
		//Book bookObj2 = new Book(102, "Java", 500.00);
		
		// adding data to model object to sent to ui 
		model.addAttribute("book", bookObj1);
		//model.addAttribute("book", bookObj2);

		// return view name
		return "book";
	}
	
	
	@GetMapping("/books")
	public String getBooksData(Model model) {
		
		// setting data to binding object
		Book b1 = new Book(101, "Spring", 450.00);
		Book b2 = new Book(102, "Java", 600.00);
		Book b3 = new Book(103, "Angular", 350.00);
		//Book bookObj2 = new Book(102, "Java", 500.00);
		
		List<Book> asList = Arrays.asList(b1,b2,b3);
		
		// adding data to model object to sent to ui 
		model.addAttribute("books", asList);
		//model.addAttribute("book", bookObj2);

		// return view name
		return "books";
	}
}
