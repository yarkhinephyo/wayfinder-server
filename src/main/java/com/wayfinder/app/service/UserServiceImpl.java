package com.wayfinder.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wayfinder.app.dao.UserDao;
import com.wayfinder.app.entity.User;
@Component
public class UserServiceImpl implements UserService{
	@Resource 
	UserDao userDao;

	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}
	@Override
	public void insertUser(User user){
		userDao.insertUser(user);
	}
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	@Override
	public void executeUpdateUser(User user) {
		userDao.executeUpdateUser(user);
	}

}
