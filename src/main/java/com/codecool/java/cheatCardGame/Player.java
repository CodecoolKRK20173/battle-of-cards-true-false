
package com.codecool.java.cheatCardGame;
import java.util.List;
import java.util.ArrayList;


class Player {
    private String name;
    private Hand hand;

    Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public String getPlayerName() {
        return this.name;
    }
}
