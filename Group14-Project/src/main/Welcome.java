package main;
import login.*;

import java.sql.Connection;
import java.util.Scanner;

import customer.Booking;
import customer.Payment;

public class Welcome {
	static Scanner input = new Scanner(System.in);
	static Scanner input2 = new Scanner(System.in);
	private static  DBConnection db = new DBConnection();
	public static String choice2;
	public static void start() throws Exception {
		Connection conn = db.connect();
		System.out.println("-------------------------------------------");
    	System.out.println("    WELCOME TO EVENT MANAGEMENT COMPANY   ");
    	System.out.println("-------------------------------------------");
    	System.out.println("\nChoose an option:" +
    						"\nEnter [1] to login as admin" + 
    						"\nEnter [2] to login or register as a customer" +
    						"\nEnter [0] to EXIT");
    	String choice = input.next();
    	
    	switch(choice) {
    		case "1" :
    			System.out.println("ADMIN'S LOGIN ");
    			AdminLogin.adminLogin();
   
    			break;
    		case "2" :
    			System.out.println("\nChoose an option:" +
						"\nEnter [1] to login" + 
						"\nEnter [2] to register" +
						"\nEnter [0] to back");
    			choice2 = input.next();
    			switch(choice2) {
    				case "1" :
    					System.out.println("CUSTOMER'S LOGIN ");
    					CustomerLogin.customerLogin();
    					System.out.println("\nChoose an option:" +
    							"\nEnter [1] to book new event" + 
    							"\nEnter [2] to view previous bookings" +
    							"\nEnter [3] to pay " +
    							"\nEnter [0] to back");
    					String choice3 = input2.nextLine();
    					switch(choice3) {
    						case "1" :
    							BookEvent.book();
    							break;
    						case "2" :
    							Booking.viewBook();
    							break;
    						case "3" :
    							Payment.payOption();
    							break;
    						case "0" :
    							start();
    							break;
    					}
    					
    					break;
    				case "2" :
    					System.out.println("CUSTOMER'S REGISTRATION ");
    					CustomerRegister.registerPrint();
    					BookEvent.book();
    					break;
    				case "0" :
    					start();
    	                break;
    			}
    		case "0" :
    			exit(conn);
                break;
    		}
    	
    }
	 public static void exit(Connection conn) throws Exception{
	    	System.out.println("End of program");
	    	conn.close();
	        System.exit(0);
	    }

}