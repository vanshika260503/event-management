package customer;

import java.sql.SQLException;


public abstract class Details extends Dashboard {
	
	public Details(String date, String place, int people, String event) {
		super(date, place, people, event);
	}
	
	public  abstract  void ask() throws ClassNotFoundException, SQLException ;
	
	public abstract void getOption(String type, String tableName) throws ClassNotFoundException, SQLException;
	
	public abstract void getDetails(int id,String tableName) throws ClassNotFoundException, SQLException;
	
}
