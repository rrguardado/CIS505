/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

public class CustomerDB {
    public static Customer getCustomer (String id) {
        if (id.equals("1007")) {
            return new Customer("Customer 1007","1007 Main St","Wahoo","68066");
        }
        else if (id.equals("1008")) {
            return new Customer("Customer 1008","1008 Main St","Wahoo","68066");
        }
        else if (id.equals("1009")) {
            return new Customer("Customer 1009","1009 Main St","Wahoo","68066");
        }
        else {
            return new Customer();
        }
    }    
}
