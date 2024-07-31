package com.example.jsp02.db;

import lombok.Data;

@Data
public class UserVO {
	
	// private 멤버변수 선언
	private String id;
	private String password;
	private String name; 
	private String role;


	/**
	// Getter/Setter 메소드
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	// toString 메소드
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	 **/
}

