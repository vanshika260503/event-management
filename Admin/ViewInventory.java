package Admin;

import login.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ViewInventory extends AdminDashboard {
    Scanner  input = new Scanner(System.in);
    public  String tableName;
    int choice1;
        public  void disp() throws SQLException, ClassNotFoundException {
        System.out.println("""
               ***********INVENTORY***********
               please select to view the data
               [1]Caterings
               [2]Music
               [3]Decorations
               [4]Photography's
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
            default:
                Mainmenu();
        }

        }
        private void view(String tableName) throws ClassNotFoundException, SQLException {

                Connection connection = DBConnection.connect();
                String sql = "SELECT * FROM "+ tableName;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int Id  = rs.getInt("Id");
                String Name = rs.getString("Name");
                String City = rs.getString("City");
                String Type = rs.getString("Type");
                String Price = rs.getString("Price");
                String Number = rs.getString("Number");

                //Display values
                System.out.println("ID: " + Id);
                System.out.println("Name: " + Name);
                System.out.println("City: " + City);
                System.out.println("Type: " + Type);
                System.out.println("Price: " + Price);
                System.out.println("MAx number of persons : " + Number);
                System.out.println("");
            }
            disp();
        }
}
