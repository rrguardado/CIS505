import java.util.Scanner;

/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

public class TestCustomerAccountApp {
    public static void main(String[] args) {
        String continueChoice = "y";
        Account custAccount = new Account();

        System.out.println("  Welcome to the Customer Account App\n");
        System.out.print("  Enter a customer ID:\n    ex: 1007, 1008, 1009>: ");

        Scanner userIdInput = new Scanner(System.in);
        String custIdInput = userIdInput.nextLine();

        CustomerDB custDb = new CustomerDB();
        Customer customer = custDb.getCustomer(custIdInput);
        
        do {
            custAccount.displayMenu();
            Scanner userActionInput = new Scanner(System.in);
            char userActionChoice = userActionInput.next(".").toLowerCase().charAt(0);
            switch (userActionChoice) {
                case 'd':
                    Scanner userDepositInput = new Scanner(System.in);
                    System.out.print("  Enter deposit amount: ");
                    double depositAmount = userDepositInput.nextDouble();
                    custAccount.deposit(depositAmount);
                    break;
                case 'w':
                    Scanner userWithdrawalInput = new Scanner(System.in);
                    System.out.print("  Enter withdrawal amount: ");
                    double withdrawalAmount = userWithdrawalInput.nextDouble();
                    custAccount.withdraw(withdrawalAmount); 
                    break;
                case 'b': 
                    double custBalance = custAccount.getBalance();
                    System.out.printf("  Account balance: " + "$%,6.2f%n", custBalance);
                    break;
                default: 
                    System.out.println("  Error: Invalid Option '" + userActionChoice + "'");
                    break;
            }
            System.out.print("  Continue? (y/n): ");
            Scanner userContinueInput = new Scanner(System.in);
            continueChoice = userContinueInput.nextLine().toLowerCase();            
        } while (continueChoice.equals("y"));

        if (continueChoice.equals("n") == false) {
            System.out.println("\n  Invalid option '" + continueChoice + "' so assuming no need to continue!\n");
        }

        System.out.println("  --Customer Details--");
        System.out.println(customer.toString());
        double custFinalBalance = custAccount.getBalance(); 
        System.out.print("  Balance as of " + custAccount.getTransactionDate() + " is: ");
        System.out.printf("$%,6.2f%n", custFinalBalance);
    }//end main method
}//end TestCustomerAccountApp class
