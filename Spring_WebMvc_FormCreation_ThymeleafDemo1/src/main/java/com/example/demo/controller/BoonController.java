package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.binding.Book;

@Controller
public class BoonController {

	@GetMapping("/")
	public String getBookData(Model model) {
		
		Book book=new Book();
		
		model.addAttribute("book", book);
		
		return "index";
	}
	
	@PostMapping("/bookInfo")
	public String getBookInfo(Book book ,Model model) {
		
		System.out.println(book);
		
		model.addAttribute("msg", "Book Data Saved Successfully...");
		
		return "success";
	}
	
}
