package com.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.main.dao.UserRepository;
import com.main.model.User;

public class AuthenticateUserDetailsService implements UserDetailsService 
{
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User result = userRepo.findByName(username);
		if(result == null)
		{
			throw new UsernameNotFoundException(username + "username not found!!!!");
		}
		
		AuthenticateUserDetails aud = new AuthenticateUserDetails(result);
		return aud;
	}

}
