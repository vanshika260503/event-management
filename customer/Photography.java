package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;

public class Photography extends Details implements Booking {

	static Scanner input = new Scanner(System.in);
	 private static  DBConnection db = new DBConnection();
	 
	@Override
	public void Book() {
		// TODO Auto-generated method stub
		System.out.println("Your photographer is booked successfully.");
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
		// TODO Auto-generated method stub
				Connection conn = db.connect();
			    System.out.println("	*PHOTOGRAPHER BOOKINGS*	");
//			    System.out.println("Enter the venue type");
//			     String venueType=input.next();
//				getOption(venueType,"venue");
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
		ResultSet rs = st.executeQuery("SELECT id,city,name,type FROM photographer" );
		while(rs.next()) {
			int id = rs.getInt("id");
			String cityname = rs.getString("city");
			String showname = rs.getString("name");
			
			String type1 = rs.getString("type");
			if(cityname.equals(Dashboard.getPlace()) && type1.equals(type)) { 
				System.out.println(showname + ":" + id);
			}
		}
	}

	@Override
	public void getDetails(int id, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + "photographer");
		while(rs.next()) {
			int photographerID = rs.getInt("id");
			String city = rs.getString("city");
			String photographerName = rs.getString("name");
			String number = rs.getString("phone");
			String cost = rs.getString("cost");
			String type = rs.getString("type");
			if(photographerID == id) {
				System.out.println("Name : " + photographerName +
						"\nPhone Number : " + number +
						"\nCity : " + city +
						"\nType : " + type +
						"\nCost : " + cost);
				Book();
				break;
			}

	}
		


}
	private void rep() throws ClassNotFoundException, SQLException {
		 System.out.print("Enter id :");
		 int id = input.nextInt();
		 getDetails(id,"venue");
		 System.out.println("Choose an option for viewing above options or booking venues :" +
					"\nEnter [1] to view details of an option  " + 
					"\nEnter [2] to book " +
					"\nEnter [0] to EXIT");
	 }	
}