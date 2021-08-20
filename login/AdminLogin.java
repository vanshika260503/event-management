package login;

import java.util.Scanner;

import admin.AdminDashboard;

public class AdminLogin {

	public static void adminLogin() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Username : ");
		String username = input.next();
		System.out.print("Password : ");
		String password = input.next();
		int i = LoginCheck.loginCheck(username, password,"adminlogin");
		if(i==1) {
			AdminDashboard a = new AdminDashboard();
			a.Mainmenu();
		}
		else {
			System.out.println("Invalid username or password");
			adminLogin();
		}
	}
}
