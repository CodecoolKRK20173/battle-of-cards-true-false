package com.codecool.java.cheatCardGame.models;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Hand hand;
    private boolean isPlayerMove; // for test
    private boolean isLastMove;
    private String lastPlayerMove;// for test
    Map<Suit, List<Card>> cardsBySuit;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return this.name;
    }


    public void setLastPlayerMove(String lastPlayerMove) {
        this.lastPlayerMove = lastPlayerMove;
    }


    public void turnPlayerMove(){
        isPlayerMove = !isPlayerMove;
    }

    public boolean isPlayerMove() {
        return this.isPlayerMove;
    }


    public String getLastPlayerMove() {
        return this.lastPlayerMove;
    }


    public boolean isLastMove() {
        return this.isLastMove;
    }


    public void setIsLastMove() {
        this.isLastMove = !this.isLastMove;
    }

    public void setCardsBySuit() {
        this.cardsBySuit = new TreeMap<>();
        cardsBySuit.put(Suit.HEARTS, new ArrayList<Card>());
        cardsBySuit.put(Suit.DIAMONDS, new ArrayList<Card>());
        cardsBySuit.put(Suit.CLUBS, new ArrayList<Card>());
        cardsBySuit.put(Suit.SPADES, new ArrayList<Card>());
        for (Card card: hand.getCardList()) {
            if (card.getSuit() == Suit.HEARTS)
                cardsBySuit.get(Suit.HEARTS).add(card);
            else if (card.getSuit() == Suit.DIAMONDS)
                cardsBySuit.get(Suit.DIAMONDS).add(card);
            else if (card.getSuit() == Suit.CLUBS)
                cardsBySuit.get(Suit.CLUBS).add(card);
            else
                cardsBySuit.get(Suit.SPADES).add(card);
        }
    }


    public Map<Suit, List<Card>> getCardsBySuit() {
        return this.cardsBySuit;
    }
}
