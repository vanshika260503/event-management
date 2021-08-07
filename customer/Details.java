package customer;

import java.sql.SQLException;


public abstract class Details extends Dashboard {
	
	public Details(String date, String place, int people) {
		super(date, place, people);
	}
	
	public Details() {
		// TODO Auto-generated constructor stub
	}

	public  abstract  void ask() throws ClassNotFoundException, SQLException ;
	
	public abstract void getOption(String type, String tableName) throws ClassNotFoundException, SQLException;
	
	public abstract void getDetails(int id,String tableName) throws ClassNotFoundException, SQLException;
	
}