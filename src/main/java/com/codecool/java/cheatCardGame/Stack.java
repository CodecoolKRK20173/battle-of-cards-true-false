package com.codecool.java.cheatCardGame;

import java.util.List;
import java.util.ArrayList;

class Stack implements Stackable {

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
        return stack;
    }
}
