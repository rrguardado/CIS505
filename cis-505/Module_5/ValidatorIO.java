/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package ExpenseTrackerApp;
import java.util.Scanner;

public class ValidatorIO {
    
    public static int getInt(Scanner sc, String prompt) {
        int input = 0;
        boolean isValid = false;
        
        while (!isValid) {
            System.out.print(prompt);
            
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isValid = true;
            }
            else {
                System.out.println("\n  Error! Invalid integer value.\n");
            }
            sc.nextLine();
        }//end while
        return input;
    }//end getInt()

    public static double getDouble(Scanner sc, String prompt) {
        double input = 0;
        boolean isValid = false;
        
        while (!isValid) {
            System.out.print(prompt);
                        
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();                
                isValid = true;
            }
            else {
                System.out.println("\n  Error! Invalid double value.\n");
            }
            sc.nextLine();
        }//end while
        return input;
    }//end getDouble()
    
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.next();
    }
    
}//end ValidatorIO class
