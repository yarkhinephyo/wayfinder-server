package com.wayfinder.app.service;

import com.wayfinder.app.entity.User;

public interface UserService {
	User getUser(String userName);

	void insertUser(User user);

}
