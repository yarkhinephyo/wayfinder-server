package com.wayfinder.app.dao;

import com.wayfinder.app.entity.User;

public interface UserDao {

	User getUser(String id);

	void insertUser(User user);

	void updateUser(User user);

	void executeUpdateUser(User user);
}
