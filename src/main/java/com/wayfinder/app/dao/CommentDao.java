package com.wayfinder.app.dao;

import java.util.List;

import com.wayfinder.app.entity.Comment;

public interface CommentDao {

	List<Comment> findByEventId(int eventId);

	void insertComment(Comment comment);

	public void deleteComment(int commentId);
}
