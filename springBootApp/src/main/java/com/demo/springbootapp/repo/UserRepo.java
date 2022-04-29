package com.demo.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootapp.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
}