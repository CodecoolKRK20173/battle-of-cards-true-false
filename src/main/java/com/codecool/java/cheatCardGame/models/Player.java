
package com.codecool.java.cheatCardGame.models;


public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }
    
    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}