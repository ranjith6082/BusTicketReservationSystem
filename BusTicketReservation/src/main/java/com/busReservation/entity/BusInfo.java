package com.busReservation.entity;

import javax.persistence.*;

@Entity
@Table(name = "Bus_information")
public class BusInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Bus_no")
	private int busNo;
	@Column(name = "Bus_name")
	private String busName;
	@Column(name = "Start_point")
	private String startPoint;
	@Column(name = "Destination")
	private String destination;
	@Column(name = "Capacity")
	private int capacity;
	@Column(name = "Travel_date")
	private String date;
	@Column(name = "Driver_name")
	private String driverName;
	@Column(name = "Driver_phno")
	private String driverPhno;
	
	public BusInfo() {
		
	}
	
	public BusInfo(String busName, String startPoint, String destination, int capacity, String date, String driverName, String driverPhno) {
		
		this.busName = busName;
		this.startPoint = startPoint;
		this.destination = destination;
		this.capacity = capacity;
		this.date = date;
		this.driverName = driverName;
		this.driverPhno = driverPhno;
		
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPhno() {
		return driverPhno;
	}
	public void setDriverPhno(String driverPhno) {
		this.driverPhno = driverPhno;
	}
	public int getBusNo() {
		return busNo;
	} 
	

}
