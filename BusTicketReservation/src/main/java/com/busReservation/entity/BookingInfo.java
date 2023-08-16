package com.busReservation.entity;

import javax.persistence.*;

@Entity
@Table(name = "Booking_information")
public class BookingInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Booking_id")
	private int bookingId;
	@Column(name = "User_id")
	private int userId;
	@Column(name = "Bus_no")
	private int busNo;
	@Column(name = "Passenger_name")
	private String passName;
	@Column(name = "Age")
	private int age;
	@Column(name = "Passenger_phno")
	private String passPhno;
	
	public BookingInfo(int userId, int busNo, String passName, int age, String passPhno) {
		super();
		this.userId = userId;
		this.busNo = busNo;
		this.passName = passName;
		this.age = age;
		this.passPhno = passPhno;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getPassName() {
		return passName;
	}

	public void setPassName(String passName) {
		this.passName = passName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassPhno() {
		return passPhno;
	}

	public void setPassPhno(String passPhno) {
		this.passPhno = passPhno;
	}

	public int getBookingId() {
		return bookingId;
	}
	
	
	
	
	
	
	
}
