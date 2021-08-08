package com.wayfinder.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wayfinder.app.entity.User;
import com.wayfinder.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Resource 
	UserService userService;
	
	@GetMapping(value = "/{id}")
	public User getEvents(@PathVariable String id) {
		return userService.getUser(id);
	}
	@PostMapping(value = "/new")
	public void createEvent(@RequestBody User user) {
		userService.insertUser(user);
	}
	@PutMapping(value = "/update")
	public void updateEvent(@RequestBody User user) {
		userService.updateUser(user);
	}
	@PutMapping(value = "/executeUpdate")
	public void executeUpdateEvent(@RequestBody User user) {
		userService.executeUpdateUser(user);
	}
	
}
