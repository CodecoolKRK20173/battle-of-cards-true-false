package com.codecool.java.cheatCardGame.models;

import com.codecool.java.cheatCardGame.Stackable;

import java.util.ArrayList;
import java.util.List;

public class Hand implements Stackable {
    private List<Card> cardsList;
    private Suit suit;
    private Rank rank;

    public Hand() {
        this.cardsList = new ArrayList<>();
    }

    public List<Card> getCardList() {
        return cardsList;
    }

    public void addCard(Card card) {
        this.cardsList.add(card);
    }


    public void removeCard(Card card) {
        this.cardsList.remove(card);
    }


    public boolean isEmpty() {
        if (this.cardsList.size() > 0) {
            return false;
        }
        return true;
    }


    public String toString() {
        int[] cardsBySuit = calculateCardsBySuit();
        String hand = "Cards in hand: " +
                    cardsBySuit[0] + "x \u2665, " +
                    cardsBySuit[1] + "x \u2666, " +
                    cardsBySuit[2] + "x \u2663, " +
                    cardsBySuit[3] + "x \u2660";
        return hand;
    }


    public int getNumOfCards() {
        return this.cardsList.size();
    }


    private int[] calculateCardsBySuit() {
        int heartsNumber = 0;
        int diamondsNumber = 0;
        int clubsNumber = 0;
        int spadesNumber = 0;
        for (Card card: cardsList) {
            if (card.getSuit() == Suit.HEARTS)
                heartsNumber += 1;
            else if (card.getSuit() == Suit.DIAMONDS)
                diamondsNumber += 1;
            else if (card.getSuit() == Suit.CLUBS)
                clubsNumber += 1;
            else
                spadesNumber += 1;
        }
        int[] cardsBySuit = {heartsNumber, diamondsNumber,
                            clubsNumber, spadesNumber};
        return cardsBySuit;
    }
}