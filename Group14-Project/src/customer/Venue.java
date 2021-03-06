package customer;


import main.BookEvent;
import main.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTable;

import login.DBConnection;

public class Venue extends Details implements BookingInterface {
	 static Scanner input = new Scanner(System.in);
	 private static  DBConnection db = new DBConnection();
	 static int venueID;
	 static double venue_cost=0;
	 
	
	
	@Override
	public void Book() throws Exception {
		System.out.print("Enter  id of venue system which you finalise for booking - ");
		venueID =input.nextInt();
		Connection conn = DBConnection.connect();
	 	Statement st = conn.createStatement();
	 	//checking whether venue is available for specific date
		ResultSet rs = st.executeQuery("SELECT venue,date FROM booking");
		int flag = 0;	
		while(rs.next()) {
				
			int id = rs.getInt("venue");
			String date = rs.getString("date");
			if(date.equals(Dashboard.getDate()) && id == venueID ) {
					flag=1;
				}
			}
		if(flag==1) {
			System.out.println("Venue already booked!!!! Choose another option");
			ask();
		}
		else {
			System.out.println("Your venue is booked successfully.");
			
		}
		
	}

	@Override
	public double getPrice() throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,cost FROM venue" );
		while(rs.next()) {
			int id = rs.getInt("id");
			double cost= rs.getInt("cost");
			if(id==venueID) {
				venue_cost=cost;
			}
	}
		System.out.println("cost-"+venue_cost);
		return venue_cost;
	}

	@Override
	public  void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
		
		String leftAlignFormat = "| %-15d | %-14s |%n";

		System.out.format("+-----------------+----------------+%n");
		System.out.format("|ID               | NAME           |%n");
		System.out.format("+-----------------+----------------+%n");
		
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,name,type,city,venue_capacity FROM " + tableName );
		while(rs.next()) {
			int id = rs.getInt("id");
			String showname = rs.getString("name");
			String showtype = rs.getString("type");
			String city = rs.getString("city");
			int capacity = rs.getInt("venue_capacity");

			if( city.equals(Dashboard.getPlace()) && Dashboard.getPeople() <= capacity && type.equals(showtype) ) { 
				System.out.format(leftAlignFormat, id, showname);
			}
			 
		}
		System.out.format("+-----------------+----------------+%n");
	}

	@Override
	public void getDetails(int id, String tableName) throws ClassNotFoundException, SQLException {

		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
		while(rs.next()) {
			int capacity = rs.getInt("venue_capacity");
			int venueID = rs.getInt("id");
			String city = rs.getString("city");
			String venueName = rs.getString("name");
			String number = rs.getString("phone");
			String address = rs.getString("venue_address");
			String cost = rs.getString("cost");
			
			if(venueID == id) {
				System.out.println("\nName : " + venueName +
						"\nAddress : " + address +
						"\nPhone Number : " + number +
						"\nCity : " + city +
						"\nCapacity : " + capacity + 
						"\nCost : " + cost );
				break;
			}
		}
	}
	
	public  void ask() throws Exception {
		
		Connection conn = db.connect();
		System.out.println("------------------------");
	    System.out.println("   *VENUE BOOKINGS*	");
	    System.out.println("------------------------");
	    
		System.out.println("\nChoose an option for viewing above options or booking venues :" +
				"\nEnter [1] to view details of an option  " + 
				"\nEnter [2] to book the venue" +
				"\nEnter [0] to back");
        String choice = input.next();

    	switch(choice) {
    		case "1" :
    			rep();
    			
    			String choice3 = input.next();
    			switch(choice3) {
    			case "1" :
    				rep();
    				break;
    			case "2" :
    				Book();
    				break;
    			case "3" :
    				BookEvent.book();
    				break;
    			}
    			break;
    		case "2" :{
    			Book();
    			break;
    		}
    		case "0" :{
    			BookEvent.book();
               break;
            }
    	
    	}
    		
    	
    }

	@Override
	public int getID() {
		return venueID;
	}
	
	private void rep() throws ClassNotFoundException, SQLException {
		 System.out.print("Enter id :");
		 int id = input.nextInt();
		 getDetails(id,"venue");
		 System.out.println("\nChoose an option for viewing above options or booking venues :" +
					"\nEnter [1] to view details of an option  " + 
					"\nEnter [2] to book " +
					"\nEnter [0] to back");
	 }
	
}