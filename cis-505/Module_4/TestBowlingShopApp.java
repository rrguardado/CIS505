/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
package BowlingShopApp;
import java.util.Scanner;


public class TestBowlingShopApp {

    public static void main(String[] args) {
        String continueChoice = "y";
        System.out.println("  Welcome To The Bowling Shop");

        do {
            displayMenu();
            Scanner userMenuChoice = new Scanner(System.in);
            char userActionChoice = userMenuChoice.next(".").toLowerCase().charAt(0);
            continueChoice = Character.toString(userActionChoice);
            
            switch (userActionChoice) {
                case 'b': case 'a': case 's':
                    System.out.println("\n --PRODUCT LISTING--");
                    GenericQueue products = ProductsDB.getProducts(continueChoice);
                    while (products.size() > 0) {
                        products.printFirstProduct();
                        products.dequeue();
                        System.out.println();
                    }
                    break;
                case 'x':
                    break;
                default:
                    System.out.println("\n  Error: Invalid Option '" + userActionChoice + "'");
                    break;
            }//end switch    
        }//end do
        while (continueChoice.equals("x") == false);

        System.out.println("\n\n  End of line...");
    }//end main method


    public static void displayMenu () {
        System.out.print("\n\n  MENU OPTIONS\n    1. <b> Bowling Balls\n    2. <a> Bowling Bags\n    3. <s> Bowling Shoes\n    4. <x> To exit\n  Please choose an option: ");
    }
}
