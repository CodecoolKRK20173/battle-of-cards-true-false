package com.codecool.java.cheatCardGame;

import com.codecool.java.cheatCardGame.controllers.AppController;

public class Main {
    public static void main(String[] args) {
        AppController game = new AppController(5);
        game.run();
    }
}