package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import main.Welcome;



public class CustomerRegister {

	private static String name;
	private static String phoneno;
	private static String email;
	
	public static void registerPrint() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name : ");
		name = input.next();
		System.out.print("Enter username : ");
		String uname = input.next();
		System.out.print("Enter password : ");
		String pword = input.next();
		System.out.print("Enter email : ");
		email = input.next();
		System.out.print("Enter phoneno : ");
		phoneno = input.next();
		register(name, uname, pword, email, phoneno);
	}
	
	public static void register(String name,String username,String password,String email,String phoneno) throws Exception {
		Connection conn = DBConnection.connect();
		
		String sql = "insert into register(name,username,password,email,phoneno) values (?,?,?,?,?)";
		
		PreparedStatement myStmt = conn.prepareStatement(sql);
		myStmt.setString(1, name);
		myStmt.setString(2, username);
		myStmt.setString(3, password);
		myStmt.setString(4, email);
		myStmt.setString(5, phoneno);
		
		myStmt.executeUpdate();
		System.out.println("Successfully registered");
		
	}
	
//	public static void back() throws Exception {
//		Connection conn = DBConnection.connect();
//		System.out.println("Choose an option :" + 
//				"\nEnter[1] to go back" + 
//				"\nEnter[2] to exit");
//		Scanner sc = new Scanner(System.in);
//		String choice = sc.next();
//		switch(choice) {
//		 case "1" :
//			 Welcome.start();
//			 break;
//		 case "2" :
//			 Welcome.exit(conn);
//		}
//	}
	
	public static String getUsername() {
		return name;
	}
	public static String getEmail() {
		return email;
	}
	
	public static String getPhone() {
		return phoneno;
	}
}
