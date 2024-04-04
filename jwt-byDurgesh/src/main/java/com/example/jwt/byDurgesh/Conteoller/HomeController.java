package com.example.jwt.byDurgesh.Conteoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/test")
    public String test() {
        this.logger.warn("This is working message");
        return "Testing message";
    }
    @PostMapping("/test/welcome/{s}")
    public String test1(@PathVariable String s) {
        System.out.println(s);
        this.logger.warn("This is working message");
        return s;
    }


}