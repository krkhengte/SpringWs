package com.jfs.backend.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration        // it used to  Create Customized Object Creation   
public class Security {
	
	public Security(){
		System.out.println("Security :: Constructor");
	}
	
	@Bean                               // it used to  Create Customized Object	 Creation 
	public Security getInstance() {
		 
		Security s=new Security();
		
		return s;
		
	}

}
