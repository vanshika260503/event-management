package customer;

import java.util.Scanner;

public class Input {
	
    public static Dashboard getInput() {
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
	 
	  Dashboard d = new Dashboard(date, place, people, eventType );	
	  return d;
	
  }
	
}

