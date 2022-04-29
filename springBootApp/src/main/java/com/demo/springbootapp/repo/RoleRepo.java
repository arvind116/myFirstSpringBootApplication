package com.demo.springbootapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootapp.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String name);
}