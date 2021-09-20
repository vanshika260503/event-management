package admin;

import login.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Gateway extends UpdateInventory{
    private String id;
    private String name;
    private String city;
    private String type;
    private String phoneNumber;
    private String cost;
    private String table;
    private String New;
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
       if(ch==3){
           this.table=table;
           try {
               Alter();
               System.out.println("You Have been processed Back to Main menu");
               disp();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }


    private void getDetails(int ch){
        switch(ch){
            case 1 :System.out.print("Enter ID : ");
                id = input.nextLine();
                System.out.print("Enter Name : ");
                name = input.nextLine();
                System.out.print("Enter City : ");
                city = input.nextLine();
                System.out.print("Enter Type : ");
                type = input.nextLine();
                System.out.print("Enter phoneNumber : ");
                phoneNumber = input.nextLine();
                System.out.print("Enter cost: ");
                cost = input.nextLine();
                break;
            case 2 : System.out.println("Delete Existing "+table+"entries only by Id");
                System.out.println("Enter ID : ");
                id = input.nextLine();
                break;
            case 3:System.out.println("Altering Existing Venue only by Id\n[ID CAN'T BE ALTERED]");
                System.out.print("Enter ID : ");
                id = input.nextLine();
                System.out.print("Enter Column to be altered : ");
                name = input.nextLine();
                System.out.print("Enter new value of "+ name+" : ");
                New =input.nextLine();
                break;
        }
    }




    protected void AddNew() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        getDetails(Choice);
        String sql = "insert into " + table + " (id,name,city,type,phone,cost) values (?,?,?,?,?,?)";
        PreparedStatement myStmt = connection.prepareStatement(sql);
        myStmt.setString(1, id);
        myStmt.setString(2, name);
        myStmt.setString(3, city);
        myStmt.setString(4, type);
        myStmt.setString(5, phoneNumber);
        myStmt.setString(6, cost);
        myStmt.executeUpdate();
        System.out.println("Successfully registered");
    }
    protected void delete() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        getDetails(Choice);
        String sql = "DELETE FROM "+table+" WHERE id= ?";
        PreparedStatement myStmt = connection.prepareStatement(sql);
        myStmt.setInt(1, Integer.parseInt(id));
        myStmt.executeUpdate();
        System.out.println("Successfully deleted");
    }
    protected void Alter() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.connect();
        getDetails(Choice);
        String sql = "update "+table+" set "+name+"= '"+New+"' where id="+id;
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        System.out.println("Database updated successfully ");

    }


}