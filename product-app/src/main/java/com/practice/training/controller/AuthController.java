package com.practice.training.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.training.dto.AuthResponse;
import com.practice.training.dto.User;
import com.practice.training.repo.UserRepository;
import com.practice.training.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private TokenService tokenService;

	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestHeader String username, @RequestHeader String password) {
		boolean isValid = checkCredentialsInDatabase(username, password);
		if (isValid) {
			String token = tokenService.generateToken(username);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(new AuthResponse(username, token));
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	}

	private boolean checkCredentialsInDatabase(String username, String password) {
		User user = userRepository.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
}
