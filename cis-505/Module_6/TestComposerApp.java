/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
package ComposerApp;
import java.util.List;
import java.util.Scanner;

public class TestComposerApp {
    public static void main (String[] args) {
        System.out.println("  Welcome to the Composer App");
        Scanner userChoice = new Scanner(System.in);
        MemComposerDao defaultComposers = new MemComposerDao();
    
        while (true) {
            int usersInput = ValidatorIO.getInt(userChoice, "\n  MENU OPTIONS\n    1. View Composers\n    2. Find Composer\n    3. Add Composer\n    4. Exit\n\n  Please choose an option: ");
            userChoice.reset();

            switch (usersInput) {
                case 1:
                    List<Composer> allComposers = MemComposerDao.findAll();
                    if (allComposers.size() == 0) {
                        System.out.println("  No composers in list.");
                    }
                    else {
                        System.out.println("\n\n  --DISPLAYING COMPOSERS--");
                        for (Composer comp : allComposers) {
                            System.out.println(comp.toString() + "\n");
                        }
                    }
                    break;
                    //end case 1
                case 2:
                    System.out.print("  Enter the composer's ID number: ");
                    userChoice.reset();
                    if (userChoice.hasNextInt()) {
                        int composerIdInput = userChoice.nextInt();

                        if (composerIdInput == 0) {
                            System.out.println("  Composer ID " + composerIdInput + " was not found!");
                            break;
                        }

                        Composer composerfromDao = MemComposerDao.findBy(composerIdInput);//will return composer with id of zero if not found (via default constructor) 

                        if (composerfromDao.getId() == 0) {//default Composer constructor is detected
                            System.out.println("  Composer ID " + composerIdInput + " was not found!");
                            break;
                        }

                        System.out.println("\n\n  --DISPLAYING COMPOSER--");
                        System.out.println(composerfromDao.toString());
                    }
                    else {
                        System.out.println("\n  Error! Invalid integer value.\n");
                    }
                    break;
                    //end case 2

                    case 3:
                        int composerIdToSave = 0;
                        System.out.print("\n  Enter an integer ID (not 0): ");
                        userChoice.reset();
                        if (userChoice.hasNextInt()) {
                            composerIdToSave = userChoice.nextInt();
                            if (composerIdToSave == 0) {
                                System.out.println("\n  Error! Invalid integer value.\n");
                                break;
                            }
                        }//end if valid integer was input
                        else {
                            System.out.println("\n  Error! Invalid integer value.\n");
                            break;
                        }

                        System.out.print("  Enter the composer's name: ");
                        userChoice.reset();
                        String composerNameToSave = userChoice.next();
                        
                        System.out.print("  Enter the composer's genre: ");
                        userChoice.reset();
                        String composerGenreToSave = userChoice.next();

                        Composer composerToInsert = new Composer(composerIdToSave, composerNameToSave, composerGenreToSave);

                        MemComposerDao.insert(composerToInsert);
                        System.out.println("\n  Composer was successfully added!");
                        break;
                    //end case 3

                    case 4:
                        System.out.println("\n  Exiting!");
                        break;
                default:
                    System.out.println("\n  Error: Invalid Option '" + usersInput + "'");
                    break;
                //end default case
            }//end switch
            if (usersInput ==  4) {
                break;
            }
        }//end while true 
    }//end main method    
}//end TestComposerApp class
