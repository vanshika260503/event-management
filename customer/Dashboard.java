package customer;
import java.sql.Date;

public class Dashboard {
	private String date;
	private String place;
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

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

}
