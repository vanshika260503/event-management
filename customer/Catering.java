package customer;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;

public class Catering extends Details implements BookingInterface{
	
	//public static Dashboard d =  customer.Input.getInput();
	private static  DBConnection db = new DBConnection();
	static Scanner input = new Scanner(System.in);
	static int catering_id;
	static double catering_cost=0;
	
   public Catering() {
	   super();
   }
   
   
   
	public Catering(String date, String place, int people) {
	super(date, place, people);
	// TODO Auto-generated constructor stub
}



	@Override
	public void Book() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.print("Enter  id of catering system which you finalise for booking - ");
		catering_id=input.nextInt();
		Connection conn = DBConnection.connect();
	 	Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT catering,date FROM booking");
		int flag = 0;	
		while(rs.next()) {
				
			int id = rs.getInt("catering");
			String date = rs.getString("date");
			if(date.equals(Dashboard.getDate()) && id == catering_id ) {
					flag=1;
				}
			}
		if(flag==1) {
			System.out.println("Caterer already booked!!!! Choose another option");
			ask();
		}
		else {
			System.out.println("Your caterer is booked successfully.");
		}

	}

	@Override
	public double getPrice() throws SQLException, ClassNotFoundException {
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,cost FROM catering" );
		while(rs.next()) {
			int id = rs.getInt("id");
			double cost= rs.getInt("cost");
			if(id==catering_id) {
				catering_cost=cost;
			}
	}
		System.out.println("cost-"+catering_cost);
		return catering_cost;
	}



	@Override
	public void getDetails(int id, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
//		super.getDetails(id, tableName);
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + "catering");
		while(rs.next()) {
			int cateringID = rs.getInt("id");
			String city = rs.getString("city");
			String Name = rs.getString("name");
			String number = rs.getString("phone");
			String cost = rs.getString("cost");
			if(cateringID == id) {
				System.out.println("Name : " + Name +
						"\nPhone Number : " + number +
						"\nCity : " + city + 
						"\nCost : " + cost );
				break;
			}
		}
	}
	
	@Override
	public  void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String leftAlignFormat = "| %-15d | %-20s |%n";

		System.out.format("+-----------------+---------------------+%n");
		System.out.format("|ID               | NAME                |%n");
		System.out.format("+-----------------+---------------------+%n");
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,name,type,city FROM " + tableName );
		while(rs.next()) {
			int id = rs.getInt("id");
			String showname = rs.getString("name");
			String showtype = rs.getString("type");
			String city = rs.getString("city");
//			System.out.println("Best options according to requirements");
		//  && type.equals(showtype)
			if( city.equals(Dashboard.getPlace()) && showtype.equals(type) ) { 
				System.out.format(leftAlignFormat, id, showname);
			}
		}
		System.out.format("+-----------------+---------------------+%n");
		
	}
	
//	private static void getNonVegOption() throws ClassNotFoundException, SQLException {
//		
//		Dashboard d = new Dashboard( "Delhi", "wedding", 2);
//		Connection conn = DBConnection.connect();
//		Statement st = conn.createStatement();
//		ResultSet rs = st.executeQuery("SELECT id,name,type FROM catering" );
//		while(rs.next()) {
//			int id = rs.getInt("id");
//			String showname = rs.getString("name");
//			String food = rs.getString("type");
//			
//			if(food.equals("non veg")) { 
//				System.out.println(showname + ":" + id);
//			}
//		}
//	}
	public  void ask() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = db.connect();
	    System.out.println("	*CATERING BOOKINGS*	");
//	    System.out.println("Enter the venue type");
//	     String venueType=input.next();
//		getOption(venueType,"venue");
		System.out.println("Choose an option for viewing above options or booking venues :" +
				"\nEnter [1] to view details of an option  " + 
				"\nEnter [2] to book the venue" +
				"\nEnter [0] to EXIT");
		Scanner input = new Scanner(System.in);
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
	
	private void rep() throws ClassNotFoundException, SQLException {
		 System.out.print("Enter id :");
		 int id = input.nextInt();
		 getDetails(id,"catering");
		 System.out.println("Choose an option for viewing above options or booking venues :" +
					"\nEnter [1] to view details of an option  " + 
					"\nEnter [2] to book the venue" +
					"\nEnter [0] to EXIT");
	 }


	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return catering_id;
	}
	
	

}