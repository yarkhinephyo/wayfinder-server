package com.wayfinder.app.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.wayfinder.app.entity.Event;
import com.wayfinder.app.mapper.EventRowMapper;
@Repository
public class EventDaoImpl implements EventDao{
	
	public EventDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Event> findAll() {
		return template.query("select * from events", new EventRowMapper());
	}
	@Override
	public void insertEvent(Event eve) {
		final String sql = "insert into events(eventName, eventAddress, eventEmail) values(:eventName,:eventEmail,:eventAddress)";
		 
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
				.addValue("eventName", eve.getEventName())
				.addValue("eventEmail", eve.getEventEmail())
				.addValue("eventAddress", eve.getEventAddress());
        template.update(sql,param,holder);
	 
	}
	
	@Override
	public void updateEvent(Event eve) {
		final String sql = "update events set eventName=:eventName, eventAddress=:eventAddress, eventEmail=:eventEmail where eventId=:eventId";
		 
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
				.addValue("eventId", eve.getEventId())
				.addValue("eventName", eve.getEventName())
				.addValue("eventEmail", eve.getEventEmail())
				.addValue("eventAddress", eve.getEventAddress());
        template.update(sql,param,holder);
	 
	}
	
	@Override
	public void executeUpdateEvent(Event eve) {
		 final String sql = "update events set eventName=:eventName, eventAddress=:eventAddress, eventEmail=:eventEmail where eventId=:eventId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("eventId", eve.getEventId());
		 map.put("eventName", eve.getEventName());
		 map.put("eventEmail", eve.getEventEmail());
		 map.put("eventAddress", eve.getEventAddress());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void deleteEvent(String id) {
		 final String sql = "delete from events where eventId=:eventId";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("eventId", id);
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
}
