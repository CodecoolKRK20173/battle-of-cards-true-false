package com.codecool.java.cheatCardGame.models;

import com.codecool.java.cheatCardGame.models.Rank;

public class Card implements Comparable<Card> {

    private Suit suit;
    private Rank rank;
    private boolean isFaceDown;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.isFaceDown = true;
    }

    public int compareTo(Card object) {
        if (object instanceof Card) {
            int i = this.suit.getSuitValue() - object.getSuit().getSuitValue();
            if(i < 0) return -1;
            else if(i == 0) return 0;
            else return 1;
        } else {
            throw new IllegalArgumentException();
        } 
    }


    public Suit getSuit() {
        return this.suit;
    }


    public Rank getRank() {
        return this.rank;
    }


    public boolean isFaceDown() {
        return this.isFaceDown;
    }


    public void setIsFaceDown(boolean isFaceDown) {
        this.isFaceDown = isFaceDown;
    }


    public void flip() {
        isFaceDown = !isFaceDown;
    }


    public String toString() {
        String card = "Card: " + rank.getRankName() + " of " + suit.getSuitName() + ".";
        return card;
    }



}
