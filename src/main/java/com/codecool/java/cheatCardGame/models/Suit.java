package com.codecool.java.cheatCardGame.models;
    public enum Suit {
        HEARTS(1),
        DIAMONDS(2),
        SPADES(3),
        CLUBS(4);


        private int suitValue;


        Suit(int suitValue){
            this.suitValue = suitValue;
        }


        public int getSuitValue() {
            return suitValue;
        }

        public int getSuitName() {
            //FIX:
            return suitValue;
        }
    }

