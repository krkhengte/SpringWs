package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/")
	public String getInfo(Model model) {
		
		model.addAttribute("msg", "Welcome To Spring Boot");
		
		return "index";
	}
}
