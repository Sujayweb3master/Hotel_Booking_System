package com.main.controlllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.User;
import com.main.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/insert")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.insertUserData(user));
    }
	
	// for registering the user
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user)
	{
		return ResponseEntity.ok(userService.inputUserData(user));
	}

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.retrieveUserData(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.retrieveAllData());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUserData(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserData(id);
        return ResponseEntity.noContent().build();
    }
	
}
