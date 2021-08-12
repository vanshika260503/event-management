package customer;

import java.sql.SQLException;

public interface BookingInterface {
	public  void Book() throws Exception;
	public double getPrice() throws ClassNotFoundException, SQLException;
}