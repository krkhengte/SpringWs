package jfs.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.security.AuthenticateRequest;
import jfs.backend.security.JwtUtil;
import jfs.backend.security.MyUserDetailsService;

@RestController
public class AuthenticateRestController {

	@Autowired
	private AuthenticationManager authManagaer;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/authenticate")
	public String authencateUser(@RequestBody AuthenticateRequest request) throws Exception {

		try {

			authManagaer.authenticate( new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			
		} catch (Exception e) {

			throw new Exception("Invalid Creadential");
		}

		UserDetails userDeatails = myUserDetailsService.loadUserByUsername(request.getUsername());

		String token = jwtUtil.generateToken(userDeatails);

		return token;
	}

}
