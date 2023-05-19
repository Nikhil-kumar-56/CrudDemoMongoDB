package com.assignment.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rest.domain.User;
import com.assignment.rest.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return userService.updateUserDetails(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable String userId) {
		return userService.getUserByUserId(userId);
	}
	
	@DeleteMapping("/users")
	public void deleteUserByUserId(@RequestParam(name = "userId") String userId) {
		userService.deleteUser(userId);
	}
	
}
