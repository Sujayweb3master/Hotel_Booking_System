package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // Custom query method to find a user by username
    User findByUsername(String username);

    // Custom query method to check if a user with a given username exists
    boolean existsByUsername(String username);
}
