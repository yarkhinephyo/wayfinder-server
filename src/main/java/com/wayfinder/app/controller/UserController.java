package com.wayfinder.app.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wayfinder.app.entity.User;
import com.wayfinder.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Resource 
	UserService userService;
	
	@GetMapping(value = "/{userName}")
	public User getUser(@PathVariable String userName) {
		return userService.getUser(userName);
	}
	@PostMapping(value = "/new")
	public void createUser(@RequestBody User user) {
		userService.insertUser(user);
	}
	
}
