package customer;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;

public class Catering extends Details implements Booking{
   public Catering() {
	   super();
   }
   
   
   
	public Catering(String date, String place, int people) {
	super(date, place, people);
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
	public void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	System.out.println();	
	}

	@Override
	public void getDetails(int id, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + "catering");
		while(rs.next()) {
			int cateringID = rs.getInt("id");
			String catererName = rs.getString("name");
			String number = rs.getString("phone");
			String food = rs.getString("type");
			String city = rs.getString("city");
			int vegcost=0;
			int nonvegcost = 0;
			if(food.equals("veg")){
				vegcost = rs.getInt("cost");
			}
			else {
//				vegcost = rs.getInt("price/plate_veg");
				nonvegcost = rs.getInt("cost");
			}
			
			if(cateringID == id && rs.getString("type").equals("non veg") && city.equals(Dashboard.getPlace())) {
				System.out.println("Name : " + catererName +
						"\nPhone Number : " + number +
						"\nFood type : " + food +
						"\nNon-Veg Cost : " + nonvegcost );
				Book();
				break;
			}
			
			else {
				System.out.println("Name : " + catererName +
						"\nPhone Number : " + number +
						"\nFood type : " + food +
						"\nVeg Cost : " + vegcost );
				Book();
				break;
			}
		}
	}
	private static void getVegOption() throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,name,type FROM catering" );
		while(rs.next()) {
			int id = rs.getInt("id");
			String showname = rs.getString("name");
			String food = rs.getString("type");
			
			if(food.equals("veg")) { 
				System.out.println(showname + ":" + id);
			}
		}
	}
	
	private static void getNonVegOption() throws ClassNotFoundException, SQLException {
		
		Dashboard d = new Dashboard( "Delhi", "wedding", 2);
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id,name,type FROM catering" );
		while(rs.next()) {
			int id = rs.getInt("id");
			String showname = rs.getString("name");
			String food = rs.getString("type");
			
			if(food.equals("non veg")) { 
				System.out.println(showname + ":" + id);
			}
		}
	}
	@Override
	public void ask() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Which type of food you want (veg or non veg)- ");
		String input = sc.nextLine();
		if(input.equals("veg")) {
			getVegOption();
		}
		else if(input.equals("non veg")) {
			getNonVegOption();
		}
		else {
			System.out.println("Invalid");
		}
		System.out.println("Enter id?");
		int id = sc.nextInt();
		getDetails(id,"catering");
		sc.close();
	}



	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
