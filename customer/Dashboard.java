package customer;

import java.sql.Date;

public class Dashboard {
	private Date date;
	private String place;
	private int people;
	private String event;
	
	public Dashboard(Date date, String place, int people, String event) {
		this.date = date ;
		this.place = place;
		this.people = people;
		this.event = event;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
}
