package com.example.demo.controller;

import com.example.demo.model.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController{

    @Autowired
    UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        User u=service.login(user.getEmail(),user.getPassword());
        return jwtUtil.generateToken(u.getEmail());
    }
}