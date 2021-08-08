package com.wayfinder.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	public User getUser(String id) {
		final String sql = "select * from users where userId=:userId";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("userId", id);
		return template.query(sql,param, new UserRowMapper()).get(0);
	}

	@Override
	public void insertUser(User user) {
		final String sql = "insert into users(userId, userName) values(:userId,:userName)";
		 
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
				.addValue("userId", user.getUserId())
				.addValue("userName", user.getUserName());
        template.update(sql,param,holder);
	 
	}
	
	@Override
	public void updateUser(User user) {
		final String sql = "update users set userName=:userName where userId=:userId";
		 
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
				.addValue("userId", user.getUserId())
				.addValue("userName", user.getUserName());
        template.update(sql,param,holder);
	 
	}
	
	@Override
	public void executeUpdateUser(User user) {
		 final String sql = "update users set userName=:userName where userId=:userId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("userId", user.getUserId());
		 map.put("userName", user.getUserName());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}

}
