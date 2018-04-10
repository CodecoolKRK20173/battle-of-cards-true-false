
package com.codecool.java.cheatCardGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

class AppController {
    Scanner reader = new Scanner(System.in);
    List<Player> playerList;  
    List<Card> deck;
    Rank rank;
    Suit suit;

    AppController(int numOfPlayers) {
        this.playerList = makePlayers(numOfPlayers);
        this.deck = generateDeck();
        dealCards();
        // // System.out.println(deck);
        // //for test only
        // for(Player player : playerList) {
        //     System.out.println(player.getName() + "-----------" + player.getHand().cardsList.size());
        //     System.out.println(player.getHand().cardsList);
        // }
    }
    
    public void run() {
        boolean isGameWon = false;

        while(!isGameWon) {
            //get input etc..
        }
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
        Collections.shuffle(deck);
        return deck;
    }

    private void dealCards() {
        Iterator<Card> deckIterator = deck.iterator();
        while(deckIterator.hasNext()) {
            for(Player player : playerList) {
                if(deckIterator.hasNext()) {
                    player.getHand().addCard(deckIterator.next());
                }
            }
        }
    }

}