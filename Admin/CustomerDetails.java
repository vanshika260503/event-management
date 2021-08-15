package Admin;

import login.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerDetails extends AdminDashboard {
    int choice1;
    Scanner input = new Scanner(System.in);

    public void display() throws SQLException, ClassNotFoundException {
         System.out.println("""
                Choose an option:
                Enter [1] to view Bookings
                Enter [2] to view payment status
                Enter [3] to view Customer credentails
                Enter [0] to EXIT""");
         choice1 = input.nextInt();
         switch (choice1){
             case 1 : Bookings();
             break;
             case 2 : payementDetails();
             break;
             case 3 : credentials();
             break;
             default: Mainmenu();
         }
    }

    private void credentials() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        String sql = "SELECT * FROM register";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String Name = rs.getString("name");
            String UN = rs.getString("username");
            String PW = rs.getString("password");
            String Em = rs.getString("email");
            String Num = rs.getString("phoneno");

            System.out.println("Name: " + Name);
            System.out.println("City: " + UN);
            System.out.println("Type: " + PW);
            System.out.println("Price: " + Em);
            System.out.println("Phone number : " + Num);
            System.out.println("");
        }
      display();
    }
    private   void payementDetails(){

    }
   private void  Bookings() throws ClassNotFoundException, SQLException {
       Connection connection = DBConnection.connect();
       String sql = "SELECT * FROM booking";
       Statement stmt = connection.createStatement();
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
           int Id  = rs.getInt("BookingID");
           int date  = rs.getInt("date");
           String UN = rs.getString("username");
           String Num = rs.getString("phone");
           String City = rs.getString("city");
           int people  = rs.getInt("people");
           String venue = rs.getString("venue");
           String catering = rs.getString("catering");
           String decoration = rs.getString("catering");
           String music = rs.getString("music");
           String photography = rs.getString("photography");
           String Price = rs.getString("price");

           System.out.println("bookingID: " + Id);
           System.out.println("Date of event : "+date);
           System.out.println("username : "+UN);
           System.out.println("phone number : "+Num);
           System.out.println(" City Booked : "+City);
           System.out.println("Number of people : "+people);
           System.out.println("Venue Booked : "+venue);
           System.out.println("catering booked : "+catering);
           System.out.println("decoration booked : "+decoration);
           System.out.println(" Music booked : "+music);
           System.out.println("photography booked : "+photography);
           System.out.println("Price: " + Price);
           System.out.println("");
       }
     display();
    }
}
