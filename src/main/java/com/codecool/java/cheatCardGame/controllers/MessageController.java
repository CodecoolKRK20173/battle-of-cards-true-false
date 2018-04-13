package com.codecool.java.cheatCardGame.controllers;

import java.util.Scanner;

public class MessageController {

    GameStateController GSC = new GameStateController("table.json");
    public String message;
    public void run() {

        Scanner in = new Scanner(System.in);
        int mode = in.nextInt();

        if (mode == 0) {
            while(true) {
                System.out.print("Type your message: ");
                this.message = in.nextLine();
                GSC.updateGameState(this.message);
            }
            //wysylanie
        } else {

            //pobieranie
        }


    }

}
