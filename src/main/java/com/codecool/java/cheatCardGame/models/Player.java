
package com.codecool.java.cheatCardGame.models;


public class Player {
    private String name;
    private Hand hand;
    private boolean isPlayerMove; // for test
    private boolean isLastMove;
    private String lastPlayerMove;// for test

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


    public void turnPlayerMove(){
        isPlayerMove = !isPlayerMove;
    }

    public boolean isPlayerMove() {
        return this.isPlayerMove;
    }


    public String getLastPlayerMove() {
        return this.playerMove;
    }
}
