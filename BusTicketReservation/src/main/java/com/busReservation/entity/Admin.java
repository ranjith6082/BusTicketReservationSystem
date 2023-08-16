package com.busReservation.entity;

import javax.persistence.*;

@Entity
@Table(name = "Admin_details")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Admin_id")
	private int adminId;
	@Column(name = "Admin_name")
	private String adminName;
	@Column(name = "Password")
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(String adminName, String password) {

		this.adminName = adminName;
		this.password = password;
		
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}
	
	
}
