package com.busReservation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.busReservation.dao.BusTicketReservationDAOImpl;
import com.busReservation.dao.BusTicketReservationDao;
import com.busReservation.entity.*;

public class AppController {
	
	BusTicketReservationDao bus = new BusTicketReservationDAOImpl();
	Scanner sc = new Scanner(System.in);
	
	//--------------------------VALIDATING EXISTING ADMIN-----------------------------//
	public boolean validateAdmin() {
		System.out.println("\n==============\nExisting ADMIN \n==============");
		System.out.print("Enter Admin name : ");
		String exAdminName = sc.next();
		System.out.print("Enter Password : ");
		String adminPassword = sc.next();
			
		return(bus.isValidAdmin(exAdminName,adminPassword));
		
	}
	
	//--------------------------CREATING NEW USER-----------------------------//
	public void newUser() {
		
		System.out.println("\n========\nNew User \n========");
		System.out.print("Enter User name : ");
		String userName = sc.next();
		System.out.print("Enter Email :");
		String email = sc.next();
		System.out.print("Enter password : ");
		String u_password = sc.next();
		 
		User user = new User(userName,email,u_password);
		
		bus.addUser(user);
		
		System.out.println("\nWelcome "+userName+"....:)");
	}
	
	//--------------------------VALIDATING EXISTING USER-----------------------------//
	public boolean validateUser() {
		System.out.println("\n=============\nExisting User \n=============");
		System.out.print("Enter User name : ");
		String exUserName = sc.next();
		System.out.print("Enter Password : ");
		String userPassword = sc.next();
		
		return(bus.isValidUser(exUserName,userPassword));
		
	}
	

	
	//--------------------------ADDING NEW BUS INFO-----------------------------//
	public void newBus() {
		
		System.out.println("\n=================\nENTER BUS DETAILS \n=================");
		System.out.print("Enter Bus Name : ");
		String busName = sc.next();
		sc.nextLine();
		System.out.print("Enter Starting Point : ");
		String startPoint = sc.next();
		System.out.print("Enter Destination : ");
		String destination = sc.next();
		System.out.print("Enter Capacity : ");
		int capacity = sc.nextInt();
		System.out.print("Enter Journey Date (DD/MM/YYYY) : ");
		String date = sc.next();
		sc.nextLine();
		System.out.print("Enter Driver Name : ");
		String driverName = sc.next();
		System.out.print("Enter Driver Phno : ");
		String driverPhno = sc.next();
		
		BusInfo busInfo = new BusInfo(busName,startPoint,destination,capacity,date,driverName,driverPhno);
		
		bus.addBus(busInfo);
		
		System.out.println("\nBUS INFORMATION ADDED SUCCESSFULLY....:)");
	}
	
	//--------------------------ADD BOOKING DETAILS-----------------------------//
		public void newBooking() {
			System.out.print("\nEnter your registered E-mail : ");
			String email = sc.next();
			
	        List<User> users = bus.getByEmail(email);

	        if (!users.isEmpty()) {
	            for (User user : users) {
	            	System.out.println("\n============\nUSER DETAILS \n============");
	                System.out.println("User ID: " + user.getUserId());
	                System.out.println("User Name: " + user.getUserName());
	            }
	        } else {
	            System.out.println("No user found with the provided email.");
	            return;
	        }  
		        	
		            
			 
			
			System.out.print("\n===============\nBOOKING DETAILS \n===============");
			System.out.print("\nEnter User ID : ");
			int userId = sc.nextInt();
			System.out.print("Enter Bus No : ");
			int busNo = sc.nextInt();
			System.out.print("Enter Passenger Name : ");
			String passName = sc.next();
			System.out.print("Enter Passenger Age : ");
			int age = sc.nextInt();
			System.out.print("Enter Passenger Phno : ");
			String passPhno = sc.next();
			
			BookingInfo bookingInfo = new BookingInfo(userId,busNo,passName,age,passPhno);
			
			bus.addBooking(bookingInfo);
			
			System.out.println("\nBOOKING SUCCESSFUL.....:)");
		}
	
	
	//--------------------------UPDATING BUS DETAILS-----------------------------//
	public void busUpdate() {
		 System.out.print("\nEnter Bus No to update: ");
	        int busNo = sc.nextInt();

	        BusInfo busInfo = bus.getBusByNo(busNo);
	        if (busInfo != null) {
	            System.out.println("\nBus found \n=========");
	            System.out.println("Bus No : " + busInfo.getBusNo());
	            System.out.println("Bus Name : " + busInfo.getBusName());
	            System.out.println("Current Capacity : " + busInfo.getCapacity());
	            System.out.println("Current Driver's Name : " + busInfo.getDriverName());
	            System.out.println("Current Driver's Phno: " + busInfo.getDriverPhno());
	            
	            System.out.print("\n======\nUPDATE \n====== ");
	            System.out.print("\nEnter new Bus Name : ");
	            String newBusName = sc.next();
	            System.out.print("Enter new Capacity: ");
	            int newCapacity = sc.nextInt();
	            System.out.print("Enter new Driver Name : ");
	            String newDriverName = sc.next();
	            System.out.print("Enter new Driver Phno : ");
	            String newDriverPhno = sc.next();
	            
	            busInfo.setBusName(newBusName);
	            busInfo.setCapacity(newCapacity);
	            busInfo.setDriverName(newDriverName);
	            busInfo.setDriverPhno(newDriverPhno);
	            bus.updateBus(busInfo);

	            System.out.println("\nBus details updated successfully.");
	        } else {
	            System.out.println("\nBus not found....!!!");
	        }
	}
	
