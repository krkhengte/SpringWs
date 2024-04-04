package jfs.backend.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	Logger logger=LoggerFactory.getLogger(DemoRestController.class);
	
	@GetMapping("/welcome")
	public String getMessgage() {
		
		logger.info("getMessage() execution started");
		
		String string="Welcome To Logger";
		
		logger.info("getMessage() execution ended");
		
		
		try {
			
			int x=0;
			int y=10;
			
			int z=y/x;
			
		} catch (Exception e) {
			
			System.out.println("Exception occure /by 0");
		}
		
		return string;
		
	}
	
}
