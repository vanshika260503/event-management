package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;
import main.BookEvent;

public class Music extends Details implements BookingInterface {
	
	static Scanner input = new Scanner(System.in);
	 private static  DBConnection db = new DBConnection();
     static int music_id=0;
     static double music_cost=0;
     
	@Override
	public void Book() throws Exception {
		System.out.print("Enter  id of music system which you finalise for booking - ");
		music_id=input.nextInt();
		Connection conn = DBConnection.connect();
	 	Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT music,date FROM booking");
		int flag = 0;	
		while(rs.next()) {
				
			int id = rs.getInt("music");
			String date = rs.getString("date");
			if(date.equals(Dashboard.getDate()) && id == music_id ) {
					flag=1;
				}
			}
		if(flag==1) {
			System.out.println("Music system already booked!!!! Choose another option");
			ask();
		}
		else {
			System.out.println("Your music system is booked successfully.");
		}
	}

	@Override
	public double getPrice() throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,cost FROM music" );
		while(rs.next()) {
			int id = rs.getInt("id");
			double cost= rs.getInt("cost");
			if(id==music_id) {
				music_cost=cost;
			}
	}
		System.out.println("cost-"+music_cost);
		return music_cost;
}

	@Override
	public  int getID() {
		
		return music_id;
	}

	@Override
	public void ask() throws Exception {
		Connection conn = db.connect();
		System.out.println("--------------------");
	    System.out.println("   MUSIC BOOKINGS	");
		System.out.println("--------------------");

		System.out.println("Choose an option for viewing above options or booking music system :" +
				"\nEnter [1] to view details of an option  " + 
				"\nEnter [2] to book the music system" +
				"\nEnter [0] to go back");
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
	public void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {

		String leftAlignFormat = "| %-15d | %-15s |%n";

		System.out.format("+-----------------+----------------+%n");
		System.out.format("|ID               | NAME           |%n");
		System.out.format("+-----------------+----------------+%n");
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,name,type,city FROM music" );
		while(rs.next()) {
			int id = rs.getInt("id");
			String showname = rs.getString("name");
			String type1 = rs.getString("type");
			String city = rs.getString("city");
			if(type1.equals(type) && city.equals(Dashboard.getPlace())) { 
				System.out.format(leftAlignFormat, id, showname);
			}
		
		}
		System.out.format("+-----------------+----------------+%n");
	}
		

	@Override
	public void getDetails(int id, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
		while(rs.next()) {
			int musicID = rs.getInt("id");
			String city = rs.getString("city");
			String djName = rs.getString("name");
			String type = rs.getString("type");
			String number = rs.getString("phone");
			String cost = rs.getString("cost");
			if(musicID == id) {
				System.out.println("\nName : " + djName +
						"\nPhone Number : " + number +
						"\nCity : " + city +
						"\ntype : " + type + 
						"\nCost : " + cost);
				break;
			}
		}
	

	}
	
	private void rep() throws ClassNotFoundException, SQLException {
		 System.out.print("Enter id :");
		 int id = input.nextInt();
		 getDetails(id,"music");
		 System.out.println("Choose an option for viewing above options or booking music system :" +
					"\nEnter [1] to view details of an option  " + 
					"\nEnter [2] to book " +
					"\nEnter [0] to go back");
	 }
}