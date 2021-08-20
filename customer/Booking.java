package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import login.*;
import main.Main;
import main.Welcome;

public class Booking {
	
		public static String getUs;
		public static String getPh;
		
       
       public static void store() throws Exception {
    	   Connection conn = DBConnection.connect();
   		
    	   if(Welcome.choice2.equals("1")) {
    		   getUs = CustomerLogin.getUsername();
    		   getPh = CustomerLogin.getPhone();
    	   }
    	   else {
    		 getUs = CustomerRegister.getUsername();
    		 getPh = CustomerRegister.getPhone();
    	   }
    	
   			String sql = "insert into booking(date,username,phone,city,people,venue,catering,decoration,music,photography,price) values (?,?,?,?,?,?,?,?,?,?,?)";
   		
   			PreparedStatement myStmt = conn.prepareStatement(sql);
   			myStmt.setString(1, Dashboard.getDate());
   			myStmt.setString(2, getUs);
   			myStmt.setString(3, getPh);
   			myStmt.setString(4, Dashboard.getPlace());
   			myStmt.setInt(5, Dashboard.getPeople());
   			myStmt.setInt(6, Venue.venueID);
   			myStmt.setInt(7, Catering.catering_id);
   			myStmt.setInt(8, Decoration.decoration_id);
   			myStmt.setInt(9, Music.music_id);
   			myStmt.setInt(10, Photography.photographer_id);
   			myStmt.setDouble(11, price());

   		
   			myStmt.executeUpdate();
   			System.out.println("Successfully registered");
   		}
       
       public static void BookingDetails() throws Exception {
    	   if(Welcome.choice2.equals("1")) {
      		 getUs = CustomerLogin.getUsername();
      		 getPh = CustomerLogin.getPhone();
    	   }
    	   else {
      		 getUs = CustomerRegister.getUsername();
      		 getPh = CustomerRegister.getPhone();
    	   }
    	   System.out.println("--------------------------");
    	   System.out.println("*****BOOKING DETAILS******" );
    	   System.out.println("--------------------------");
    	   
    	   Connection conn = DBConnection.connect();
    	   Statement st = conn.createStatement();
   			ResultSet rs = st.executeQuery("SELECT * FROM booking");
   		
   		while(rs.next()) {
   			
   			String us = rs.getString("username");
   			String id = rs.getString("bookingID");
   			String date = rs.getString("date");
   			if(Dashboard.getDate()==null) {
   				if(getUs.equals(us)) {
   					System.out.println("Booking ID = " + id);
   				}
   			}
   			else {
   				if(getUs.equals(us) && Dashboard.getDate().equals(date)) {
   					System.out.println("Booking ID = " + id);
   				 }
   			}
   		}
   		ResultSet rs1 = st.executeQuery("SELECT * FROM venue");
   		while(rs1.next()) {
   			String venue = rs1.getString("name");
   			int id = rs1.getInt("id");
   			if(id == Venue.venueID) {
   				System.out.println("Venue :" + venue);
   			}
   		}
   		ResultSet rs2 = st.executeQuery("SELECT * FROM catering");
   		while(rs2.next()) {
   			String name = rs2.getString("name");
   			int id = rs2.getInt("id");
   			if(id == Catering.catering_id) {
   				System.out.println("Caterer :" + name);
   			}
   		}
   		ResultSet rs3 = st.executeQuery("SELECT * FROM decorator");
   		while(rs3.next()) {
   			String name = rs3.getString("name");
   			int id = rs3.getInt("id");
   			if(id == Decoration.decoration_id) {
   				System.out.println("Decorator :" + name);
   			}
   		}
   		ResultSet rs4 = st.executeQuery("SELECT * FROM music");
   		while(rs4.next()) {
   			String name = rs4.getString("name");
   			int id = rs4.getInt("id");
   			if(id == Music.music_id) {
   				System.out.println("Music :" + name);
   			}
   		}
   		ResultSet rs5 = st.executeQuery("SELECT * FROM photographer");
   		while(rs5.next()) {
   			String name = rs5.getString("name");
   			int id = rs5.getInt("id");
   			if(id == Photography.photographer_id) {
   				System.out.println("Photography :" + name);
   			}
   		}
   		System.out.println("Total Price - " + price());
		
   		System.out.println("\n\n::::Please remember your booking ID for future reference::::\n\n");
		Payment.payOption();
      }

