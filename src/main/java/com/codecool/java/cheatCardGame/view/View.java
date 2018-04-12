package com.codecool.java.cheatCardGame.view;

import com.codecool.java.cheatCardGame.controllers.KeyReader;
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
                            enemy.getHand().getNumOfCards()+ "x ");
        } System.out.println("");
    }


    public void showCardStack() {
        System.out.println(stack);
    }


    public void showAllPlayers() {
        if (player.isPlayerMove())
            System.out.print(" \u001B[46m" + player.getName() + "\u001B[0m");
        else
            System.out.print(player.getName());
        for (Player enemy: enemyPlayers) {
            if (enemy.isPlayerMove())
                System.out.print(" \u001B[46m" + enemy.getName() + "\u001B[0m");
            else
                System.out.print(" " + enemy.getName());
        } System.out.println("");
    }


    public void showEnemyMove() {
        Player enemy = getPlayerWithLastMoveTurn();
        String move1 = "Throw a card";
        String move2 = "Check a stack";
        if (enemy != null) {
            System.out.print("Player " + enemy.getName() + ": ");
            if (enemy.getLastPlayerMove().equalsIgnoreCase(move1))
                System.out.print(move1);
            else
                System.out.print(move2);
            System.out.println("");
        }
    }


    public void showPlayerPossibleMoves() {
        System.out.print(playerMove1);
        System.out.println(playerMove2);
    }


    public void setHighlightedPlayerMove(String move1, String move2) {
        this.playerMove1 = move1;
        this.playerMove2 = move2;
    }


    private Player getPlayerWithLastMoveTurn() {
        for (Player enemyPlayer: enemyPlayers) {
            if (enemyPlayer.isLastMove())
                return enemyPlayer;
        } return null;
    }


    public void showPlayerMove(String move1, String move2) {
        //System.out.println(move1 + "-->" + playerMove1);
        //System.out.println(move2 + "-->" + playerMove2);
        if (playerMove1.equals(move1)) {
            showCardsToThrow();
        }
    }


    public void showCardsToThrow() {
        int[] cardsBySuit = player.getHand().calculateCardsBySuit();
        String[] cardsSymbols = {"x \u2665  ", "x \u2666  ", "x \u2663  ", "x \u2660  "};
        System.out.println("\u001B[36mYou can throw following cards:\u001B[0m");
        for (int i = 0; i < cardsBySuit.length; i++) {
            if (cardsBySuit[i] == 0)
                break;
            System.out.print((i + 1) + ". " + cardsBySuit[i] + cardsSymbols[i]);
        }System.out.println("");

    }


    public void showCurrentGameStage() {
        System.out.print("\033[2J\033[H");
        showAllPlayers();
        showNumOfEnemyCards();
        showCardStack();
        showEnemyMove();
        showPlayerPossibleMoves();
        showPlayerHand();
    }
}
