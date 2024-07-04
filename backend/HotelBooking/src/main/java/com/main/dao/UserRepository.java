package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
