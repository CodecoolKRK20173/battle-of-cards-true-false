package com.codecool.java.cheatCardGame;

class Hand implements Stackable {
    package com.codecool.java.cheatCardGame;

    public class Card {

        private Suit suit;
        private Rank rank;
        private boolean isFaceDown;

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
            this.isFaceDown = true;
        }


        public Suit getSuit() {
            return this.suit;
        }


        public Rank getRank() {
            return this.rank;
        }


        public boolean isFaceDown() {
            return this.isFaceDown;
        }


        public void setIsFaceDown(boolean isFaceDown) {
            this.isFaceDown = isFaceDown;
        }


        public void flip() {
            isFaceDown = !isFaceDown;
        }


        public String toString() {
            String card = "Card: " + rank.getRankName() + " " + suit.getSuitName() + ".";
            return card;
        }


        public enum Suit {
            HEARTS("hearts"),
            DIAMONDS("diamonds"),
            SPADES("spades"),
            CLUBS("clubs");


            private String suitName;


            Suit(String suitName){
                this.suitName = suitName;
            }


            public String getSuitName() {
                return suitName;
            }
        }


        public enum Rank {
            ACE("Ace"),
            TWO("2"),
            THREE("3"),
            FOUR("4"),
            FIVE("5"),
            SIX("6"),
            SEVEN("7"),
            EIGHT("8"),
            NINE("9"),
            TEN("10"),
            JACK("Jack"),
            QUEEN("Queen"),
            KING("King");


            private String rankName;


            Rank(String rankName){
                this.rankName = rankName;
            }


            public String getRankName() {
                return rankName;
            }
        }
    }
}
