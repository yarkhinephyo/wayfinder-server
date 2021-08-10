package com.wayfinder.app.entity;

public class Event {

	int eventId;
	String eventName;
	String userName;
	String eventDesc;
	long eventUnixTime;
	long eventUnixExpiry;
	String eventCategory;
	String eventSubCategory;
	String eventImageURL;
	String eventAddress;
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public long getEventUnixTime() {
		return eventUnixTime;
	}
	public void setEventUnixTime(long eventUnixTime) {
		this.eventUnixTime = eventUnixTime;
	}
	public long getEventUnixExpiry() {
		return eventUnixExpiry;
	}
	public void setEventUnixExpiry(long eventUnixExpiry) {
		this.eventUnixExpiry = eventUnixExpiry;
	}
	public String getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}
	public String getEventSubCategory() {
		return eventSubCategory;
	}
	public void setEventSubCategory(String eventSubCategory) {
		this.eventSubCategory = eventSubCategory;
	}
	public String getEventImageURL() {
		return eventImageURL;
	}
	public void setEventImageURL(String eventImageURL) {
		this.eventImageURL = eventImageURL;
	}
	public String getEventAddress() {
		return eventAddress;
	}
	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	
}
