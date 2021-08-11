package com.wayfinder.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wayfinder.app.dao.CommentDao;
import com.wayfinder.app.entity.Comment;
@Service
public class EventServiceImpl implements CommentService{
	@Resource 
	CommentDao commentDao;
	
	@Override
	public List<Comment> findByEventId(int eventId) {
		return commentDao.findByEventId(eventId);
	}
	@Override
	public void insertComment(Comment comment){
		commentDao.insertComment(comment);;
	}
	@Override
	public void deleteComment(int commentId) {
		commentDao.deleteComment(commentId);;
	}
	
}
