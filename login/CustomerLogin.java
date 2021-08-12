package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerLogin {
	
	static private String username;
	static private String phoneno;
	
	public static void customerLogin() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Username : ");
		username = input.next();
		System.out.print("Password : ");
		String password = input.next();
		int i = LoginCheck.loginCheck(username, password,"register");
		if(i==1) {
			System.out.println("Log in succesfully");
		}
		else {
			System.out.println("Invalid username or password");
			customerLogin();
		}
	
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static String getPhone() throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.connect();
 	   Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT phoneno,username FROM register");
		
		while(rs.next()) {
			
			String us = rs.getString("username");
			String phone = rs.getString("phoneno");
			if(username.equals(us) ) {
				phoneno = phone;
			}
		}
		return phoneno;
	}
}
