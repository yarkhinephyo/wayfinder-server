package com.wayfinder.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wayfinder.app.dao.EventDao;
import com.wayfinder.app.entity.Event;
@Component
public class EventServiceImpl implements EventService{
	@Resource 
	EventDao eventDao;

	@Override
	public List<Event> findAll() {
		return eventDao.findAll();
	}
	@Override
	public void insertEvent(Event eve){
		eventDao.insertEvent(eve);
	}
	@Override
	public void updateEvent(Event eve) {
		eventDao.updateEvent(eve);
	}
	@Override
	public void executeUpdateEvent(Event eve) {
		eventDao.executeUpdateEvent(eve);
	}
	@Override
	public void deleteEvent(String id) {
		eventDao.deleteEvent(id);
	}
	
}
