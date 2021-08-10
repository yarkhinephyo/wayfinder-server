package com.wayfinder.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wayfinder.app.entity.Event;
import com.wayfinder.app.service.EventService;

@CrossOrigin
@RestController
@RequestMapping("/event")
public class EventController {

	@Resource 
	EventService eventService;
	
	@GetMapping(value = "/all")
	public List<Event> getEvents() {
		return eventService.findAll();
	}
	@PostMapping(value = "/new")
	public void createEvent(@RequestBody Event eve) {
		eve.setUserName(getUsernameFromSpringContext());
		eventService.insertEvent(eve);
	}
	@PutMapping(value = "/update")
	public void updateEvent(@RequestBody Event eve) {
		eventService.updateEvent(eve);
	}
	@PutMapping(value = "/executeUpdate")
	public void executeUpdateEvent(@RequestBody Event eve) {
		eventService.executeUpdateEvent(eve);
	}
	@DeleteMapping(value = "/{id}")
	public void deleteEvent(@PathVariable int id) {
		eventService.deleteEvent(id);
	}
	
	private String getUsernameFromSpringContext() {
		User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails.getUsername();
	}
	
}
