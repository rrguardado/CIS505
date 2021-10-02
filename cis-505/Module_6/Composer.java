/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package ComposerApp;

public class Composer {
    private int id = 0;
    private String name = "";
    private String genre = "";

    //default constructor
    public Composer () {

    }

    //constructor to set composer values
    public Composer (int composerId, String composerName, String composerGenre) {
        this.id = composerId;
        this.name = composerName;
        this.genre = composerGenre;
    }

    //accessor methods
    public int getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }

    public String getGenre () {
        return this.genre;
    }

    //override toString
    public String toString () {
        return "  ID: " + this.id + "\n  Name: " + this.name + "\n  Genre: " + this.genre;        
    }    
}
