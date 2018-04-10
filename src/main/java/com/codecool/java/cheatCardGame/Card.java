package com.codecool.java.cheatCardGame;

public class Card {

    private Suit suit;
    private Rank rank;
    private boolean isFaceDown;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.isFaceDown = true;
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
        String card = "Card " + rank.toLowerCase() + " " + suit.toLowerCase() + ".";
        return card;
    }


    public enum Suit {
        "HEARTS",
        "DIAMONDS",
        "MACES",
        "SPADES"
    }


    public enum Rank {
        "ACE",
        "TWO",
        "THREE",
        "FOUR",
        "FIVE",
        "SIX",
        "SEVEN",
        "EIGHT",
        "NINE",
        "TEN",
        "JACK",
        "QUEEN",
        "KING"
    }
}