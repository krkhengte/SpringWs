package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.binding.Player;

@Controller
public class PlayerController {

	@GetMapping("/welcome")
	public String getPlayerData(Model model) {
		
		Player player =new Player();
		
		model.addAttribute("msg", "Welcome To Thymeleaf....!");
		
		return "index";
	}
	
}
