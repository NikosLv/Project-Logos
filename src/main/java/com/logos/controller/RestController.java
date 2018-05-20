package com.logos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logos.entity.User;
import com.logos.service.UserService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> showUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
