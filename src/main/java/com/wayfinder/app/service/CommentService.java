package com.wayfinder.app.service;

import java.util.List;

import com.wayfinder.app.entity.Comment;

public interface CommentService {
	List<Comment> findByEventId(int eventId);

	void insertComment(Comment comment);

	public void deleteComment(int commentId);
	
}
