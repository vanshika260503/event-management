package customer;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

public class Input {
	public static String place;
    public static Dashboard getInput() throws ParseException {
	  Scanner input2 = new Scanner(System.in);
	 // Scanner input = new Scanner(System.in);
	  
	  
//	  Date date1=null;
//      Scanner input = new Scanner(System.in);
//      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      System.out.print("\nEnter date of your event(dd/mm/yy) - ");
      String date1 = input2.nextLine();
//      String cinput = input.nextLine();
//      if(null != cinput && cinput.trim().length() > 0){
//           date1 =  format.parse(cinput);
//      }
//      
//      System.out.print(date1);

	  System.out.print("Enter city of your event - ");
	  place = input2.nextLine();
	  System.out.print("Enter number of guests of your event - ");
	  int people = input2.nextInt();
//	  System.out.print("Enter the type of event - ");
//	  String eventType = input.nextLine();
	 
	  Dashboard d = new Dashboard(date1, place, people );	
	  return d;
	
  }
	
}