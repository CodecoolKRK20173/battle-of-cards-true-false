package com.codecool.java.cheatCardGame.view;

import com.codecool.java.cheatCardGame.models.Stack;
import com.codecool.java.cheatCardGame.models.Player;
import java.util.List;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.awt.event.KeyEvent;
import java.awt.Button;

public class View {

    private List<Player> enemyPlayers;
    private Player player;
    private Stack stack;
    private String playerMove1 = "1) Throw a card  ";
    private String playerMove2 = "  2) Check stack";
    private KeyReader keyReader;

    public View(List<Player> enemyPlayers, Player player, Stack stack) {
        this.enemyPlayers = enemyPlayers;
        this.player = player;
        this.stack = stack;
        this.keyReader = new KeyReader(this);
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
        System.out.print(playerMove1);
        System.out.println(playerMove2);
    }


    public void setPlayerMoves(String move1, String move2) {
        this.playerMove1 = move1;
        this.playerMove2 = move2;
    }


    public void showCurrentGameStage() {
        System.out.print("\033[2J\033[H");
        showAllPlayers();
        showNumOfEnemyCards();
        showCardStack();
        showEnemyMove(this.enemyPlayers.get(0));
        showPlayerPossibleMoves();
        showPlayerHand();
    }
}