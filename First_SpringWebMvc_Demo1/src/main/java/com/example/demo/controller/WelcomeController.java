package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping("/welcome") // used to binding to get request
	public ModelAndView getWelcomeMsg() {
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("msg", "Welcome To Spring Web MVC....!");
		mav.setViewName("index"); // name will be anything
		
		return mav;
	}
}
