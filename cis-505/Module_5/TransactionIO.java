/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package ExpenseTrackerApp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);
    
    public static void bulkInsert (ArrayList<Transaction> transactions) throws IOException {       
        PrintWriter output = null;
        if (file.exists()){
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        }
        else {
            output = new PrintWriter(FILE_NAME);
        }
        
        for (Transaction tran : transactions) {
            output.print(tran.getDate() + ",");
            output.print(tran.getDescription() + ",");
            output.print(tran.getAmount() + "\n");
        }        
        output.close();
    }//end bulkInsert    
    
    public static ArrayList<Transaction> findAll() throws IOException {
        Scanner input = new Scanner(file);
        ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
        
        while (input.hasNext()) {
            String[] splitTransaction = input.nextLine().split(",");

            String transactionDate = splitTransaction[0];
            String transactionDescription = splitTransaction[1];
            double transactionAmount = Double.parseDouble(splitTransaction[2]);
            
            Transaction transactionToAdd = new Transaction(transactionDate, transactionDescription, transactionAmount);
            transactionList.add(transactionToAdd);
        }//end while reading input from file
        
        return transactionList;
    
    }//end findAll
}//end TransactionIO class
