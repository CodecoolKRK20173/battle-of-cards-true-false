package com.codecool.java.cheatCardGame.controllers;

import com.codecool.java.cheatCardGame.models.*;
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
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                String gameState = GSC.getGameState();
                while(gameState == null) {
                    GSC.setFileId();
                }
                if(gameState != null) {
                    Table joinGame = gson.fromJson(gameState, Table.class);
                    joinGame.run();
                }
            }
        } else if (gameMode.equals("host")) {
            Table hostGame = new Table(Integer.parseInt(numOfPlayers), gameMode);
            while(true) {
                GSC.updateGameState(gson.toJson(hostGame));
                hostGame.getPlayerList().get(0).getHand().getCardList().remove(0);
                hostGame.run();
                System.out.println("________________________");
            }
        }
    }
}
