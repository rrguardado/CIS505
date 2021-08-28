/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

public class TestFanApp {
    public static void main(String[] args){

        /**
         * Main method that tests creation of Fan class constructors that are defined in separate file Fan.java
         */
        System.out.println("hello");

        //test default fan scenario
        Fan defaultFan = new Fan();
        System.out.println(defaultFan.toString());
        
        //test specified parameters for fan scenario
        Fan paramFan = new Fan(Fan.MEDIUM, true, 8.0, "Blue");
        System.out.println(paramFan.toString());
    }//end main
}//end TestFanApp
