package com.demo.springbootapp.service;

import java.util.List;

import com.demo.springbootapp.domain.Role;
import com.demo.springbootapp.domain.User;

public interface UserService {
	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	User getUser(String username);

	List<User> getUsers();
}
