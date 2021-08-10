package main;

import java.sql.Connection;
import java.util.Scanner;

import customer.*;


public class Main {
    public static Connection d;
    static Scanner sc= new Scanner(System.in);
	public static String venueType;
//	public static String foodType;
	public static String musicType;
	public static String photoType;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Dashboard d=  customer.Input.getInput();
		Venue v1= new Venue();

	System.out.print("Enter the venue type(5 star,3 star,moderate)- ");
	    venueType=sc.nextLine();
		v1.getOption(venueType, "venue");
		v1.ask();
		
		Catering c1= new Catering();
		System.out.print("Enter the food type(veg/non veg)- ");
	    String foodType=sc.nextLine();
		c1.getOption(foodType, "catering");
		c1.ask();
		
		Decoration d1= new Decoration();
	    System.out.print("Decoration type(Royal, Budget-friendly, theme based)- ");
	    String decorType = sc.nextLine();
	    d1.getOption(decorType, "decorator");
	    d1.ask();
	    
	   Music m1= new Music();
	    System.out.print("Music type(music , equipments)- ");
	    musicType = sc.nextLine();
	    m1.getOption(musicType, "music");
	    m1.ask();
	    
		Photography p1= new Photography();
	    System.out.print("Enter Type of photographer (delux,med,basic) :");
		 photoType = sc.nextLine();
		 p1.getOption(photoType, "photographer");
		 p1.ask();
	}
	}