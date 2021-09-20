package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;
import main.BookEvent;

public class Decoration extends Details implements BookingInterface {
	 private static  DBConnection db = new DBConnection();
	 static Scanner input = new Scanner(System.in);
	 static int decoration_id;
	 static double decoration_cost=0;
	 
	@Override
	public void Book() throws Exception {
		System.out.print("Enter  id of decorator which you finalise for booking - ");
		decoration_id = input.nextInt();
		Connection conn = DBConnection.connect();
	 	Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT decoration,date FROM booking");
		int flag = 0;	
		while(rs.next()) {
				
			int id = rs.getInt("decoration");
			String date = rs.getString("date");
			if(date.equals(Dashboard.getDate()) && id == decoration_id ) {
					flag=1;
				}
			}
		if(flag==1) {
			System.out.println("Decorator already booked!!!! Choose another option");
			ask();
		}
		else {
			System.out.println("Your Decorator is booked successfully.");
		}
	}

	@Override
	public double getPrice() throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,cost FROM decorator" );
		while(rs.next()) {
			int id = rs.getInt("id");
			double cost= rs.getInt("cost");
			if(id==decoration_id) {
				decoration_cost=cost;
			}
	}
		System.out.println("cost-"+decoration_cost);
		return decoration_cost;
	}

	@Override
	public int getID() {
		
		System.out.print("Enter  id of decoration system which you finalise for booking - ");
		decoration_id=input.nextInt();
		return decoration_id;
	}

	@Override
	public void ask() throws Exception {
		Connection conn = db.connect();
		System.out.println("----------------------------");
		System.out.println("   *Decoration bookings*	");
		System.out.println("----------------------------");
		System.out.println("\nChoose an option for viewing above options or booking decorator :" +
				"\nEnter [1] to view details of an option  " + 
				"\nEnter [2] to book the decorator" +
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
    		case "2" :
    			Book();
    			break;
    		case "0" :
    			BookEvent.book();
               break;
    	
    	}
    		
	}

	@Override
	public void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
		String leftAlignFormat = "| %-15d | %-15s |%n";
		System.out.println("Decorator options as per you requirements :");
		System.out.format("+-----------------+----------------+%n");
		System.out.format("|ID               | NAME           |%n");
		System.out.format("+-----------------+----------------+%n");

		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,name,type,city FROM " + tableName );
		while(rs.next()) {
			int id = rs.getInt("id");
			String showname = rs.getString("name");
			String  showtype = rs.getString("type");
			String city = rs.getString("city");
			

			if( city.equals(Dashboard.getPlace()) && showtype.equals(type) ) { 
				System.out.format(leftAlignFormat, id, showname);
			}
		}
		System.out.format("+-----------------+----------------+%n");
	}

	@Override
	public void getDetails(int id, String tableName) throws SQLException, ClassNotFoundException {

		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
		while(rs.next()) {
			int decorID = rs.getInt("id");
			String name = rs.getString("name");
			String city = rs.getString("city");
			String type = rs.getString("type");
			String number = rs.getString("number");
			String cost = rs.getString("cost");
			if(decorID == id)  {
				System.out.println("\nName : " + name +
						"\n City : "+ city+
						"\nType : " + type +
						"\nPhone Number : " + number + 
						"\nCost : " + cost);
				break;
			}
		}
	}
	
	private void rep() throws Exception {
		 System.out.print("Enter id :");
		 int id = input.nextInt();
		 getDetails(id,"decorator");
		 System.out.println("Choose an option for viewing above options or booking decorator :" +
					"\nEnter [1] to view details of an option  " + 
					"\nEnter [2] to book the decorator" +
					"\nEnter [0] to go back");
	 }

}