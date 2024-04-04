package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.binding.Product;

@Controller
public class ProductController {

	@GetMapping("/")
	public String getProductForm(Model model) {

		Product product1 = new Product();

		model.addAttribute("product", product1);

		return "index";

	}

	@PostMapping("/product")
	public String saveFormData(Product product, Model model) {

		// System.out.println(product);
		System.out.println("Product Id :" + product.getProductId());
		System.out.println("Product Name :" + product.getProductName());
		System.out.println("Product Price :" + product.getProductPrice());
		model.addAttribute("msg", "Product Saved Successfully..");

		return "success";

	}

}