       public static double price() {
    	   double price = Music.music_cost + Venue.venue_cost + Photography.photographer_cost + Decoration.decoration_cost + (Catering.catering_cost) *(Dashboard.getPeople()) ;
    	   
    	   return price;
       }
       
       public static void viewBook() throws Exception {
    	   getUs = CustomerLogin.getUsername();
    	   getPh = CustomerLogin.getPhone();
    	   System.out.println("*****BOOKING DETAILS******" );
    	   Connection conn = DBConnection.connect();
    	   Statement st = conn.createStatement();
   			ResultSet rs = st.executeQuery("SELECT * FROM booking");
   			while(rs.next()) {
   	   			
   	   			String us = rs.getString("username");
   	   			String id = rs.getString("bookingID");
   	   			String date = rs.getString("date");
   	   			if(getUs.equals(us)) {
   	   				System.out.println("Booking ID = " + id);
   	   			}
   			}
   			System.out.println("Enter the bookind id of the event you want to view :");
   			Scanner sc = new Scanner(System.in);
   			int input = sc.nextInt();
   			int venueId = 0;
   			int catering = 0;
   			int music = 0;
   			int photography = 0;
   			int decoration = 0;
   			double price =0;
   			ResultSet rs17 = st.executeQuery("SELECT * FROM booking");
   			while(rs17.next()) {
   				int id = rs17.getInt("bookingID");
   				if(id == input) {
   					venueId = rs17.getInt("venue");
   					catering = rs17.getInt("catering");
   					music = rs17.getInt("music");
   					photography = rs17.getInt("photography");
   					decoration = rs17.getInt("decoration");
   					price = rs17.getDouble("price");
   				}
   			}
   			
   			ResultSet rs1 = st.executeQuery("SELECT * FROM venue");
   	   		while(rs1.next()) {
   	   			String venue = rs1.getString("name");
   	   			int id = rs1.getInt("id");
   	   			if(id == venueId) {
   	   				System.out.println("Venue :" + venue);
   	   			}
   	   		}
   	   		ResultSet rs2 = st.executeQuery("SELECT * FROM catering");
   	   		while(rs2.next()) {
   	   			String name = rs2.getString("name");
   	   			int id = rs2.getInt("id");
   	   			if(id == catering) {
   	   				System.out.println("Caterer :" + name);
   	   			}
   	   		}
   	   		ResultSet rs3 = st.executeQuery("SELECT * FROM decorator");
   	   		while(rs3.next()) {
   	   			String name = rs3.getString("name");
   	   			int id = rs3.getInt("id");
   	   			if(id == decoration) {
   	   				System.out.println("Decorator :" + name);
   	   			}
   	   		}
   	   		ResultSet rs4 = st.executeQuery("SELECT * FROM music");
   	   		while(rs4.next()) {
   	   			String name = rs4.getString("name");
   	   			int id = rs4.getInt("id");
   	   			if(id == music) {
   	   				System.out.println("Music :" + name);
   	   			}
   	   		}
   	   		ResultSet rs5 = st.executeQuery("SELECT * FROM photographer");
   	   		while(rs5.next()) {
   	   			String name = rs5.getString("name");
   	   			int id = rs5.getInt("id");
   	   			if(id == photography) {
   	   				System.out.println("Photography :" + name);
   	   			}
   	   		}
   	   		System.out.println("Price :"+ price);
   			
       }
       
      
}
       

    	
