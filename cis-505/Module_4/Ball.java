/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package BowlingShopApp;

public class Ball extends Product {
    private String color = "";

    //default constructor
    public Ball () {

    }

    //mutator
    public String getColor () {
        return this.color;
    }

    public void setColor (String ballColor) {
        this.color = ballColor;
    }

    //override toString()
    public String toString() {
        return super.toString() + "\n" + "  Color: " + this.color;
    }    
}