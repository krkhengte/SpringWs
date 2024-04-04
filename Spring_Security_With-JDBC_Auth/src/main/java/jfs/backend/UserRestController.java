package jfs.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@GetMapping("/")
	public String welcome() {
		
		return "Welcome To Spring Security";
	}
	
	@GetMapping("/admin")
	public String adminProcess() {
		
		return "Admin Precess Login";
	}
	
	@GetMapping("/user")
	public String userProcess() {
		
		return "User Process Login";
	}
	
}
