package jfs.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jfs.backend.payloads.UserDto;
import jfs.backend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	// Post - create user
	// Put - update user
	// Delete - delete user
	// get - user get

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

		UserDto createUser = this.userService.createUser(userDto);

		return new ResponseEntity<UserDto>(createUser, HttpStatus.CREATED);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {

		UserDto updateUser = this.userService.updateUser(userDto, userId);

		return new ResponseEntity<UserDto>(updateUser, HttpStatus.CREATED);

	}

	
	  @GetMapping("/getSingleUser/{userId}")
	  public ResponseEntity<UserDto> getUser( @PathVariable Integer userId){
	  
	  UserDto userById = this.userService.getUserById(userId);
	  
	  return new ResponseEntity<UserDto>(userById,HttpStatus.CREATED); }
	 

	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDto>> getAllUser() {

		 List<UserDto> userById = this.userService.getAllUser();
		 return new ResponseEntity<List<UserDto>>(userById,HttpStatus.OK);

	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {

		String deleteUser = this.userService.deleteUser(userId);

		return new ResponseEntity<>(deleteUser, HttpStatus.CREATED);

	}

}
