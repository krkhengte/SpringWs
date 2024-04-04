package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.binding.Books;

@Controller
public class BooksController {

	@GetMapping("/books")
	public String getBooksData(Model model) {
		
		Books b1=new Books(101,"Spring",400.00);
		Books b2=new Books(102,"Java",500.00);
		Books b3=new Books(103,"Mysql",600.00);
		Books b4=new Books(104,"Python",700.00);
		
		List<Books> asList = Arrays.asList(b1,b2,b3,b4);
		
		
		model.addAttribute("books", asList);
	
		
		return "books";
		
	}
	
}
