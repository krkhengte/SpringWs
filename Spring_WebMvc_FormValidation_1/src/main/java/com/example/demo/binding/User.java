package com.example.demo.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User {

	@NotNull
	@Size(min =4 , max =4)
	private Integer userId;

	@NotEmpty(message = "UserName Shoult Not Empty")
	private String userName;
	@NotEmpty(message = "UserName Shoult Not Empty")
	private String userPassword;
	@NotEmpty(message = "UserName Shoult Not Empty")
	@Email(message = "Enter Valid Email Id")
	private String userGmail;
	@NotNull 
	private Integer userAge;

}