	//--------------------------DISPLAYING ALL BUS DETAILS-----------------------------//
	public void getAllBuses(){
		System.out.println("\nAll Bus Details:");
        List<BusInfo> buses = bus.displayAllBuses();

        if (!buses.isEmpty()) {
        	System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------------");
            String format = "| %-8s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n ";
            System.out.printf(format, "Bus No", "Bus Name", "Starting Point", "Destination", "Capacity", "Date", "Driver's Name",  "Driver's Phno");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");

            for (BusInfo busInfo : buses) {
                System.out.printf(format,
                        busInfo.getBusNo(),
                        busInfo.getBusName(),
                        busInfo.getStartPoint(),
                        busInfo.getDestination(),
                        busInfo.getCapacity(),
                        busInfo.getDate(),
                        busInfo.getDriverName(),                      
                        busInfo.getDriverPhno());
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            }
        } 
        
        else {
            System.out.println("\nNo buses found....!!!");
        }
	}
	
	//--------------------------DELETING BUS DETAILS-----------------------------//
	public void busDelete() {
		 System.out.print("\nEnter Bus No to delete: ");
	        int busNo = sc.nextInt();

	        BusInfo busToDelete = bus.getBusByNo(busNo);
	        if (busToDelete != null) {
	            bus.deleteBus(busToDelete);
	            System.out.println("\nBus information deleted successfully....:)");
	        } 
	        else {
	            System.out.println("\nBus not found....!!!");
	        }
	}
	
	
	//--------------------------DISPLAYING BOOKING ID DETAILS-----------------------------//
	public void getBookingId(int bookingId) {
	    System.out.println("\nBooking Details:");

	    // Fetch the booking details based on the booking ID
	    List<BookingInfo> bookings = bus.getBookingById(bookingId);

	    if (!bookings.isEmpty()) {
	        System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------------------");
	        String format = "| %-10s | %-10s | %-7s | %-15s | %-7s | %-15s |%n";
	        System.out.printf(format, "Booking ID", "User ID", "Bus No", "Passenger Name", "Age","Phoneno");
	        System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------------------");

	        for (BookingInfo booking : bookings) {
	            System.out.printf(format,
	                    booking.getBookingId(),
	                    booking.getUserId(),
	                    booking.getBusNo(),
	                    booking.getPassName(),
	                    booking.getAge(),
	            		booking.getPassPhno());
	            System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------------------");
	        }
	    } else {
	        System.out.println("\nNo bookings found with the given booking ID....!!!");
	    }
	}
	
	
	
	
	//--------------------------DISPLAYING VIEW ALL BOOKING-----------------------------//
		public void getAllBookings() {
		    System.out.println("\nBooking Details:");

		    // Fetch the booking details based on the booking ID
		    List<BookingInfo> bookings = bus.viewAllBooking();

		    if (!bookings.isEmpty()) {
		        System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------------------");
		        String format = "| %-10s | %-10s | %-7s | %-15s | %-7s |%n";
		        System.out.printf(format, "Booking ID", "User ID", "Bus No", "Passenger Name", "Age");
		        System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------------------");

		        for (BookingInfo booking : bookings) {
		            System.out.printf(format,
		                    booking.getBookingId(),
		                    booking.getUserId(),
		                    booking.getBusNo(),
		                    booking.getPassName(),
		                    booking.getAge());
		            System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------------------");
		        }
		    } else {
		        System.out.println("\nNo bookings found ....!!!");
		    }
		}
}
