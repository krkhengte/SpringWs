package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class GreetController {

	@GetMapping("/greet")
	public String getGreetMsg(Model model) {
		
		String msg="Good Morning";
		model.addAttribute("msg", msg);
		return "greet";
	}
	
}
