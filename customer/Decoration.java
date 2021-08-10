package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;

public class Decoration extends Details implements Booking {
	 private static  DBConnection db = new DBConnection();
	 static Scanner input = new Scanner(System.in);
	 
	@Override
	public void Book() {
		// TODO Auto-generated method stub
		System.out.println("Your decorator is booked successfully.");
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
		System.out.println("	*Decoration bookings*	");
		System.out.println("Choose an option for viewing above options or booking decorator :" +
				"\nEnter [1] to view details of an option  " + 
				"\nEnter [2] to book the decorator" +
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
    		case "2" :
    			Book();
    			break;
    		case "0" :
    			exit(conn);
               break;
    	
    	}
    		
	}

	@Override
	public void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Decorator options as per you requirements :");
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,name,type,city FROM " + tableName );
		while(rs.next()) {
			int id = rs.getInt("id");
			String showname = rs.getString("name");
			String  showtype = rs.getString("type");
			String city = rs.getString("city");
			

			if( city.equals(Dashboard.getPlace()) ) { 
				System.out.println(id + ":" +showname);
			}
		}
		

	}

	@Override
	public void getDetails(int id, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + "decorator");
		while(rs.next()) {
			int decorID = rs.getInt("id");
			String name = rs.getString("name");
			String city = rs.getString("city");
			String type = rs.getString("type");
			String number = rs.getString("number");
			String cost = rs.getString("cost");
			if(decorID == id)  {
				System.out.println("Name : " + name +
						"\n City : "+ city+
						"\nType : " + type +
						"\nPhone Number : " + number + 
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
					"\nEnter [2] to book the venue" +
					"\nEnter [0] to EXIT");
	 }

}