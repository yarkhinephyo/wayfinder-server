package com.wayfinder.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wayfinder.app.entity.Event;

public class EventRowMapper implements RowMapper<Event> {

	@Override
	public Event mapRow(ResultSet rs, int arg1) throws SQLException {
		Event eve = new Event();
		eve.setEventId(rs.getInt("eventId"));
		eve.setEventName(rs.getString("eventName"));
		eve.setUserName(rs.getString("userName"));
		eve.setEventDesc(rs.getString("eventDesc"));
		eve.setEventUnixTime(rs.getLong("eventUnixTime"));
		eve.setEventUnixExpiry(rs.getLong("eventUnixExpiry"));
		eve.setEventCategory(rs.getString("eventCategory"));
		eve.setEventSubCategory(rs.getString("eventSubCategory"));
		eve.setEventImageURL(rs.getString("eventImageURL"));
		eve.setEventAddress(rs.getString("eventAddress"));
 
        return eve;
	}


}
