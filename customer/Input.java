package customer;


import java.text.ParseException;

import java.util.Scanner;

public class Input {
	public static String place;
    public static Dashboard getInput() throws ParseException {
	  Scanner input2 = new Scanner(System.in);
	  
      System.out.print("\nEnter date of your event(dd/mm/yy) - ");
      String date1 = input2.nextLine();

      System.out.print("Enter city of your event - ");
	  place = input2.nextLine();
	  
	  System.out.print("Enter number of guests of your event - ");
	  int people = input2.nextInt();

	 
	  Dashboard d = new Dashboard(date1, place, people );	
	  return d;
	
  }
	
}