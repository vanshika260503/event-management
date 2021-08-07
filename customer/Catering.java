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
			int vegcost;
			int nonvegcost = 0;
			if(food.equals("veg")){
				vegcost = rs.getInt("price/plate_veg");
			}
			else {
				vegcost = rs.getInt("price/plate_veg");
				nonvegcost = rs.getInt("price/plate_nonveg");
			}
				
			if(cateringID == id) {
				System.out.println("Name : " + catererName +
						"\nPhone Number : " + number +
						"\nFood type : " + food +
						"\nVeg Cost : " + vegcost +
						"\nNon Veg Cost :" + nonvegcost);
				Book();
				break;
			}
		}
	}
	public static void getVegOption() throws ClassNotFoundException, SQLException {
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
	
	public static void getNonVegOption() throws ClassNotFoundException, SQLException {
		
		Dashboard d = new Dashboard( "Delhi", "wedding", 2);
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT catering_id,caterer_name,food_type FROM catering" );
		while(rs.next()) {
			int id = rs.getInt("catering_id");
			String showname = rs.getString("caterer_name");
			String food = rs.getString("food_type");
			
			if(food.equals("non veg")) { 
				System.out.println(showname + ":" + id);
			}
		}
	}
	@Override
	public void ask() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("veg or non veg?");
		String input = sc.nextLine();
		if(input.equals("veg")) {
			getVegOption();
		}
		else if(input.equals("nonveg")) {
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
	
	

}
