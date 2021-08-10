package customer;


public class Dashboard {
	private String date;
	private static String place;
	private int people;
	
	
	public Dashboard(String date, String place, int people) {
		this.date = date ;
		this.place = place;
		this.people = people;
		
	}

	public Dashboard() {
		// TODO Auto-generated constructor stub
	}

	public String getDate() {
		return date;
	}

	
	public static String getPlace() {
		return place;
	}

	
	public int getPeople() {
		return people;
	}

	
}
