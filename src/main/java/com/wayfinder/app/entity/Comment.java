package com.wayfinder.app.entity;

public class Comment {

	int commentId;
	String commenterName;
	int eventId;
	long commentUnixTime;
	String commentString;

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommenterName() {
		return commenterName;
	}
	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public long getCommentUnixTime() {
		return commentUnixTime;
	}
	public void setCommentUnixTime(long commentUnixTime) {
		this.commentUnixTime = commentUnixTime;
	}
	public String getCommentString() {
		return commentString;
	}
	public void setCommentString(String commentString) {
		this.commentString = commentString;
	}
	
	
}
