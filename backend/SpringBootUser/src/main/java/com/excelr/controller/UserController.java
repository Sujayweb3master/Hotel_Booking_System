package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.excelr.entity.User;
import com.excelr.service.UserService;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody Map<String, String> resetRequest) {
        String username = resetRequest.get("username");
        String newPassword = resetRequest.get("newPassword");
        System.out.println("Username: " + username);
        System.out.println("New Password: " + newPassword);
        return userService.resetPassword(username, newPassword);
    }
}
