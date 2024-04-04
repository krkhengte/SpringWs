package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.binding.User;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@RequestMapping("/")
	public String getUserForm(Model model) {

		User user = new User();
		model.addAttribute("user", user);
		return "index";
	}

	
	
	@PostMapping("/UserInfo")
	public String getUserData(@Valid User user, BindingResult result, Model model) {
			System.out.println(result.toString());
		
		if (result.hasErrors()) {
			System.out.println("Condition Check");
			//model.addAttribute("User", user);
			return "index";
		}

		model.addAttribute("msg", "Registration Successfull..!");
		System.out.println("Welcome : Mr. " + user.getUserName());
		return "success";
	}
	
}
