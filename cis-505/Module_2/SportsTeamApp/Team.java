/*
References:
Guardado, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University.
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

package SportsTeamApp;

public class Team {
    private String teamName = "";
    private String[] players = new String[20];
    private int playerCount = 0;

    public Team(String nameOfTeam) {//constructor requiring a team name to set
        this.teamName = nameOfTeam;
    }

    public void addPlayer(String playerName) {
        if (playerCount < 20) {
            this.players[playerCount] = playerName;//assign player name to its respective place in array
            this.playerCount++;
        }
        else {
            //TODO: how should program behave if 21 or more players are entered for a team?
        }
    }

    //getters
    public String[] getPlayers() {
        return this.players;
    }
    public int getPlayerCount() {
        return this.playerCount;
    }
    public String getTeamName() {
        return this.teamName;
    }
}