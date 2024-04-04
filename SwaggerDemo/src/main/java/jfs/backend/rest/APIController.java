package jfs.backend.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

	@RequestMapping(method = RequestMethod.GET,value = "api/simplifyingtech")
	public String getRequest() {
		return "Swagger Hello World From Spring";
		
	}
	
	@PostMapping("/api/posts")
	public String postRequest(@RequestBody String yourname) {
		
		return "Hello" + yourname;
	}
}
