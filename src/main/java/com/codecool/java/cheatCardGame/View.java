package com.codecool.java.cheatCardGame;

import java.util.List;

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
            System.out.print(enemy.getPlayerName() + " -> " +
                            enemy.getHand().getNumOfCards()+ "x ");
        } System.out.println("");
    }


    public void showCardStack() {
        System.out.println(stack);
    }


    public void showAllPlayers() {
        System.out.print(player.getPlayerName());
        for (Player enemy: enemyPlayers) {
            System.out.print(" " + enemy.getPlayerName());
        } System.out.println("");
    }
}
