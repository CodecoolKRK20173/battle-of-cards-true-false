package com.codecool.java.cheatCardGame.controllers;

import com.codecool.java.cheatCardGame.models.*;
import com.codecool.java.cheatCardGame.view.View;



public class PlayerVsPlayer {
    Table table;
    public PlayerVsPlayer() {
        this.table = new Table(2, "gameMode");
        table.run();
    }
}
