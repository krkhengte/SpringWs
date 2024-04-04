package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@GetMapping("/")
	public String getUserInfo(Model model) {

		// User user=new User();

		model.addAttribute("home", "Welcome To Spring Boot");

		return "home";

	}

	@PostMapping("/login")
	public String goWithLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@PostMapping("/submit")
	public String getResponse(@Valid User user,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "login";
		}
		
		model.addAttribute("msg", "Thanks For Login");
		return "success";
	}

	@PostMapping("/register")
	public String getRegisterData(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/registerd")
	public String getRegDataRes(@Valid User user,BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "register";
		}
		model.addAttribute("msg", "Registration Successfull");
		return "RegSuccess";
	}
}
