
package com.codecool.java.cheatCardGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AppController {
    Scanner reader = new Scanner(System.in);
    List<Player> playerList;  
    AppController(int numOfPlayers) {
        this.playerList = makePlayers(numOfPlayers);
    }
    
    private List<Player> makePlayers(int numberOfPlayers) {
        List<Player> playerList = new ArrayList<>();
        String playerName;

        for(int i=0; i<numberOfPlayers; i++) {
            playerName = reader.nextLine();
            playerList.add(new Player(playerName));                
        }

        return playerList;
    }


}