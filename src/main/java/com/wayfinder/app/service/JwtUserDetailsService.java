package com.wayfinder.app.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wayfinder.app.dao.UserDao;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Resource 
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		com.wayfinder.app.entity.User user = userDao.getUser(userName);
		
		return new User(user.getUserName(), user.getUserPassword(), new ArrayList<>());
	}
}
