package admin;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateInventory extends AdminDashboard {

    int choice1,choice2;
    Scanner input = new Scanner(System.in);



    public  void disp()  {

       System.out.println("""
               ***********INVENTORY***********
               please select
               [1]Venues
               [2]Caterings
               [3]Music
               [4]Decorations
               [5]Photography's
               Any other number to Go back""");
       choice1 = input.nextInt();
       switch (choice1) {
            case 1 -> {
                try {
                    VENUE();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case 2 -> CATERING();
            case 3 -> MUSIC();
            case 4 -> DECORATION();
            case 5 -> PHOTOGRAPHY();
            default -> {
                try {
                    Mainmenu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
       }
    }
    public void VENUE() throws SQLException, ClassNotFoundException {
        System.out.println("""
                *************Update Venues*******
                [1]Add New Venue
                [2]Delete a existing one
                [3]Alter Existing Data
                Any other number to Go back""");
        choice2 = input.nextInt();
        if((choice2 < 4) && (choice2 > 0)) new VenueGateway(choice2);
         disp();
    }
    public void CATERING()  {
        System.out.println("""
                *************Update CATERING*******
                [1]Add New Catering Service
                [2]Delete a existing Service
                [3]Alter Existing Service
                Any other number to Go back""");
        choice2 = input.nextInt();
        if((choice2<4) && choice2>0) new Gateway(choice2, "catering");
        disp();
    }
    public void MUSIC()  {
        System.out.println("*************Update MUSIC SYSTEM*******" +
                "\n[1]Add New MUSIC Service" +
                "\n[2]Delete a existing Service" +
                "\n[3]Alter Existing Service" +
                "\nAny other number to Go back");
        choice2 = input.nextInt();
        if(choice2<4 && choice2>0){
            new Gateway(choice2,"music");
        }
        disp();
    }
    public void DECORATION()  {
        System.out.println("""
                *************Update DECORATIONS*******
                [1]Add New DECORATION Service
                [2]Delete a existing Service
                [3]Alter Existing Service
                Any other number to Go back""");
        choice2 = input.nextInt();
        if(choice2<4 && choice2>0){
            new Gateway(choice2,"decorator");
        }
       disp();
    }
    public void PHOTOGRAPHY()  {
        System.out.println("""
                *************Update PHOTOGRAPHY*******
                [1]Add New PHOTOGRAPHY Service
                [2]Delete a existing Service
                [3]Alter Existing Service
                Any other number to Go back""");
        choice2 = input.nextInt();
        if(choice2<4 && choice2>0){
            new Gateway(choice2,"photographer");
        }
        disp();
    }
    }