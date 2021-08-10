package com.wayfinder.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wayfinder.app.dao.EventDao;
import com.wayfinder.app.entity.Event;
@Service
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
	public void executeUpdateEvent(Event eve) {
		eventDao.executeUpdateEvent(eve);
	}
	@Override
	public void deleteEvent(int id) {
		eventDao.deleteEvent(id);
	}
	
}
