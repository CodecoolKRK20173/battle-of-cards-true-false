package com.codecool.java.cheatCardGame.models;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Table {
    List<Player> playerList;
    List<Card> deck;
    List<Card> waste = new ArrayList<>();

    public Table(int numOfPlayers, String gameMode) {
        this.playerList = makePlayers(numOfPlayers);
        this.deck = generateDeck();
        dealCards();
    }

    public Table(String gameMode) {
//        System.out.println(this.playerList);
//        System.out.println(this.deck);
//        System.out.println("Main loop");
    }

    public void run() {
//        System.out.println(this.deck);
//        System.out.println(this.playerList);
//        System.out.println("-------" + this.playerList.get(0).getHand().getCardList());
    }

    public List<Card> getDeck() {
        return this.deck;
    }

    public void putCardInWaste(Card c) {
        waste.add(c);
    }

    public List<Card> getWaste() {
        return this.waste;
    }


    public List<Player> makePlayers(int numberOfPlayers) {
        List<Player> playerList = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        String playerName;

        for(int i=0; i<numberOfPlayers; i++) {

            System.out.print("Name of player " + (i+1)+ ": ");
            playerName = reader.nextLine();
            playerList.add(new Player(playerName));
        }

        return playerList;
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

    public List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        for(Suit suit : Suit.values()) {
            for(Rank rank :Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }


    public void dealCards() {
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
