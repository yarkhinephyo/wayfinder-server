package com.wayfinder.app.service;

import java.util.List;

import com.wayfinder.app.entity.Event;

public interface EventService {
	List<Event> findAll();

	void insertEvent(Event eve);

	void updateEvent(Event eve);

	void executeUpdateEvent(Event eve);

	void deleteEvent(int id);
	
}
