package com.cloud.domain;


public class User {
	private Integer id;
	private String userId;
	private String firstname;
	private String lastname;
	private String email;
	private String role;
	private String date;	
//	private UserAccess useraccess;
//	
//	public UserAccess getUseraccess() {
//		return useraccess;
//	}
//	public void setUseraccess(UserAccess useraccess) {
//		this.useraccess = useraccess;
//	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
