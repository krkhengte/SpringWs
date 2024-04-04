package jfs.backend.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/msg")
	public String getMsg() {
		String str="Welcome To Report API";
		
		return str;
	}

}
