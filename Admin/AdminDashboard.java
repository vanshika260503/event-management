package Admin;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminDashboard {
    int choice1,choice2;
    Scanner input = new Scanner(System.in);

    public  void Mainmenu() throws ClassNotFoundException, SQLException {
        System.out.println("        WELCOME Admin Start your Day");
        System.out.println("""
                Choose an option:
                Enter [1] to To know Customer bookings
                Enter [2] to Update or view options in Inventory
                Enter [0] to EXIT""");
        choice1 = input.nextInt();
        switch(choice1){
            case 1 : var customer =new CustomerDetails();
                      customer.display();
            break;
            case 2  : System.out.println(""" 
                    Choose an option:
                    Enter [1] To Update options in Inventory
                    Enter [2] to View options in Inventory
                    Enter [0] to EXIT""");
                choice2 = input.nextInt();
             break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice1);
        }
      switch (choice2){
          case 1 :
              var UPDATE = new UpdateInventory();
              UPDATE.disp();
              break;
          case 2 : var VIEW = new ViewInventory();
                VIEW.disp();
          break;
      }

    }
}