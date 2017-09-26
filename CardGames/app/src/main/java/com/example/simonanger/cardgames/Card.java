package com.example.simonanger.cardgames;

/**
 * Created by simonanger on 22/09/2017.
 */

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getRankNumerically() {
        int value = rank.ordinal()+1;
        return value;
    }

    String getSuitString() {
        return suit.toString().toLowerCase();
    }
}
