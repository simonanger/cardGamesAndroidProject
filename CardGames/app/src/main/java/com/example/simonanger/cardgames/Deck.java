package com.example.simonanger.cardgames;

import java.util.ArrayList;

/**
 * Created by simonanger on 22/09/2017.
 */

public class Deck {
    ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void generate() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }
}
