package com.codecool.java.cheatCardGame.models;

import com.codecool.java.cheatCardGame.view.View;
import java.lang.IndexOutOfBoundsException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;


public class Table {
    Scanner scanner;
    List<Player> playerList;
    List<Card> deck;
    Stack stack;
    boolean isGameDurning;
    View view;

    public Table(int numOfPlayers, String gameMode) {
        this.scanner = new Scanner(System.in);
        this.playerList = makePlayers(numOfPlayers);
        this.deck = generateDeck();
        this.stack = new Stack();
        dealCards();
        isGameDurning = true;
    }

    public Table(String gameMode) {
        System.out.println(this.playerList);
        System.out.println(this.deck);
        System.out.println("Main loop");
    }

    public void run() {
        setFirstMoveTurn();
        view  = new View(playerList.subList(1, playerList.size()),
                        playerList.get(0), stack);
        while (isGameDurning) {
            moveTurn();
        }
    }

    private void setFirstMoveTurn() {
        playerList.get(0).turnPlayerMove();
        for (Player player: playerList) {
            player.setCardsBySuit();
        }
    }


    private void moveTurn() {
        for (Player player: playerList) {
            if (player.isPlayerMove()) {
                makeATurn(player);
            }
        }
    }


    private void makeATurn(Player player) {
        try {
            int numOfSuit = scanner.nextInt();
            Suit cardSuit = getCardSuit(numOfSuit);
            List<Card> cardsByOneSuit = player.getCardsBySuit().get(cardSuit);
            view.showChosenCardSuit(cardSuit);
            int numOfCard = validateNumberOfCardsToMove(cardSuit, cardsByOneSuit);
            /*while (numOfCard > cardsByOneSuit.size()) {
                System.out.println("You don't have " + numOfCard + " cards!");
                view.showChosenCardSuit(cardSuit);
                numOfCard = scanner.nextInt();
            }*/
            for (int i = 0; i < numOfCard; i++) {
                Card card = cardsByOneSuit.get(0);
                stack.addCard(card);
                player.getHand().getCardList().remove(card);
                player.getCardsBySuit().get(cardSuit).remove(card);
            }
            changeMoveTurn(player);
            view.getKeyReader().setVisible(true);
        } catch (InputMismatchException er) {
            System.out.println("You didn't entered a number");
            scanner.next();
        }
    }

    private int validateNumberOfCardsToMove(Suit cardSuit, List<Card> cardsByOneSuit) {
        int numOfCard = scanner.nextInt();
        while (numOfCard > cardsByOneSuit.size()) {
            System.out.println("You don't have " + numOfCard + " cards!");
            view.showChosenCardSuit(cardSuit);
            numOfCard = scanner.nextInt();
        } return numOfCard;
    }


    private void changeMoveTurn(Player player) {
        player.turnPlayerMove();
        player.setLastPlayerMove("Throw a card");
        player.setIsLastMove();
        for (Player enem: playerList) {
            if (enem != player)
                setSecondPlayerTurn(player, enem);
        }
    }


    private void setSecondPlayerTurn(Player firstPlayer, Player secondPlayer) {
        secondPlayer.turnPlayerMove();
        playerList.set(0, secondPlayer);
        playerList.set(1, firstPlayer);
        view.setLocalPlayer(playerList.get(0));
        view.getPlayerList().set(0, playerList.get(1));
    }


    private Suit getCardSuit(int numOfSuit) {
        if (numOfSuit == 1)
            return Suit.HEARTS;
        else if (numOfSuit == 2)
            return Suit.DIAMONDS;
        else if (numOfSuit == 3)
            return Suit.CLUBS;
        else
            return Suit.SPADES;
    }


    public List<Player> makePlayers(int numberOfPlayers) {
        List<Player> playerList = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        String playerName;

        for(int i=0; i<numberOfPlayers; i++) {

            System.out.print("Name of player " + (i+1)+ ": ");
            playerName = reader.nextLine();
            playerList.add(new Player(playerName));
        }

        return playerList;
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

    public List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        for(Suit suit : Suit.values()) {
            for(Rank rank :Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }


    public void dealCards() {
        Iterator<Card> deckIterator = deck.iterator();
        while(deckIterator.hasNext()) {
            for(Player player : playerList) {
                if(deckIterator.hasNext()) {
                    player.getHand().addCard(deckIterator.next());
                }
            }
        }
    }

}
