package jfs.backend.services;

import java.util.List;

import jfs.backend.entity.User;

public interface UserService {

	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);

	// todo delete
	
	// todo update
	
	
}
