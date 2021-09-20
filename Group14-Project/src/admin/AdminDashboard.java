package admin;

import java.sql.SQLException;
import java.util.Scanner;

import main.Welcome;

public class AdminDashboard {
    int choice1,choice2;
    Scanner input = new Scanner(System.in);

    public  void Mainmenu() throws Exception {
		System.out.println("------------------------------------");
        System.out.println("        WELCOME Admin               ");
		System.out.println("------------------------------------");
        System.out.println("""
                Choose an option:
                Enter [1] to To know Customer bookings
                Enter [2] to Update or view options in Inventory
                Enter any key to EXIT""");
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
                Welcome w = new Welcome();
                w.start();
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