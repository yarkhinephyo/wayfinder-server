package com.wayfinder.app.dao;

import java.util.List;

import com.wayfinder.app.entity.Event;

public interface EventDao {

	List<Event> findAll();

	void insertEvent(Event eve);

	void updateEvent(Event eve);

	void executeUpdateEvent(Event eve);

	public void deleteEvent(String id);
}
