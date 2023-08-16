package com.busReservation;


import java.util.Scanner;


public class App 
{
	private static Scanner sc;

	public static void main( String[] args )
    {
    	sc = new Scanner(System.in);
    	
    	AppController appController = new AppController();
    	
    	int ch;
    	System.out.println("WELCOME TO BUS RESERVATION \n==========================");
    	//--------------------------CHOOSING ADMIN OR USER-----------------------------//
    	do {
	    	System.out.println("\n====\nMENU \n==== ");
	    	System.out.println("1. ADMIN");
	    	System.out.println("2. USER");
	    	System.out.println("3. Exit");
	    	System.out.print("\nEnter your choice : ");
	    	
	    	ch = sc.nextInt();
	    	
	    	switch(ch) {
	    	
	    		case 1:
	    			//--------------------------CHOOSING NEW ADMIN OR EXISTING ADMIN-----------------------------//
	    			
	    			int adminCh1;
	    			do {
		    			System.out.println("\n==========\nADMIN MENU \n==========");
		    			
		    			System.out.println("1. Admin Login");
		    			System.out.println("2. Exit");
		    			System.out.print("\nEnter your choice : ");
		    			
		    			adminCh1 = sc.nextInt();
		    			
		    			switch(adminCh1) {
		    			
		   		    		 			
		    				case 1:
		 
		    					if(appController.validateAdmin() == true) {
		    								    						
		    						//--------------------------VALIDATING ADMIN IS TRUE-----------------------------//
		    						System.out.println("\nLOGIN SUCCESSFUL.....:)");
		    						
		    						int adminCh2;
		    						
		    						do {
			    						System.out.println("\n=============\nADMIN OPTIONS \n=============");
			    						System.out.println("1. Add Bus details");
			    						System.out.println("2. View all bus details");
			    						System.out.println("3. Update bus details");
			    						System.out.println("4. Delete bus details");
			    						System.out.println("5. View all Bookings");
			    						System.out.println("6. Exit");
			    						System.out.print("\nEnter your choice : ");
			    						
			    						adminCh2 = sc.nextInt();
			    						
			    						switch(adminCh2) {
			    							case 1:
			    								
			    								//--------------------------ADDING NEW BUS INFO-----------------------------//
			    								appController.newBus();
			    								break;
			    								
			    							case 2:
			    								//--------------------------DISPLAYING ALL BUS DETAILS-----------------------------//
			    								appController.getAllBuses();
			    								break;
			    								
			    							case 3:
			    								
			    								//--------------------------UPDATING BUS DETAILS-----------------------------//
			    								appController.getAllBuses();
			    								appController.busUpdate();
			    								break;
			    								
			    							case 4:
			    								
			    								//--------------------------DELETING BUS DETAILS-----------------------------//
			    								appController.getAllBuses();
			    								appController.busDelete();
			    								break;
			    								
			    							case 5:
			    								break;
			    								
			    							case 6:
			    								System.out.println("\nThankyou.....:)");
			    								break;
			    							
			    						}
			    						
		    						}while(adminCh2 != 6);
		    						
		    						
		    					}
		    					
		    					else {
		    						//--------------------------VALIDATING ADMIN IS FALSE-----------------------------//
		    						System.out.println("\nInvalid Admin name and Password...!!!");
		    					}
		    					
		    					break;
		    				
		    				case 2:
		    					
		    					System.out.println("\nTHANKYOU......:)");
		    					break;
		    				
		    			}
	    			}while(adminCh1 != 2);
	    			
	    			break;
	    		case 2:
	    			
	    			//--------------------------CHOOSING NEW USER OR EXISTING USER-----------------------------//
	    			
	    			int userCh1;
	    			
	    			do {
	    				System.out.println("\n=========\nUSER MENU \n=========");
		    			System.out.println("1. New 	User");
		    			System.out.println("2. Existing User");
		    			System.out.println("3. Exit");
		    			System.out.print("\nEnter your choice : ");
		    			
		    			userCh1 = sc.nextInt();
		    			
		    			switch(userCh1) {
		    			
		    				case 1:
		    					
		    					//--------------------------ADDING NEW USER-----------------------------//
		    					appController.newUser();
		    		    		break;
		    		    		
		    				case 2:
		    					
		    					//--------------------------VALIDATING EXISTING USER-----------------------------//
		    					
		    					
		    					if( appController.validateUser() == true) {
		    						
		    						//--------------------------VALIDATING USER IS TRUE-----------------------------//
		    						System.out.println("\nLOGIN SUCCESSFUL.....:)");
		    						
		    						int userCh2;
		    						
		    						do {
			    						System.out.println("\n============\nUSER OPTIONS \n============");
			    						System.out.println("1. Add Booking");
			    						System.out.println("2. View Booking");
			    						System.out.println("3. Exit");
			    						System.out.print("\nEnter your choice : ");
			    						
			    						userCh2 = sc.nextInt();
			    						
			    						switch(userCh2) {
			    							case 1:
			    								
			    								//--------------------------ADD BOOKING DETAILS-----------------------------//
			    								appController.getAllBuses();
			    								appController.newBooking();	    								
			    								break;
			    								
			    							case 2:
			    								
			    								break;
			    								
			    							case 3:
			    											    								
			    								break;
			    								
			    						}
		    						}while(userCh2 != 3);
		    						
		    					}
		    					
								else {
									//--------------------------VALIDATING USER IS FALSE-----------------------------//
									System.out.println("\nInvalid User name and Password...!");
								}
								
								break;
								
		    				case 3:
		    					
		    					break;
					
		    			} 
	    			}while(userCh1 != 3);
	    			
	    		case 3:
	    			System.out.println("THANKYOU......:)");
	    			break;
	    	}
	    	
    	}while(ch != 3);
    	
    	
    		 
    	
    }
}
