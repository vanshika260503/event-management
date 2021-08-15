package Admin;

import login.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Gateway extends UpdateInventory{
    private String Id;
    private String Name;
    private String City;
    private String Type;
    private String Price;
    private String Number;
    private String table;
    public final int Choice;
    Scanner input = new Scanner(System.in);

    public Gateway(int ch,String table)  {
        Choice =ch;
        if(ch==1){
           this.table= table;
            try {
                AddNew();
                System.out.println("You Have been processed Back to Main menu");
                disp();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
       if(ch==2){
           this.table=table;
           try {
               delete();
               System.out.println("You Have been processed Back to Main menu");
               disp();
           } catch (ClassNotFoundException | SQLException e) {
               e.printStackTrace();
           }
       }
    }

    protected String queries(int ch){
      return "";
    }
    private void getDetails(int ch){
        switch(ch){
            case 1 :System.out.print("Enter ID : ");
                Id = input.nextLine();
                System.out.print("Enter Name : ");
                Name = input.nextLine();
                System.out.print("Enter City : ");
                City = input.nextLine();
                System.out.print("Enter Type : ");
                Type = input.nextLine();
                System.out.print("Enter Price : ");
                Price = input.nextLine();
                System.out.print("Enter Number of persons : ");
                Number = input.nextLine();
                break;
            case 2 : System.out.println("Delete Existing "+table+"entries only by Id");
                System.out.println("Enter ID : ");
                Id = input.nextLine();
                break;

        }
    }




    protected void AddNew() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        getDetails(Choice);
        String sql = "insert into " + table + " (ID,Name,City,Type,Price,Number) values (?,?,?,?,?,?)";
        PreparedStatement myStmt = connection.prepareStatement(sql);
        myStmt.setString(1, Id);
        myStmt.setString(2, Name);
        myStmt.setString(3, City);
        myStmt.setString(4, Type);
        myStmt.setString(5, Price);
        myStmt.setString(6, Number);
        myStmt.executeUpdate();
        System.out.println("Successfully registered");
    }
    protected void delete() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        getDetails(Choice);
        String sql = "DELETE FROM "+table+" WHERE ID= ?";
        PreparedStatement myStmt = connection.prepareStatement(sql);
        myStmt.setInt(1, Integer.parseInt(Id));
        myStmt.executeUpdate();
        System.out.println("Successfully deleted");
    }
    protected void Alter() throws ClassNotFoundException {
        Connection connection = DBConnection.connect();
    }


}
