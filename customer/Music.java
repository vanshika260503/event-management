package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;

public class Music extends Details implements Booking {
	
	static Scanner input = new Scanner(System.in);
	 private static  DBConnection db = new DBConnection();

	@Override
	public void Book() {
		// TODO Auto-generated method stub
		System.out.println("Your music system is booked successfully.");
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ask() throws ClassNotFoundException, SQLException {
		Connection conn = db.connect();
	    System.out.println("	*MUSIC BOOKINGS*	");
//	    System.out.println("Enter the venue type");
//	     String venueType=input.next();
//		getOption(venueType,"venue");
		System.out.println("Choose an option for viewing above options or booking venues :" +
				"\nEnter [1] to view details of an option  " + 
				"\nEnter [2] to book the venue" +
				"\nEnter [0] to EXIT");
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
    				exit(conn);
    				break;
    			}
    			break;
    		case "2" :{
    			Book();
    			break;
    		}
    		case "0" :{
    			exit(conn);
               break;}
    	
    	}
    		

	}

	@Override
	public void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,name,type,city FROM music" );
		while(rs.next()) {
			int id = rs.getInt("id");
			String showname = rs.getString("name");
			String type1 = rs.getString("type");
			String city = rs.getString("city");
			if(type1.equals(type) && city.equals(Dashboard.getPlace())) { 
				System.out.println(showname + ":" + id);
			}
		
		}
	}
		

	@Override
	public void getDetails(int id, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + "music");
		while(rs.next()) {
			int musicID = rs.getInt("id");
			String city = rs.getString("city");
			String djName = rs.getString("name");
			String type = rs.getString("type");
			String number = rs.getString("phone");
			String cost = rs.getString("cost");
			if(musicID == id) {
				System.out.println("Name : " + djName +
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
		 getDetails(id,"venue");
		 System.out.println("Choose an option for viewing above options or booking music system :" +
					"\nEnter [1] to view details of an option  " + 
					"\nEnter [2] to book " +
					"\nEnter [0] to EXIT");
	 }

}
