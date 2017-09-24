package com.example.simonanger.cardgames;

import java.util.ArrayList;

/**
 * Created by simonanger on 22/09/2017.
 */

public class Player {
    public String name;
    ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList getHand() {
        return hand;
    }

    public void getCard(Card card) {
        hand.add(card);
    }

    public void loseCard(Card card) {
        hand.remove(card);
    }

    public void emptyHand() {
        hand.clear();
    }

    public Card revealSingleCard(int num) {
        return hand.get(num);
    }

}
