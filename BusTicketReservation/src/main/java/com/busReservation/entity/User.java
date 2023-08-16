package com.busReservation.entity;

import javax.persistence.*;


@Entity
@Table(name = "User_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_id")
	private int userId;
	@Column(name = "User_name")
	private String userName;
	@Column(name = "Email")
	private String email;
	@Column(name = "Password")
	private String password;
	
	
	public User() {
		
	}
	
	public User(String userName, String email, String password) {
		
		this.userName = userName;
		this.email = email;
		this.password = password;
		
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

}
