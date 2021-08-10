package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import login.DBConnection;

public class UserInput {
	private static  DBConnection db = new DBConnection();
	
	 public static int takeInput() throws Exception {
		  
	      Scanner input2 = new Scanner(System.in);
	  	  Scanner input = new Scanner(System.in);
	  	  System.out.print("Enter date of your event(dd/mm/yy) - ");
	  	  String date = input2.nextLine();
	  	  System.out.print("Enter city of your event - ");
	  	  String place = input2.nextLine();
	  	  System.out.print("Enter number of guests of your event - ");
	  	  int people = input2.nextInt();
	  	  System.out.println("Enter the type of event - ");
	  	  String eventType = input.nextLine();
	  	  int id = register(date,place,people,eventType);
	  	  return id;
	  }
	 
	 public static int register(String date,String place,int people,String eventType) throws Exception {
			Connection conn = DBConnection.connect();
			
			String sql = "insert into user_input(date,place,people,eventType) values (?,?,?,?)";
			
			PreparedStatement myStmt = conn.prepareStatement(sql);
			myStmt.setString(1, date);
			myStmt.setString(2, place);
			myStmt.setInt(3, people);
			myStmt.setString(4, eventType);
	
			
			myStmt.executeUpdate();
			
			ResultSet rs = myStmt.getGeneratedKeys();
			int id = 0;
			while(rs.next()) {
				id = rs.getInt("id");
			}
			return id;
		}
}
