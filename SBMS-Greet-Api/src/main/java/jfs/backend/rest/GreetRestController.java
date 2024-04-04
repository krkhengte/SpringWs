package jfs.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.client.WelcomeApiClient;

@RestController
public class GreetRestController {

	@Autowired
	private WelcomeApiClient welcomeApiClient;
	
	@GetMapping("/greet")
	public String getGreetMessage() {
		
		String greetMsg="Good Morning...!";
		String invokeWelcomeRestApi = welcomeApiClient.invokeWelcomeRestApi();
		
		return greetMsg + invokeWelcomeRestApi;
		
		
	}
}
