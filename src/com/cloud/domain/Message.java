package com.cloud.domain;

public class Message {
	private int id;
	private String message;
	private String groupIdList;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getGroupIdList() {
		return groupIdList;
	}
	public void setGroupIdList(String groupList) {
		this.groupIdList = groupList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
