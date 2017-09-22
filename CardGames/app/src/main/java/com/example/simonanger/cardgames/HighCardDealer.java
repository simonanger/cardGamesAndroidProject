package com.example.simonanger.cardgames;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by simonanger on 22/09/2017.
 */

public class HighCardDealer implements Dealer {
    Deck deck;
    Random random;
    ArrayList<Card> hand;

    public HighCardDealer(Deck deck){
        this.deck = deck;
        this.random = new Random();
        this.hand = new ArrayList<>();
    }

    public Card deal(){
        int randomIndex = this.random.nextInt(this.deck.getCards().size());

        Card randomCard = this.deck.getCards().remove(randomIndex);
        return randomCard;
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
}
