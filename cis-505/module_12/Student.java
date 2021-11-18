/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
package GradeBookApp;

public class Student {
    private String firstName = "";
    private String lastName = "";
    private String courseName = "";
    private String courseGrade = "";

    //default constructor
    public Student () {

    }

    //constructor to set composer values
    public Student (String stuFirstName, String stuLastName, String courseTitle, String grade) {
        this.firstName = stuFirstName;
        this.lastName = stuLastName;
        this.courseName = courseTitle;
        this.courseGrade = grade;
    }

    //accessor methods
    public String getFirstName () {
        return this.firstName;
    }

    public String getLastName () {
        return this.lastName;
    }

    public String getCourseName () {
        return this.courseName;
    }
    
    public String getCourseGrade () {
        return this.courseGrade;
    }
    
    public void setFirstName (String fn) {
        this.firstName = fn;
    }
    
    public void setLastName (String ln) {
        this.lastName = ln;
    } 

    public void setCourseName (String cn) {
        this.courseName = cn;
    } 

    public void setCourseGrade (String cg) {
        this.courseGrade = cg;
    }     
        
    //override toString
    public String toString () {
        return this.firstName + "," + this.lastName + "," + this.courseName + "," + this.courseGrade + "\n";        
    }        
}
