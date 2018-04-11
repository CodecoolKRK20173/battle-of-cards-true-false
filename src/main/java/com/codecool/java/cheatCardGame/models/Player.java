
package com.codecool.java.cheatCardGame.models;


public class Player {
    private String name;
    private Hand hand;
    private boolean isPlayerMove; // for test
    private String playerMove;// for test

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


    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }


    public String getPlayerMove() {
        return this.playerMove;
    }
}
