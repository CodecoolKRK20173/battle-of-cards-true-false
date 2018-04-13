package com.codecool.java.cheatCardGame.controllers;

import java.util.Scanner;

public class MessageController {

    GameStateController GSC = new GameStateController("table.json");
    public String message;

    public void run() {

        Scanner in = new Scanner(System.in);
        int mode = in.nextInt();
        while (true) {
            if (mode == 0) {
                System.out.print("Type your message: ");
                this.message = in.nextLine();
                GSC.updateGameState(this.message);
            } else {
                this.message = GSC.getGameState();
                System.out.println(this.message);
            }
            sleep(1000);
            clearScreen();

        }
    }

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            //
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
