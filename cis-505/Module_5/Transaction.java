/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package ExpenseTrackerApp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.NumberFormat;
import java.util.Locale;


public class Transaction {
    
    private String date = getTransactionDate();
    private String description = "";
    private double amount = 0;
    
    //accessors and mutators
    public String getDate () {
        return this.date;
    }
    
    public void setDate () {
        this.date = getTransactionDate();
    }
    
    public String getDescription () {
        return this.description;
    }
    
    public void setDescription (String expenseDescription) {
        this.description = expenseDescription;
    }
    
    public double getAmount () {
        return this.amount;
    }
    
    public void setAmount (double expenseAmount) {
        this.amount = expenseAmount;
    }        
    //end accessors and mutators
    
    //default constructor
    public Transaction () {
        
    }
    
    //main constructor
    public Transaction (String expenseDate, String expenseDescription, double expenseAmount) {
        this.date = expenseDate;
        this.description = expenseDescription;
        this.amount = expenseAmount;
    }
    
    //override toString
    public String toString () {
        return "  Date: " + this.date + "\n  Description: " + this.description + "\n  Amount: " + NumberFormat.getCurrencyInstance(Locale.US).format(this.amount);        
    }
    
    public static String getTransactionDate () {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        return (dt.format(currentDate));
    }//end getTransactionDate                         
}//end Transaction class
