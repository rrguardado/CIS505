/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

public class Customer {
    private String name;
    private String address;
    private String city;
    private String zip;

    //default constructor
    public Customer () {
        this.address = "1 Nowhere Lane";
        this.city = "Ghosttown";
        this.name = "Ima Nobody";
        this.zip = "00000";
    }

    //complete constructor
    public Customer (String custName, String custAddress, String custCity, String custZip) {
        this.name = custName;
        this.address = custAddress;
        this.city = custCity;
        this.zip = custZip;
    }

    //accessor methods
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getZip() {
        return this.zip;
    }

    //override toString()
    public String toString() {
        return "  Name: " + this.name + "\n  Address: " + this.address + "\n  City: " + this.city + "\n" + "  Zip: " + this.zip + "\n";
    }
}