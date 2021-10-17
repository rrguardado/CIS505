/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package GuardadoEnhancedFutureValueApp;

public class FinanceCalculator {
    private static int MONTHS_IN_YEAR = 12;
    
    static double calculateFutureValue (double monthlyPayment, double rate, int years) {        
        //formulas provided in 8.2 assignment description appear to be incorrect!
        //new formula assumes that interest compounds monthly
        //used formula A = P * (1 + ((R/n)^(n*t))) - P = principal;  R = annual rate;n = compounding frequency; t = time in years
        int numberOfMonths = years * MONTHS_IN_YEAR;
        double ratePerYear = rate / 100;
        double presentValue = monthlyPayment * numberOfMonths;
        double ratePerMonth = (1 + (ratePerYear / 12));
        double futureValue = presentValue * Math.pow(ratePerMonth, numberOfMonths);
        return futureValue;        
    }//end calculateFutureValue    
}//end FinanceCalculator class
