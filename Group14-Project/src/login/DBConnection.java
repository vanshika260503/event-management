package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection connect;
	private static final String MySQL_USERNAME = ""; //Enter your mysql username here!!
    private static final String MySQL_PASSWORD = ""; //Enter your mysql password here!!
    private static final String MySQL_CONN = "jdbc:mysql://localhost:3306/event_managment";
    
    public static Connection connect() throws ClassNotFoundException  {
    	try{
    	Class.forName("com.mysql.jdbc.Driver");	
		connect = DriverManager.getConnection(MySQL_CONN, MySQL_USERNAME , MySQL_PASSWORD);
		
		}
    	catch(SQLException e) {
			e.printStackTrace();
		}
    	return connect;
  }
}