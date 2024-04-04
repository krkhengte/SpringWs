package jfs.backend.service;

import java.util.List;

import org.springframework.data.annotation.CreatedBy;

import jfs.backend.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	
	String deleteUser(Integer userId);
	
}
