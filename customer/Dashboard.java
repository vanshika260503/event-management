package customer;

import java.util.Date;

public class Dashboard {
	private static String date;
	private static String place;
	private static int people;
	
	
	public Dashboard(String date1, String place, int people) {
		this.date = date1 ;
		this.place = place;
		this.people = people;
		
	}

	public Dashboard() {
		// TODO Auto-generated constructor stub
	}

	public static String getDate() {
		return date;
	}

	
	public static String getPlace() {
		return place;
	}

	
	public static int getPeople() {
		return people;
	}

	
}