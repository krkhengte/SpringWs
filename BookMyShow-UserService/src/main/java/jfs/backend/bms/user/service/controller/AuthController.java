//package jfs.backend.bms.user.service.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//import jfs.backend.bms.user.service.Service.AuthService;
//import jfs.backend.bms.user.service.entity.User;
//import jfs.backend.bms.user.service.payload.LoginDto;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//    @Autowired
//    private AuthService service;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/register")
//    public String addNewUser(@RequestBody User user) {
//        return service.saveUser(user);
//    }
//
//    @PostMapping("/token")
//    public String getToken(@RequestBody LoginDto authRequest) {
//        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
//        if (authenticate.isAuthenticated()) {
//            return service.generateToken(authRequest.getUserName());
//        } else {
//            throw new RuntimeException("invalid access");
//        }
//    }
//
//    @GetMapping("/validate")
//    public String validateToken(@RequestParam("token") String token) {
//        service.validateToken(token);
//        return "Token is valid";
//    }
//}
