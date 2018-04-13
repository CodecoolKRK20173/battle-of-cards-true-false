package com.codecool.java.cheatCardGame.controllers;

import com.codecool.java.cheatCardGame.models.*;
import com.google.api.client.util.DateTime;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AppController {

    private Gson gson = new Gson();
    private String gameMode = "";
    private Scanner reader = new Scanner(System.in);
    private String hostPattern = "(host|join)";
    private String numOfPlayersPattern = "[2-9]";
    private String numOfPlayers = "0";
    private Table game;
    private Player player;
    private Player opponent;
    private List<Card> waste = new ArrayList<>();

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
            GameStateController GSC = new GameStateController("table.json");
            String gameState = GSC.getGameState();
            this.game = gson.fromJson(gameState, Table.class);
            this.opponent = this.game.getPlayerList().get(0);
            this.player = this.game.getPlayerList().get(1);
        } else if (gameMode.equals("host")) {
            this.game = new Table(Integer.parseInt(numOfPlayers), gameMode);
            this.player = this.game.getPlayerList().get(0);
            this.opponent = this.game.getPlayerList().get(1);
            this.player.turnPlayerMove();
        }

        Scanner in = new Scanner(System.in);

        while(true) {
            GameStateController GSC = new GameStateController("table.json");
            String gameState = GSC.getGameState();
            this.game = gson.fromJson(gameState, Table.class);
            int numberOfCardsOnStack = this.game.getWaste().size();
            System.out.println("Cards on stack: " + numberOfCardsOnStack);
            System.out.println("________");

            System.out.println(this.game.getWaste());
            System.out.println(this.player.getHand().getCardList());
            System.out.println("What's your move? [Check/Play]: ");
            System.out.println(this.player.isPlayerMove());
            String pickerCard = in.nextLine();
            this.game.putCardInWaste(this.player.getHand().getCardList().get(Integer.parseInt(pickerCard)));
            this.player.getHand().getCardList().remove(pickerCard);
            this.player.turnPlayerMove();
            System.out.println(this.game.getWaste());
            GSC.updateGameState(gson.toJson(this.game));
        }

    }

    public boolean isInt(String s) {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }
}
