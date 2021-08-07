package main;

import java.sql.Connection;
import java.util.Scanner;

import customer.*;


public class Main {
    public static Connection d;
    static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

//		Venue v1= new Venue();
//
//		System.out.print("Enter the venue type");
//	    String venueType=sc.next();
//		v1.getOption(venueType, "venue");
//		v1.ask();
		
		Catering c1= new Catering();
		System.out.print("Enter the food type(veg/non-veg)");
	    String foodType=sc.next();
		c1.getOption(foodType, "catering");
		c1.ask();
	}

}
