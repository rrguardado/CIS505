/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/


package BowlingShopApp;

public class Bag extends Product {
    private String type = "";

    //default constructor
    public Bag () {

    }

    //mutator
    public String getType () {
        return this.type;
    }

    public void setType (String bagType) {
        this.type = bagType;
    }

    //override toString()
    public String toString() {
        return super.toString() + "\n" + "  Type: " + this.type;
    }    
}
