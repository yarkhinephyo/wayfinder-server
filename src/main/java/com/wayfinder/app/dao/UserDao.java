package com.wayfinder.app.dao;

import com.wayfinder.app.entity.User;

public interface UserDao {

	User getUser(String userName);

	void insertUser(User user);

}
