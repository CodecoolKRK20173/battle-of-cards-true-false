package com.codecool.java.cheatCardGame.models;

import com.codecool.java.cheatCardGame.Stackable;

import java.util.List;
import java.util.ArrayList;

public class Stack implements Stackable {

    List<Card> stackCards;

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
