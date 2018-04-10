package com.codecool.java.cheatCardGame;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> cardsList;

    public Hand() {
        this.cardsList = new ArrayList<>();
    }


    public void addCard(Card card) {
        this.cardsList.add(card);
    }


    public void remove(Card card) {
        //for (Card card: cards) {
            this.cardsList.remove(card);
        //}
    }


    public boolean isEmpty() {
        if (this.cardsList.size() > 0) {
            return false;
        }
        return true;
    }


    public String toString() {
        int[] cardsBySuit = calculateCardsBySuit();
        String hand = "Cards in hand: " + cardsBySuit[0] + "x H, " +
                    cardsBySuit[1] + "x D, " +
                    cardsBySuit[2] + "x M, " +
                    cardsBySuit[3] + "x S";
        return hand;
    }


    private int[] calculateCardsBySuit() {
        int heartsNumber = 0;
        int diamondsNumber = 0;
        int macesNumber = 0;
        int spadesNumber = 0;
        for (Card card: cardsList) {
            if (card.getSuit() == Card.Suit.HEARTS)
                heartsNumber += 1;
            else if (card.getSuit() == Card.Suit.DIAMONDS)
                diamondsNumber += 1;
            else if (card.getSuit() == Card.Suit.MACES)
                macesNumber += 1;
            else
                spadesNumber += 1;
        }
        int[] cardsBySuit = {heartsNumber, diamondsNumber,
                            macesNumber, spadesNumber};
        return cardsBySuit;
    }
}
