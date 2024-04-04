package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bindings.Books;

@Controller
public class BooksController {

	@GetMapping("/book")
	public ModelAndView getBooks() {
		
		ModelAndView mav=new ModelAndView();
		
		Books book=new Books(101,"Java",500.00);
		
	//	Books bookObj1=new Books(101,"Java",500.00);
	//	Books bookObj2=new Books(102,"Spring",700.00);
	//	Books bookObj3=new Books(103,"Angular",400.00);
		
//		List<Books> bookList=Arrays.asList(bookObj1,bookObj2,bookObj3);
//		mav.addObject("books",bookList);
		mav.addObject("books",book);
		return mav;
		
	}
	
}
