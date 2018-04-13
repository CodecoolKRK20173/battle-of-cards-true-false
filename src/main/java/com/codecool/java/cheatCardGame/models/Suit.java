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

        public String getSuitName() {
            if (suitValue == 1)
                return "hearts";
            else if (suitValue == 2)
                return "diamonds";
            else if (suitValue == 3)
                return "spades";
            else
                return "clubs";
        }
    }
