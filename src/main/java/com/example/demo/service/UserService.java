package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
