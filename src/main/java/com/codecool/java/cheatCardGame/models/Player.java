
package com.codecool.java.cheatCardGame.models;


public class Player {
    private String name;
    private Hand hand;
    private boolean isPlayerMove = false; // for test
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
}
