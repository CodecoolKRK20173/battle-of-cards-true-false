package com.codecool.java.cheatCardGame.controllers;

import com.codecool.java.cheatCardGame.models.Suit;
import com.codecool.java.cheatCardGame.models.Card;
import com.codecool.java.cheatCardGame.models.Player;
import com.codecool.java.cheatCardGame.models.Rank;
import com.google.gson.Gson;
import com.codecool.java.cheatCardGame.models.Stack;
import com.codecool.java.cheatCardGame.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class AppController {
//    Scanner reader = new Scanner(System.in);
    List<Player> playerList;
    List<Card> deck;
    Gson parser = new Gson();
    Rank rank;
    Suit suit;

    GameStateController cardState = new GameStateController("cardList.json");
    GameStateController playerState = new GameStateController("playerList.json");

    public AppController(int numOfPlayers, String gameMode) {
        this.playerList = makePlayers(numOfPlayers);
        this.deck = generateDeck();
        dealCards();
        updateState();

    }

    public AppController(String gameMode) {

        getState();
//        playerList.get(1).setLastPlayerMove("Throw a card");
//        playerList.get(1).turnPlayerMove();

//        View view = new View(playerList.subList(1, playerList.size()), playerList.get(0), new Stack());

        System.out.println(this.playerList);
        System.out.println(this.deck);
        System.out.println("Main loop");
    }


    public void run() {
        //
    }


    public void getState() {
        this.deck = this.parser.fromJson(this.cardState.getGameState(), List.class);
        this.playerList = this.parser.fromJson(this.playerState.getGameState(), List.class);
    }

    public void updateState() {
        playerState.updateGameState(this.parser.toJson(this.playerList));
        cardState.updateGameState(this.parser.toJson(this.deck));
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
