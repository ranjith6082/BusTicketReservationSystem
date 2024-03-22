package com.busReservation.dao;

import java.util.List;

import com.busReservation.entity.*;

public interface BusTicketReservationDao {
	
	public void addUser(User user);
	
	public List<Admin> getAllAdmins();
	
	public boolean isValidAdmin(String adminName,String password);
	
	public List<User> getAllUsers();
	
	public boolean isValidUser(String userName,String password);
	
	public void addBus(BusInfo busInfo);
	
	List<BusInfo> displayAllBuses();
	
	public void addBooking(BookingInfo bookingInfo);
	
	List<BookingInfo> getBookingById(int bookingId);
	
	public BusInfo getBusByNo(int busNo);
	
	List<User> getByEmail(String email);
	
	public void updateBus(BusInfo busInfo);
	
	public void deleteBus(BusInfo busInfo);

	List<BookingInfo> viewAllBooking();

	
		

}
