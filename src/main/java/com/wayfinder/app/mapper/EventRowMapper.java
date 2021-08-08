package com.wayfinder.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wayfinder.app.entity.Event;

public class EventRowMapper implements RowMapper<Event> {

	@Override
	public Event mapRow(ResultSet rs, int arg1) throws SQLException {
		Event emp = new Event();
		emp.setEventId(rs.getString("eventId"));
		emp.setEventName(rs.getString("eventName"));
		emp.setEventEmail(rs.getString("eventEmail"));
		emp.setEventAddress(rs.getString("eventAddress"));
 
        return emp;
	}


}
