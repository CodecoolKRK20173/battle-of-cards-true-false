package com.codecool.java.cheatCardGame;

import com.codecool.java.cheatCardGame.models.*;
import com.codecool.java.cheatCardGame.models.Player;
import java.util.List;
import java.util.ArrayList;
import java.io.InputStreamReader;

public class View {

    private List<Player> enemyPlayers;
    private Player player;
    private Stack stack;

    public View(List<Player> enemyPlayers, Player player, Stack stack) {
        this.enemyPlayers = enemyPlayers;
        this.player = player;
        this.stack = stack;
    }


    public void showPlayerHand() {
        System.out.println(player.getHand());
    }


    public void showNumOfEnemyCards() {
        System.out.print("Enemy players cards: ");
        for (Player enemy: enemyPlayers) {
            System.out.print(enemy.getName() + " -> " +
                            enemy.getHand().getNumOfCards()+ "x");
        } System.out.println("");
    }


    public void showCardStack() {
        System.out.println(stack);
    }


    public void showAllPlayers() {
        System.out.print(player.getName());
        for (Player enemy: enemyPlayers) {
            System.out.print(" " + enemy.getName());
        } System.out.println("");
    }


    public void showEnemyMove(Player enemy) {
        String move1 = "Throw a card";
        String move2 = "Check a stack";
        System.out.print("Player " + enemy.getName() + ": ");
        if (enemy.getPlayerMove().equalsIgnoreCase(move1))
            System.out.print(move1);
        else
            System.out.print(move2);
        System.out.println("");
    }


    public void showPlayerPossibleMoves() {
        System.out.println("1) Throw a card    2) Check stack");
        consoleReadingDemo();

    }


    private void consoleReadingDemo() {
        InputStreamReader reader = new InputStreamReader(System.in);
        boolean b = false;
        while(!b)
        {
            try
            {
                int key = System.in.read();
                System.out.println("key pressed");
                b = true;
             } catch (java.io.IOException ioex) {
                System.out.println("IO Exception");
             }
             try {
                Thread.sleep(50);
                System.out.println("nop yet");
             } catch (InterruptedException ex) {
                System.out.println("Interrupted Exception");
             }
        }
    }
}
