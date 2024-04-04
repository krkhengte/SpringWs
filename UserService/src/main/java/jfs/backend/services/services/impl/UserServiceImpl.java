package jfs.backend.services.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jfs.backend.entity.User;
import jfs.backend.exception.ResourceNotFoundException;
import jfs.backend.repository.UserRepository;
import jfs.backend.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return this.userRepository.save(user); 
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
		
	}

	@Override
	public User getUser(String userId) {
		
		  return this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with giben id is not found on Server ! :" + userId));
		
		
	}

}
