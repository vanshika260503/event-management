package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;

public class Photography extends Details implements Booking {

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
		getDetails(id,"photographer");
	}

	@Override
	public void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("	*Photographer Bookings*	");
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

}}
