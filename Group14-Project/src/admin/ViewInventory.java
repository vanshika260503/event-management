package admin;

import login.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ViewInventory extends AdminDashboard {
    Scanner  input = new Scanner(System.in);
    public  String tableName;
    Connection connection;

    {
        try {
            connection = DBConnection.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    int choice1;
        public  void disp() throws Exception {
        System.out.println("""
               ***********INVENTORY***********
               please select to view the data
               [1]Caterings
               [2]Music
               [3]Decorations
               [4]Photography's
               [5]Venues
               [Any other key to go back]""");
            choice1 = input.nextInt();
        switch (choice1){
            case 1 : tableName="catering";
                view(tableName);
            break ;
            case 2 : tableName="music";
                view(tableName);
            break;
            case 3 : tableName ="decoration";
                view(tableName);
                break;
            case 4 : tableName= "photography";
                view(tableName);
            break;
            case 5: tableName ="venue";
               view2(tableName);
             default:
                Mainmenu();
        }

        }

    private void view2(String tableName) throws Exception {
        String sql = "SELECT * FROM "+ tableName;
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int Id  = rs.getInt("id");
            String Name = rs.getString("name");
            String City = rs.getString("city");
            String Type = rs.getString("type");
            String phoneNumber = rs.getString("phone");
            int Capacity = rs.getInt("venue_capacity");
            String Address = rs.getString("venue_address");
            int cost = rs.getInt("cost");

            //Display values
            System.out.println("ID: " + Id);
            System.out.println("Name: " + Name);
            System.out.println("City: " + City);
            System.out.println("Type: " + Type);
            System.out.println("phoneNumber: " + phoneNumber);
            System.out.println("Max Capacity of venue: " + Capacity);
            System.out.println("Address of venue : " + Address);
            System.out.println("Price : " + cost);
            System.out.println("");
        }
       disp();
    }

    private void view(String tableName) throws Exception {


                String sql = "SELECT * FROM "+ tableName;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int Id  = rs.getInt("id");
                String Name = rs.getString("name");
                String City = rs.getString("city");
                String Type = rs.getString("type");
                String phoneNumber = rs.getString("phone");
                int cost = rs.getInt("cost");

                //Display values
                System.out.println("ID: " + Id);
                System.out.println("Name: " + Name);
                System.out.println("City: " + City);
                System.out.println("Type: " + Type);
                System.out.println("phoneNumber: " + phoneNumber);
                System.out.println("Cost of "+tableName+" : " + cost);
                System.out.println("");
            }
            disp();
        }
}