/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package ExpenseTrackerApp;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class TestExpenseTracker {
    
    public static void main (String[] args) {
        System.out.println("  Welcome to the Expense Tracker");
        Scanner userChoice = new Scanner(System.in);
        
        while (true) {
            int usersInput = ValidatorIO.getInt(userChoice, "\n  MENU OPTIONS\n    1. View Transactions\n    2. Add Transactions\n    3. View expense\n\n  Please choose an option: ");
            userChoice.reset();

            switch (usersInput) {
                case 1: {
                    try {
                        System.out.println("  MONTHLY EXPENSES\n");
                        ArrayList<Transaction> transactionsFromTextFile = TransactionIO.findAll();

                        for (Transaction tran : transactionsFromTextFile) {
                            System.out.println(tran.toString() + "\n");
                        }                                          
                    }
                    catch (IOException ex){
                        System.out.println("  No transactions in file.");
                    }
                    break;
                }//end case 1
                case 2: {
                    Scanner sc = new Scanner(System.in);

                    String continueChoice = "y";
                    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

                    while (continueChoice.equalsIgnoreCase("y"))
                    {
                        String transactionDate = getTransactionDate();                    
                        String description = ValidatorIO.getString(sc, "\n  Enter the description (commas are not permitted): ");
                        if (description.contains(",")) {
                            System.out.println("  A comma was entered for the description but commas are not permitted.");
                            break;                            
                        }
                        sc.reset();

                        double amount = ValidatorIO.getDouble(sc, "  Enter the amount: ");
                        sc.reset();

                        Transaction transaction = new Transaction(transactionDate, description, amount);
                        transactions.add(transaction);

                        continueChoice = ValidatorIO.getString(sc, "\n  Add another transaction? (y/n): ");                    
                    }

                    try {
                        TransactionIO.bulkInsert(transactions);
                    }
                    catch (IOException e){
                        System.out.println("\n  Exception: " + e.getMessage());
                    }                
                    break;
                }//end case 2
                case 3: {
                    try {
                        ArrayList<Transaction> transactionsFromTextFile = TransactionIO.findAll();
                        double runningTotal = 0;

                        for (Transaction tran : transactionsFromTextFile) {
                            runningTotal += tran.getAmount();
                        }
                        System.out.println("\n  Your total monthly expense is: " + NumberFormat.getCurrencyInstance(Locale.US).format(runningTotal) + "\n");
                        break;
                        
                    }
                    catch (IOException ex){
                        System.out.println("  No transactions in file.");
                        break;
                    }
                }//end case 3
                default:
                    System.out.println("\n  Error: Invalid Option '" + usersInput + "'");
                    break;            
            }//end switch            
            
            String stayInProgramInput = ValidatorIO.getString(userChoice, "  Continue? (y/n): ");
            if (stayInProgramInput.equalsIgnoreCase("n")) {
                System.out.println("\n Program terminated by the user...");
                break;
            }
        }//end while true      
    }//end main method    
    
    public static String getTransactionDate () {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        return (dt.format(currentDate));
    }//end getTransactionDate         
}
