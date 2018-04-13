
package com.codecool.java.cheatCardGame;

import com.codecool.java.cheatCardGame.models.Card;

public interface Stackable {
    public void addCard(Card card);
    public void removeCard(Card card);
    public String toString();
}
