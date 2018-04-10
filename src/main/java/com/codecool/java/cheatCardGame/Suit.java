package com.codecool.java.cheatCardGame;
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

