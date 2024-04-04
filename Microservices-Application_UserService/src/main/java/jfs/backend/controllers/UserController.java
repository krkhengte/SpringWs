package jfs.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.entity.User;
import jfs.backend.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User saveUser = this.userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> allUser = this.userService.getAllUser();
		
		return ResponseEntity.status(HttpStatus.OK).body(allUser);
		
	}
	
	
	@GetMapping("/getSingleUser/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		
		User user2 = this.userService.getUser(userId);
		
		return ResponseEntity.status(HttpStatus.OK).body(user2);
	}
	
	
}
