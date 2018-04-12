package com.codecool.java.cheatCardGame;

import com.codecool.java.cheatCardGame.controllers.AppController;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String hostPattern = "(host|join)";
        String numOfPlayersPattern = "[2-9]";
        Scanner reader = new Scanner(System.in); 
        String gameMode = "";
        String numOfPlayers = "0";
        AppController game;

        while(!gameMode.matches(hostPattern)) {
            System.out.print("Do you want to be host or join game? [host/game]:");
            gameMode = reader.nextLine(); 

        }
        while(!numOfPlayers.matches(numOfPlayersPattern) && gameMode.equals("host")) {
            System.out.print("number of players? :");
            numOfPlayers = reader.nextLine();
        }


        if(gameMode.equals("join")) {
            game = new AppController(gameMode);
            game.run();
        } else if(gameMode.equals("host")) {
            game = new AppController(Integer.parseInt(numOfPlayers), gameMode);
            game.run();
        }

        reader.close();

    }
}