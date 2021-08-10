package com.wayfinder.app.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wayfinder.app.dao.UserDao;
import com.wayfinder.app.entity.User;
@Service
public class UserServiceImpl implements UserService{
	@Resource 
	UserDao userDao;

	@Override
	public User getUser(String userName) {
		return userDao.getUser(userName);
	}
	@Override
	public void insertUser(User user){
		userDao.insertUser(user);
	}

}
