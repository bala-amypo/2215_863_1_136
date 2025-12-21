package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

@Autowired
private UserRepository userRepository;

@Override
public User saveUser(User user) {
return userRepository.save(user);
}

@Override
public void validateUser(User user) {
User dbUser = userRepository.findByUsername(user.getUsername()).orElse(null);
if (dbUser == null || !dbUser.getPassword().equals(user.getPassword())) {
throw new RuntimeException("Invalid credentials");
}
}
}
