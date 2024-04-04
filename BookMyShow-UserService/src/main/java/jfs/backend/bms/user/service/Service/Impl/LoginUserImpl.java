package jfs.backend.bms.user.service.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jfs.backend.bms.user.service.Service.LoginService;
import jfs.backend.bms.user.service.apiresponse.LoginApiResponse;
import jfs.backend.bms.user.service.entity.User;
import jfs.backend.bms.user.service.exception.ResourceNotFoundException;
import jfs.backend.bms.user.service.payload.LoginDto;
import jfs.backend.bms.user.service.payload.UserDto;
import jfs.backend.bms.user.service.repo.UserRepository;

@Service
public class LoginUserImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public LoginApiResponse loginUser(LoginDto loginDto) {

		LoginApiResponse lar = new LoginApiResponse();

		String userName = loginDto.getUserName();
		String password = loginDto.getPassword();

		System.out.println(userName);
		System.out.println(password);


		User user = this.userRepository.findByUserName(userName).orElseThrow(()-> new ResourceNotFoundException("userName", "password", "Invalid User and Password"));
		
		
		if (user.getUserName().equals(userName) && passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {

			lar.setFullName(user.getFullName());
			lar.setUserDob(user.getUserDob());
			lar.setUserEmail(user.getUserEmail());
			lar.setUserId(user.getUserId());
			lar.setUserName(user.getUserName());

			return lar;

		}
			else {
			lar.setMsg("Invalid User Name and Password");
			return lar;
		}

	}

}
