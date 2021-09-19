/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package BowlingShopApp;

public class Shoe extends Product {
    private double size = 0;

    //default constructor
    public Shoe () {

    }

    //mutator
    public double getSize () {
        return this.size;
    }

    public void setSize (double shoeSize) {
        this.size = shoeSize;
    }

    //override toString()
    public String toString() {
        return super.toString() + "\n" + "  Size: " + this.size;
    }    
}
