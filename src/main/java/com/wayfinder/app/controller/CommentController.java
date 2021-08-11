package com.wayfinder.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wayfinder.app.entity.Comment;
import com.wayfinder.app.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Resource 
	CommentService commentService;
	
	@GetMapping(value = "/event/{id}")
	public List<Comment> getCommentsByEvent(@PathVariable int id) {
		return commentService.findByEventId(id);
	}
	@PostMapping(value = "/new")
	public ResponseEntity<?> createEvent(@RequestBody Comment comment) {
		comment.setCommenterName(getUsernameFromSpringContext());
		comment.setCommentUnixTime(System.currentTimeMillis() / 1000L);
		commentService.insertComment(comment);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteEvent(@PathVariable int id) {
		commentService.deleteComment(id);
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	private String getUsernameFromSpringContext() {
		User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails.getUsername();
	}
	
}
