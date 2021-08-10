package main;
import login.*;

import java.sql.Connection;
import java.util.Scanner;

public class Welcome {
	private static Scanner input = new Scanner(System.in);
	private static  DBConnection db = new DBConnection();
	public static void start() throws Exception {
		Connection conn = db.connect();
    	System.out.println("    WELCOME TO EVENT MANAGEMENT COMPANY   ");
    	System.out.println("Choose an option:" +
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
    			System.out.println("Choose an option:" +
						"\nEnter [1] to login" + 
						"\nEnter [2] to register" +
						"\nEnter [0] to EXIT");
    			String choice2 = input.next();
    			switch(choice2) {
    				case "1" :
    					System.out.println("CUSTOMER'S LOGIN ");
    					CustomerLogin.customerLogin();
    					break;
    				case "2" :
    					System.out.println("CUSTOMER'S REGISTRATION ");
    					CustomerRegister.registerPrint();
    					break;
    				case "0" :
    	    			exit(conn);
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
