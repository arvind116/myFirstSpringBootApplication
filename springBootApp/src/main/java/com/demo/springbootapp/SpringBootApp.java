package com.demo.springbootapp;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.springbootapp.domain.Role;
import com.demo.springbootapp.domain.User;
import com.demo.springbootapp.service.UserService;

@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userservice) {
		return args -> {
			userservice.saveRole(new Role(null, "ROLE_USER"));
			userservice.saveRole(new Role(null, "ROLE_MANAGER"));
			userservice.saveRole(new Role(null, "ROLE_ADMIN"));
			userservice.saveRole(new Role(null, "ROLE_SUPERADMIN"));

			userservice.saveUser(new User(null, "Arvind Bhaskar", "arvind116", "1234", new ArrayList<>()));
			userservice.saveUser(new User(null, "Selva", "selva127", "5678", new ArrayList<>()));
			userservice.saveUser(new User(null, "Mani", "mani007", "2468", new ArrayList<>()));
			userservice.saveUser(new User(null, "Navin", "navin4", "1357", new ArrayList<>()));

			userservice.addRoleToUser("arvind116", "ROLE_SUPERADMIN");
			userservice.addRoleToUser("arvind116", "ROLE_ADMIN");
			userservice.addRoleToUser("arvind116", "ROLE_MANAGER");
			userservice.addRoleToUser("selva127", "ROLE_ADMIN");
			userservice.addRoleToUser("selva127", "ROLE_MANAGER");
			userservice.addRoleToUser("mani007", "ROLE_MANAGER");
			userservice.addRoleToUser("mani007", "ROLE_ADMIN");
			userservice.addRoleToUser("navin4", "ROLE_USER");

		};
	}
}
