package com.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.main.services.AuthenticateUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppConfig 
{
	
	@Bean
	public UserDetailsService userDetServ()
	{
		return new AuthenticateUserDetailsService();
	}
	
	//Encrypting the password
	@Bean
	public PasswordEncoder encode()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetServ());
		dao.setPasswordEncoder(encode());
		
		return dao;
	}

	//Authorization
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception
	{
		return http.
                csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/hotels/hotel/input", "/api/hotels/hotel/{id}", "/api/user/{id}", "/api/user/register")
                        .permitAll())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/hotels/**")
                        .hasRole("MANAGER")
                		)
                
                .build();
			   
	}
}
/*
 http.
			   csrf().disable()
			   .authorizeHttpRequests()
			   .requestMatchers("/api/hotels/hotel/input","/api/hotels/hotel/{id}","/api/users/user/{id}")
			   .permitAll()
			   .and()
			   .authorizeHttpRequests()
			   .requestMatchers("/api/hotels/**")
			   .hasRole("MANAGER")
			   .and().build(); 
 */
 

