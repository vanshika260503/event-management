package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import login.CustomerLogin;
import login.CustomerRegister;
import login.DBConnection;
import main.Welcome;

public class Payment {
	
	static Scanner sc = new Scanner(System.in);
	static String payment_method;
	private static int bookingID;
	
	
	public static void payOption() throws Exception {
		System.out.println("      ****Paymment Option****     ");
		System.out.println("Choose a payment option : " +
							"\nEnter [1] for debit card" + 
							"\nEnter [2] for gpay/phonepe" + 
							"\nEnter [3] for doing payment later");
		
		
		int option = sc.nextInt();
		switch(option) {
		case 1 :
				System.out.println("Enter your card number");
				long card = sc.nextLong();
				System.out.println("Enter expiry date(MM/YYYY)");
				String expiry = sc.next();
				System.out.println("Enter cvv ");
				int cvv = sc.nextInt();
				payment_method = "Debit card";
				pay();
				break;
		case 2:
			System.out.println("Pay to 6261******");
			payment_method = "gpay/phonepe";
			pay();
			break;
		case 3:
			System.out.println("Your bookings will be confirmed once your payment is done");
			System.out.println("End of the program");
			break;
		}
	}
	
	public static void pay() throws Exception {
		System.out.println("Choose an  option : " +
				"\nEnter [1] to confirm" + 
				"\nEnter [2] to go back");
		int option = sc.nextInt();
		switch(option) {
		case 1 :
			System.out.println("Enter booking id to confirm");
			bookingID = sc.nextInt(); 
			Connection conn = DBConnection.connect();
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery("SELECT payment_status FROM booking where bookingID =" + bookingID);
	        while(rs.next()) {
	        	String status = rs.getString("payment_status");
	        	if(status == null) {
	        		String query = "update booking set payment_method = ?,payment_status =? where bookingID = ?";
				   	PreparedStatement preparedStmt = conn.prepareStatement(query);
				   	preparedStmt.setString   (1,payment_method );
				   	preparedStmt.setString   (2,"Payed" );
				   	preparedStmt.setInt(3, bookingID);
				   	preparedStmt.executeUpdate();
				   	
				   	System.out.println("Thank you for booking your event with us!!" + 
									"\nWe'll send you email of receipt when we'll recieve the payment");
				   	
				   	Email mail = new Email();
					mail.setupServerProperties();
					mail.draftEmail();
					mail.sendEmail();
	        		
	        	}
	        	else {
	        		System.out.println("Already Payed!!");
	        	}
	        }
			break;
		case 2 :
			payOption();
			break;
		}
	}
	public static int getBookingID() {
		return bookingID;
	}
	
}
