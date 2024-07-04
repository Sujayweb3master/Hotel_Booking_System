package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	public User findByUsername(String username);
}
