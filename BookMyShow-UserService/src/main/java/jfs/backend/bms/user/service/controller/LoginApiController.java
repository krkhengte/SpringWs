package jfs.backend.bms.user.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jfs.backend.bms.user.service.Service.LoginService;
import jfs.backend.bms.user.service.apiresponse.LoginApiResponse;
import jfs.backend.bms.user.service.jwtToken.JwtHelper;
import jfs.backend.bms.user.service.jwtToken.JwtResponce;
import jfs.backend.bms.user.service.payload.LoginDto;

@RestController
@RequestMapping("users")
public class LoginApiController {

	@Autowired
	private LoginService loginService;
		
	
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(LoginApiController.class);


    // step 1 
    
    
    @PostMapping("/login")
    public ResponseEntity<JwtResponce> login(@RequestBody LoginDto request) {

        this.doAuthenticate(request.getUserName(), request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());

        String token = this.helper.generateToken(userDetails);

        JwtResponce response = JwtResponce.builder()
                .token(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    
    // step 2

    private void doAuthenticate(String name, String password) {


        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(name, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
}
