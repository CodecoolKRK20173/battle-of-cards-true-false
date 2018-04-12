package com.codecool.java.cheatCardGame.controllers;

import com.codecool.java.cheatCardGame.models.Suit;
import com.google.gson.Gson;
import com.codecool.java.cheatCardGame.models.Card;
import com.codecool.java.cheatCardGame.models.Player;
import com.codecool.java.cheatCardGame.models.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class AppController {
//    Scanner reader = new Scanner(System.in);
    List<Player> playerList;
    List<Card> deck;
    Rank rank;
    Suit suit;

    public AppController(int numOfPlayers, String gameMode) {
        this.playerList = makePlayers(numOfPlayers);
        this.deck = generateDeck();
        dealCards();
        GameStateController gsc = new GameStateController("cardGame.json");
        Gson json = new Gson();
        gsc.updateGameState(json.toJson(this));
        System.out.println(gsc.getGameState());
    }

    public AppController(String gameMode) {
        //download gson file
        //initialie playerList
        //deck = generatedeck ??
    }
    
    public void run() {
//        reader.nextLine();
        while(winCondition()) {
            //get input etc..
            System.out.println("Main loop");
//            reader.nextLine();
            for(int i=0;i<40; i++)
            System.out.println(deck.get(i).compareTo(deck.get(i+1)));
        }
    }
    public boolean winCondition() {
        int counter = 0;
        for(Player player : playerList) {
            if(!player.getHand().getCardList().isEmpty()) counter++;
        }
        if(counter == playerList.size()) return true;
        else return false;

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