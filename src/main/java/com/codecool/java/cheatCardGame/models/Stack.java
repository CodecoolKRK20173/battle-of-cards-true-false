package com.codecool.java.cheatCardGame.models;

import com.codecool.java.cheatCardGame.Stackable;

import java.util.List;
import java.util.ArrayList;

public class Stack implements Stackable {

    private List<Card> stackCards;

    public Stack() {
        this.stackCards = new ArrayList<>();
    }


    public void addCard(Card card) {
        this.stackCards.add(card);
    }


    public void removeCard(Card card) {
        this.stackCards.remove(card);
    }


    public String toString() {
        String stack = "Cards on stack: " + this.stackCards.size();
        stack += " " + getCardSymbol();
        return stack;
    }


    private String getCardSymbol() {
        Card topCard = stackCards.size() > 0 ? stackCards.get(stackCards.size() - 1): null;
        Suit topSuit = topCard != null ? topCard.getSuit(): null;
        if (topSuit == Suit.HEARTS)
            return "\u001B[31m\u2665\u001B[0m";
        else if (topSuit == Suit.DIAMONDS)
            return "\u001B[31m\u2666\u001B[0m";
        else if (topSuit == Suit.CLUBS)
            return "\u001B[30m\u2663\u001B[0m";
        else if (topSuit == Suit.SPADES)
            return "\u001B[30m\u2660\u001B[0m";
        else
            return "";
    }
}
