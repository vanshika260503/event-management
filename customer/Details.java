package customer;
import login.*;
import static main.Main.d;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Details extends Dashboard {
	
	public Details(String date, String place, int people, String event) {
		super(date, place, people, event);
	}
	
	public  abstract  void ask() throws ClassNotFoundException, SQLException ;
	
	public  void getOption(String type, String tableName) throws ClassNotFoundException, SQLException {
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
	
	public  void getDetails(int id,String tableName) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
		while(rs.next()) {
			int ID = rs.getInt("id");
			String city = rs.getString("city");
			String showname = rs.getString("name");
			String type = rs.getString("type");
			String number = rs.getString("phone");
			if(ID == id) {
				System.out.println("Name : " + showname +
						"\ntype : " + type +
						"\nCity : " + city +
						"\nPhone Number : " + number );
				break;
			}
		}
	}
}