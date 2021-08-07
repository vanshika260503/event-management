package Admin;

import login.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateInventory {
    Connection conn = DBConnection.connect();
    int choice1,choice2;
    Scanner input = new Scanner(System.in);

    public UpdateInventory() throws ClassNotFoundException {
    }

    public  void disp(){

       System.out.println("***********INVENTORY***********" +
         "\nplease select\n" +
         "[1]Venues" +
         "\n[2]Caterings" +
         "\n[3]Music" +
         "\n[4]Decorations" +
         "\n[5]Photographys");
        choice1 = input.nextInt();

    }
  public void VENUE(){
       System.out.println("[1]Add New Venue"+
                          "\n[2]Delete a existing one" );
      choice2 = input.nextInt();
      if(choice2==1){
           String sql = "insert into venue(Id,Name,City,Adress,Phoneno,Capacity) values (?,?,?,?,?)";
       }



       String sql = "insert into register(name,username,password,email,phoneno) values (?,?,?,?,?)";

//      PreparedStatement myStmt = conn.prepareStatement(sql);
//      myStmt.setString(1, name);
//      myStmt.setString(2, username);
//      myStmt.setString(3, password);
//      myStmt.setString(4, email);
//      myStmt.setString(5, phoneno);

      myStmt.executeUpdate();
      System.out.println("Successfully registered");

    }

}
