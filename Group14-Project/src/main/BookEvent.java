package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import customer.Booking;
import customer.Catering;
import customer.Dashboard;
import customer.Decoration;
import customer.Music;
import customer.Photography;
import customer.Venue;

public class BookEvent {
	private static Connection d;
    static Scanner sc= new Scanner(System.in);
	public static String venueType;
	public static String foodType;
	public static String musicType;
	public static String decorType;
	public static String photoType;
	
	public static void book() throws Exception{
		Dashboard d=  customer.Input.getInput();

		Venue v1= new Venue();
		System.out.print("\nEnter the venue type(5 star,3 star,moderate)- ");
	    venueType=sc.nextLine();
		v1.getOption(venueType, "venue");
		v1.ask();
		v1.getPrice();
	
		Catering c1= new Catering();
		System.out.print("\nEnter the food type(veg/non veg)- ");
	    foodType=sc.nextLine();
		c1.getOption(foodType, "catering");
		c1.ask();
		c1.getPrice();
		
		Decoration d1= new Decoration();
	    System.out.print("\nDecoration type(Royal, Budget-friendly, theme based)- ");
	    decorType = sc.nextLine();
	    d1.getOption(decorType, "decorator");
	    d1.ask();
	    d1.getPrice();
		
	    Music m1= new Music();
	    System.out.print("\nMusic type(music , equipments)- ");
	    musicType = sc.nextLine();
	    m1.getOption(musicType, "music");
	    m1.ask();
	    m1.getPrice();
	   
	    Photography p1= new Photography();
	    System.out.print("\nPhotographer type(delux,med,basic) :");
		 photoType = sc.nextLine();
		 p1.getOption(photoType, "photographer");
		 p1.ask();
		 p1.getPrice();
		
	    Booking.store();
	    Booking.BookingDetails();
	    Booking.price();
	}
	
	
		
}
