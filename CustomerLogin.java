package login;

import java.util.Scanner;

public class CustomerLogin {
	
	public static void customerLogin() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.print("Username : ");
		String username = input.next();
		System.out.print("Password : ");
		String password = input.next();
		int i = LoginCheck.loginCheck(username, password,"register");
		if(i==1) {
			System.out.println(true);
		}
		else {
			System.out.println("Invalid username or password");
			customerLogin();
		}
	}
}
