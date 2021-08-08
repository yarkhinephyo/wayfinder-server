package com.wayfinder.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wayfinder.app.entity.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setUserId(rs.getString("userId"));
		user.setUserName(rs.getString("userName"));
 
        return user;
	}


}
