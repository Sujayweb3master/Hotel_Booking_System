package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.UserRepository;
import com.main.model.User;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepo;
	
	public User insertUserData(User user)
	{
		return userRepo.save(user); 
	}
	
	public User retrieveUserData(Long id)
	{
		return userRepo.findById(id).get();
	}
	
	public List<User> retrieveAllData()
	{
		return userRepo.findAll();
	}
	
	public User updateUserData(Long id, User user)
	{
		User oldUser = userRepo.findById(id).get();
		oldUser.setEmail(user.getEmail());
		oldUser.setName(user.getName());
		oldUser.setPhone(user.getPhone());
		oldUser.setPassword(user.getPassword());
		oldUser.setRole(user.getRole());
		
		return userRepo.save(oldUser);	
		
	}
	
	public void deleteUserData(Long id)
	{
		userRepo.deleteById(id);
	}
}
