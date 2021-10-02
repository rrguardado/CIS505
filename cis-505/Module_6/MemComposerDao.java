/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package ComposerApp;
import java.util.ArrayList;
import java.util.List;

public class MemComposerDao {
    private static List<Composer> composers = new ArrayList<Composer>();
    
    //default constructor
    public MemComposerDao () {
        composers.add(new Composer(1007, "Beethoven", "Classical"));
        composers.add(new Composer(1008, "Bach", "Classical"));
        composers.add(new Composer(1009, "Mozart", "Classical"));
        composers.add(new Composer(1010, "Brahms", "Classical"));
        composers.add(new Composer(1011, "Haydn", "Classical"));
    }

    //pverride findAll
    public static List<Composer> findAll() {
        return composers;
    }

    //override findBy
    public static Composer findBy(int idSearched) {
        for (Composer comp : composers) {
            if (comp.getId() == idSearched) {
                Composer foundComp = comp;
                return foundComp;
            }//end if
        }//end for all composers
        return new Composer();//else no composer found
    }//end findby override

    public static void insert(Composer composerToInsert) {
        composers.add(composerToInsert);
    }    
}//end MemComposerDao class
