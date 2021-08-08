package com.wayfinder.app.service;

import com.wayfinder.app.entity.User;

public interface UserService {
	User getUser(String id);

	void insertUser(User user);

	void updateUser(User user);

	void executeUpdateUser(User user);
	
}
