package com.excelr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.User;
import com.excelr.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String login(User user) {
        // Check if the user exists in the database
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // Login successful
            return "Login Success";
        } else {
            // Login failed
            return "Login Failed. Username or password is incorrect.";
        }
    }

    public String register(User user) {
    	
        // Check if the user is already taken
        if (userRepository.existsByUsername(user.getUsername())) {
            // User already exists
            return "Registration Failed. Username already exists.";
        } else {
            // Register the user
            userRepository.save(user);
            return "Registration Success";
        }
    }
    
    public String resetPassword(String username, String newPassword) {
        // Check if the user exists in the database
        User existingUser = userRepository.findByUsername(username);

        if (existingUser != null) {
            // Reset the password
            existingUser.setPassword(newPassword);
            userRepository.save(existingUser);
            return "Password Reset Success";
        } else {
            // User not found
            return "Password Reset Failed. User not found.";
        }
    }
}
