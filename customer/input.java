package customer;

import java.util.Scanner;

public class input {
	public static String place;
    public static Dashboard getInput() {
	  Scanner input2 = new Scanner(System.in);
	 // Scanner input = new Scanner(System.in);
	  System.out.print("Enter date of your event(dd/mm/yy) - ");
	  String date = input2.nextLine();
	  System.out.print("Enter city of your event - ");
	  place = input2.nextLine();
	  System.out.print("Enter number of guests of your event - ");
	  int people = input2.nextInt();
//	  System.out.print("Enter the type of event - ");
//	  String eventType = input.nextLine();
	 
	  Dashboard d = new Dashboard(date, place, people );	
	  return d;
	
  }
	
}
