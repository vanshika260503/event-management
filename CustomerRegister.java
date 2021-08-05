package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class CustomerRegister {
	
	public static void registerPrint() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name : ");
		String name = input.next();
		System.out.print("Enter username : ");
		String uname = input.next();
		System.out.print("Enter password : ");
		String pword = input.next();
		System.out.print("Enter email : ");
		String email = input.next();
		System.out.print("Enter phoneno : ");
		String phoneno = input.next();
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
}
