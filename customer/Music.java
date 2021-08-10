package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;

public class Music extends Details implements Booking {

	@Override
	public void Book() {
		// TODO Auto-generated method stub

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
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id :");
		int id = sc.nextInt();
		getDetails(id,"music");

	}

	@Override
	public void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("	*Music Bookings*	");
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
				Book();
				break;
			}
		}
	

	}

}
