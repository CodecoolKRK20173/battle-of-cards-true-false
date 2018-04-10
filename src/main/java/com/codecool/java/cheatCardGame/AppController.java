
package com.codecool.java.cheatCardGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AppController {
    Scanner reader = new Scanner(System.in);
    List<Player> playerList;  
    List<Card> deck;
    Rank rank;
    Suit suit;

    AppController(int numOfPlayers) {
        this.playerList = makePlayers(numOfPlayers);
        this.deck = generateDeck();
        System.out.println(deck);
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

    private List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        for(Suit suit : Suit.values()) {
            for(Rank rank :Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    // private void dealCards() {
    //     for(Player player : playerList) {
    //     }
    // }

}