package jfs.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {

	@GetMapping("/")
	public String welcomeMsg() {
		
		return "Welcome To Spring Security";
	}
	
	@GetMapping("/tranfer")
	public String transferFund() {
		
		return "Fund Transfer";
	}
	
	@GetMapping("/checkBalance")
	public String checkBalance() {
		
		return "Account Balance is : 20.000 Rs.";
	}
	
	@GetMapping("/about")
	public String aboutUs() {
		
		return "The Sbi Bank is maintening by CBI";
	}
}
