package customer;

import java.sql.Date;
import java.util.Scanner;

public class input {
	private static String date;
	private static String place;
	private static int people;
	private static String eventType;
    public static void input() {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter date of your event(dd/mm/yy) - ");
	  date = input.nextLine();
	  System.out.print("Enter city of your event - ");
	  place = input.nextLine();
	  System.out.print("Enter number of guests of your event - ");
	  people = input.nextInt();
	  System.out.println("Enter the type of event - ");
	  eventType = input.nextLine();
	 
	  Dashboard d = new Dashboard(date, place, people, eventType );	
	  
  }
    
}
