package customer;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class Details extends Dashboard {
	
    public abstract int getID();
    
	public  abstract  void ask() throws Exception ;
	
	public abstract void getOption(String type, String tableName) throws ClassNotFoundException, SQLException;
	
	public abstract void getDetails(int id,String tableName) throws ClassNotFoundException, SQLException;
	
	public void exit(Connection conn) throws SQLException {
		System.out.println("End of program");
	    conn.close();
	    System.exit(0);
	}
	
}