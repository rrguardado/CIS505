/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Account {
    private double balance = 200;

    public double getBalance () {
        return this.balance;
    }

    public void deposit (double amt) {
        this.balance += amt;
    }

    public void withdraw (double amt) {
        if (this.balance >= amt) {
            this.balance -= amt;
        }
    }

    public void displayMenu () {
        System.out.print("\n  Account Menu\n  Enter <D/d> for deposit\n  Enter <W/w> for withdraw\n  Enter <B/b> for balance\n    Enter option>: ");
    }

    public String getTransactionDate () {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        return (dt.format(currentDate));
    } 
}
