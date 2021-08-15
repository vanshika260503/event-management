package Admin;
import login.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class VenueGateway {

    private final int Choice;
    private String Id;
    private String Name;
    private String City;
    private String Address;
    private String Phoneno;
    private String Capacity;
    private String Price;
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
                System.out.print("Enter Address : ");
                Address = input.nextLine();
                System.out.print("Enter Phoneno : ");
                Phoneno = input.nextLine();
                System.out.print("Enter Capacity : ");
                Capacity = input.nextLine();
                System.out.print("Enter Price : ");
                Price = input.nextLine();
                break;
            case 2:
                System.out.print("Delete Existing Venue only by Id");
                System.out.println("Enter ID : ");
                Id = input.nextLine();
                break;
            case 3:System.out.println("Altering Existing Venue only by Id\n[ID CAN'T BE ALTERED]");
                System.out.print("Enter ID : ");
                Id = input.nextLine();
                System.out.print("Enter Column to be altered : ");
                Name = input.nextLine();
                System.out.print("Enter new value of"+ Name+" : ");
                String New =input.nextLine();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ch);
        }
    }


    protected void AddNew() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        getDetails(Choice);
        String sql = "insert into venue(Id,Name,City,Address,Phoneno,Capacity,Price) values (?,?,?,?,?,?,?)";
        PreparedStatement myStmt = connection.prepareStatement(sql);
        myStmt.setString(1, Id);
        myStmt.setString(2, Name);
        myStmt.setString(3, City);
        myStmt.setString(4, Address);
        myStmt.setString(5, Phoneno);
        myStmt.setString(6, Capacity);
        myStmt.setString(7, Capacity);
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
        String sql = "UPDATE venue set city = ? where Id = ?";
        PreparedStatement myStmt = connection.prepareStatement(sql);
//        myStmt.setString(1, Name);
        myStmt.setString(1, New);
        myStmt.setInt(2, Integer.parseInt(Id));
        myStmt.executeUpdate();
        System.out.println("Successfully Altered");
        new UpdateInventory().VENUE();
    }









}



