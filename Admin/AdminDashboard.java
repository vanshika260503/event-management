package Admin;

import java.util.Scanner;

public class AdminDashboard {
    int choice1,choice2;
    Scanner input = new Scanner(System.in);

    private void display() {
        System.out.println("        WELCOME Admin Start your Day");
        System.out.println("""
                Choose an option:
                Enter [1] to To know The  present Bookings
                Enter [2] to Update or view options in Inventory
                Enter [0] to EXIT""");
        choice1 = input.nextInt();
        switch(choice1){
            case 1 : break;
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
          case 1 : break;
          case 2 : break;
      }

    }
}