
package com.codecool.java.cheatCardGame;
import java.util.List;
import java.util.ArrayList;


class Player {
    String name;
    // List<Card>  = new ArrayList<>();
    Hand hand;
    Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }
    
    // public void addCard(Card card);
}