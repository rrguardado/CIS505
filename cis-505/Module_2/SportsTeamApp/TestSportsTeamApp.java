/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package SportsTeamApp;
import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args) {
        System.out.println("  Welcome to the Sports Team App");
        while (true)
        {
            Scanner userInput = new Scanner(System.in);

            System.out.print("  Enter a team name: ");            
            String currentTeamName = userInput.nextLine();
            
            if (currentTeamName.equals("")) {//no team name given by user
                currentTeamName = "NoName";
            }

            Team currentTeam = new Team(currentTeamName);
            
            System.out.println("\n  Enter the player first names.");
            System.out.print("  Hint: use commas for multiple players (up to 20); no spaces: ");    
            String currentTeamPlayerNames = userInput.nextLine();

            String[] currentPlayers = new String[20];
            currentPlayers = currentTeamPlayerNames.split(",");           
            int currentPlayersCount = 0;

            if (currentPlayers[0].equals("") == false) {//only take actions if first value in string array contains non empty string
                currentPlayersCount = currentPlayers.length;
                for (int i = 0; i < currentPlayersCount; i++) {
                    currentTeam.addPlayer(currentPlayers[i]);
                }                
            }         
            
            System.out.println("\n  --Team Summary--");
            System.out.println("  Number of players in team " + currentTeam.getTeamName() + ": " + (currentTeam.getPlayerCount()));
            System.out.print("  Players on team: ");

            currentPlayers = currentTeam.getPlayers();

            if (currentPlayersCount == 0) { //no player names given by user
                System.out.print("Nobody.");
            }

            for (int i = 0; i < currentPlayersCount; i++) {
                System.out.print(currentPlayers[i] + " ");
            }

            System.out.println("\n  Continue? (y/n): ");
            char continueChoice = userInput.next(".").charAt(0);
            
            if (Character.toLowerCase(continueChoice) == 'n') {
                System.out.println("  Exiting...");
                userInput.close();    
                break;
            }
        }//end while loop
    }//end main method
}//end TestSportsTeamApp
