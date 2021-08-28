/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

public class Fan {
    //class constants
    final static int STOPPED = 0;
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;

    //class data fields
    private int speed = STOPPED;
    private boolean on = false;
    private double radius = 6;
    private String color = "white";

    //accessors and mutators
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }
    public boolean getOn() {
        return on;
    }
    public void setOn(boolean newOn)
    {
        on = newOn;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double newRadius) {
        radius = newRadius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String newColor) {
        color = newColor;
    }

    //Default constructor for fan object
    Fan () {
        setSpeed(STOPPED);
        setOn(false);
        setRadius(6);
        setColor("white");
    }//end default constructor

    //constructor to create fan object using all four fields
    Fan (int fanSpeed, boolean fanOn, double fanRadius, String fanColor)
    {
        this.speed = fanSpeed;
        this.on = fanOn;
        this.radius = fanRadius;
        this.color = fanColor;
    }//end constructor

    //override of ToString()
    public String toString(){
        if (getOn() == true) {
            return "The fan speed is set to " + getSpeed() + " with a color of " + getColor() + " and a radius of " + getRadius();
        }
        else {
            return "The fan is " + getColor() + " with a radius of " + getRadius() + " and the fan is OFF";
        }
    }//end toString override
}//end Fan