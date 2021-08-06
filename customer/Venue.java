package customer;

import static main.Main.d;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.*;
import login.DBConnection;

public class Venue extends Details implements Booking {
	 Scanner input = new Scanner(System.in);
	 private static  DBConnection db = new DBConnection();

	public Venue(String date, String place, int people, String event) {
		super(date, place, people, event);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Book() {
		// TODO Auto-generated method stub
		System.out.println("Your venue is booked successfully.");
		
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public  void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,name,type,city FROM " + tableName );
		while(rs.next()) {
			int id = rs.getInt("id");
			String showname = rs.getString("name");
			String showtype = rs.getString("type");
			String city = rs.getString("city");
			if(showtype.equals(type) && city.equals(((Dashboard) d).getPlace())) { 
				System.out.println(showname + ":" + id);
			}
		}
		
	}

	@Override
	public void getDetails(int id, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		super.getDetails(id, tableName);
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + "venue");
		while(rs.next()) {
			int capacity = rs.getInt("venue_capacity");
			int venueID = rs.getInt("venue_id");
			String city = rs.getString("city");
			String venueName = rs.getString("venue_name");
			String number = rs.getString("venue_phone");
			String address = rs.getString("venue_address");
			String cost = rs.getString("venue_price/day");
			if(venueID == id) {
				System.out.println("Name : " + venueName +
						"\nAddress : " + address +
						"\nPhone Number : " + number +
						"\nCity : " + city +
						"\nCapacity : " + capacity + 
						"\nCost : " + cost);
				Book();
				break;
			}
		
	}
	
	
	}
    
	
	public  void ask() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	    System.out.println("	*VENUE BOOKINGS*	");
	    String eventType=getEvent();
		getOption(eventType,"venue");
		System.out.println("Choose an option for viewing above options or booking venues :" +
				"\nEnter [1] to view details of an option  " + 
				"\nEnter [2] to book the venue" +
				"\nEnter [0] to EXIT");
        String choice = input.next();
        Connection conn = db.connect();
    	switch(choice) {
    		case "1" :
    			 {
    			String a="";
    		    while(!a.equals("NO"))
    			System.out.print("Enter id :");
    			int id = input.nextInt();
    			getDetails(id,"venue");
    			System.out.println("If you want to view more venues details type YES/NO- ");
    			 a=input.nextLine();	
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

	private void exit(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("End of program");
	    	conn.close();
	        System.exit(0);
	}
	 
	public staic void all() throws ClassNotFoundException, SQLException {
		ask();
	}

	
	
}
