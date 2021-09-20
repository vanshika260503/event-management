package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginCheck {

	public static int loginCheck(String username, String password, String tableName) throws Exception {
		Connection conn = DBConnection.connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM " + tableName);
		
		int flag = 0;
		while(rs.next()) {
			
			String us = rs.getString("username");
			String ps = rs.getString("password");
			if(username.equals(us) && password.equals(ps)) {
				flag = 1;
			}
		}
		return flag;
    }

	
}
