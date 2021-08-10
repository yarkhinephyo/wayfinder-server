package com.wayfinder.app.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wayfinder.app.dao.UserDao;
import com.wayfinder.app.entity.JwtRequest;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Resource 
	UserDao userDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		com.wayfinder.app.entity.User user = userDao.getUser(userName);
		
		return new User(user.getUserName(), user.getUserPassword(), new ArrayList<>());
	}
	
	public void insertUser(JwtRequest jwtRequest) {
		com.wayfinder.app.entity.User newUser = new com.wayfinder.app.entity.User();
		newUser.setUserName(jwtRequest.getUsername());
		newUser.setUserPassword(bcryptEncoder.encode(jwtRequest.getPassword()));
		userDao.insertUser(newUser);;
	}
}
