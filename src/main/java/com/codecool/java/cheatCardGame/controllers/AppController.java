package com.codecool.java.cheatCardGame.controllers;

import com.codecool.java.cheatCardGame.models.*;
import com.codecool.java.cheatCardGame.view.View;
import com.google.gson.Gson;

import java.util.Scanner;

public class AppController {

    private GameStateController GSC = new GameStateController("table.json");
    private Gson gson = new Gson();
    String gameMode = "";
    Scanner reader = new Scanner(System.in);
    String hostPattern = "(host|join)";
    String numOfPlayersPattern = "[2-9]";
    String numOfPlayers = "0";
    Table joinGame;
    Table hostGame;

    public void run() {

        while (!gameMode.matches(hostPattern)) {
            System.out.print("Do you want to be host or join game? [host/game]:");
            gameMode = reader.nextLine();

        }
        while (!numOfPlayers.matches(numOfPlayersPattern) && gameMode.equals("host")) {
            System.out.print("number of players? :");
            numOfPlayers = reader.nextLine();
        }

        if (gameMode.equals("join")) {
            Scanner in = new Scanner(System.in);
            String gameState = GSC.getGameState();
            this.joinGame = gson.fromJson(gameState, Table.class);
            while(true) {
                this.joinGame = gson.fromJson(gameState, Table.class);
                Player me = this.joinGame.getPlayerList().get(1);
                int numberOfCardsOnStack = this.joinGame.getWaste().size();
                System.out.println("Cards on stack: " + numberOfCardsOnStack);
                System.out.println("________");
                System.out.println(this.joinGame.getWaste());
                System.out.println(me.getHand().getCardList());
                System.out.println("What's your move? [Check/Play]: ");
                int chuj = in.nextInt();
                this.joinGame.putCardInWaste(me.getHand().getCardList().get(chuj));
                me.getHand().getCardList().remove(chuj);
                GSC.updateGameState(gson.toJson(this.joinGame));
            }
        } else if (gameMode.equals("host")) {
            this.hostGame = new Table(Integer.parseInt(numOfPlayers), gameMode);
            Scanner in = new Scanner(System.in);
            GSC.updateGameState(gson.toJson(this.hostGame));

            while(true) {

                String gameState = GSC.getGameState();
                this.hostGame = gson.fromJson(gameState, Table.class);
//                hostGame.getPlayerList().get(0).getHand().getCardList().remove(0);
//                Player me = hostGame.getPlayerList().get(0);
//                View view = new View(hostGame.getPlayerList(), me, hostGame.getDeck());
                Player me = this.hostGame.getPlayerList().get(0);
                int numberOfCardsOnStack = this.hostGame.getWaste().size();
                System.out.println("Cards on stack: " + numberOfCardsOnStack);
                System.out.println("________");
                System.out.println(this.hostGame.getWaste());
                System.out.println(me.getHand().getCardList());
                System.out.println("What's your move? [Check/Play]: ");
                int chuj = in.nextInt();
                hostGame.putCardInWaste(me.getHand().getCardList().get(chuj));
                me.getHand().getCardList().remove(chuj);
                GSC.updateGameState(gson.toJson(this.hostGame));
            }

        }
    }
}
