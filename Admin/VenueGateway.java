package Admin;
import login.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VenueGateway {

    private final int Choice;
    private String Id;
    private String Name;
    private String City;
    private String type;
    private String phoneNumber;
    private String Capacity;
    private String Address;
    private String cost;
    private String New;
    public VenueGateway(int ch) throws SQLException, ClassNotFoundException {
        Choice = ch;
        if (Choice == 1) AddNew();
        if (Choice == 2) delete();
        if (Choice == 3) Alter();
    }

    protected void getDetails(int ch) {
        Scanner input = new Scanner(System.in);

        switch (ch) {
            case 1:
                System.out.print("Enter ID : ");
                Id = input.nextLine();
                System.out.print("Enter Name : ");
                Name = input.nextLine();
                System.out.print("Enter City : ");
                City = input.nextLine();
                System.out.print("Enter type : ");
                type = input.nextLine();
                System.out.print("Enter phoneNumber : ");
                phoneNumber = input.nextLine();
                System.out.print("Enter Address of venue : ");
                Address =input.nextLine();
                System.out.print("Enter Capacity : ");
                Capacity = input.nextLine();
                System.out.print("Enter Price : ");
                cost = input.nextLine();
                break;
            case 2:
                System.out.println("Delete Existing Venue only by Id");
                System.out.println("Enter ID : ");
                Id = input.nextLine();
                break;
            case 3:System.out.println("Altering Existing Venue only by Id\n[ID CAN'T BE ALTERED]");
                System.out.print("Enter ID : ");
                Id = input.nextLine();
                System.out.print("Enter Column to be altered : ");
                Name = input.nextLine();
                System.out.print("Enter new value of "+ Name+" : ");
                New =input.nextLine();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ch);
        }
    }


    protected void AddNew() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        getDetails(Choice);
        String sql = "insert into venue(id,name,city,type,phoneNumber,venue_capacity,venue_address,cost) values (?,?,?,?,?,?,?,?)";
        PreparedStatement myStmt = connection.prepareStatement(sql);
        myStmt.setString(1, Id);
        myStmt.setString(2, Name);
        myStmt.setString(3, City);
        myStmt.setString(4, type);
        myStmt.setString(5, phoneNumber);
        myStmt.setString(6, Capacity);
        myStmt.setString(7, Address);
        myStmt.setString(8, cost);
        myStmt.executeUpdate();
        System.out.println("Successfully registered");
        new UpdateInventory().VENUE();
    }

    protected void delete() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        getDetails(Choice);
        String sql = "DELETE FROM venue WHERE ID= ?";
        PreparedStatement myStmt = connection.prepareStatement(sql);
        myStmt.setInt(1, Integer.parseInt(Id));
        myStmt.executeUpdate();
        System.out.println("Successfully deleted");
         new UpdateInventory().VENUE();
    }
    protected void Alter() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        getDetails(Choice);
        String sql = "update venue set "+Name+"= '"+New+"' where id="+Id;
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        System.out.println("Database updated successfully ");
        new UpdateInventory().VENUE();
    }


}



