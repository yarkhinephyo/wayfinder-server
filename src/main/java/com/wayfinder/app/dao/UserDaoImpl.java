package com.wayfinder.app.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.wayfinder.app.entity.User;
import com.wayfinder.app.mapper.UserRowMapper;
@Repository
public class UserDaoImpl implements UserDao{
	
	public UserDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}  
	NamedParameterJdbcTemplate template;
	
	@Override
	public User getUser(String userName) {
		final String sql = "select * from users where userName=:userName";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("userName", userName);
		List<User> usersQueried = template.query(sql,param, new UserRowMapper());
		if (usersQueried.size() == 0) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		return usersQueried.get(0);
	}

	@Override
	public void insertUser(User user) {
		final String sql = "insert into users(userName, userPassword) values(:userName,:userPassword)";
		 
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
				.addValue("userName", user.getUserName())
				.addValue("userPassword", user.getUserPassword());
        template.update(sql,param,holder);
	 
	}

}
