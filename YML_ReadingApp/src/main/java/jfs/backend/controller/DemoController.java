package jfs.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.props.AppProperties;

@RestController
public class DemoController {

	@Autowired
	private AppProperties props;
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		
		Map<String, String> messages = props.getMessages();
		String value = messages.get("welcomeMsg");
		return value;
	}
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		
		Map<String, String> messages = props.getMessages();
		String value = messages.get("greetMsg");
		return value;
	}
	
	@GetMapping("/wish")
	public String getWishMsg() {
		
		/*
		 * Map<String, String> messages = props.getMessages(); String value =
		 * messages.get("wishMsg"); return value;
		 */
		
		return props.getMessages().get("wishMsg");
		
	}
	
}
