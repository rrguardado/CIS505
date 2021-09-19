package BowlingShopApp;
/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

import java.text.NumberFormat;
import java.util.Locale;

//superclass for ball class, bag class, and shoe class
public class Product {
    private String code = "";
    private String description = "";
    private double price = 0;
    private String formattedPrice = "";

    //default constructor
    public Product () {

    }

    //mutator methods
    public String getCode() {
        return this.code;
    }
    public void setCode(String productCode) {
        this.code = productCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String productDescription) {
        this.description = productDescription;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double productPrice) {
        this.price = productPrice;
    }

    //format price with dollar sign
    private void formatPrice() {
        this.formattedPrice = NumberFormat.getCurrencyInstance(Locale.US).format(this.price);
    }

    //override toString()
    public String toString() {
        formatPrice();
        return "  Product Code: " + this.code + "\n  Description: " + this.description + "\n  Price: " + this.formattedPrice;
    }
}