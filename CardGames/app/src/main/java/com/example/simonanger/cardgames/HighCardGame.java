package com.example.simonanger.cardgames;

/**
 * Created by simonanger on 22/09/2017.
 */

public class HighCardGame {
    Deck deck;
    Dealer dealer;
    Player player;

    public HighCardGame(Deck deck, Dealer dealer, Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
    }

    public Deck getDeck() {
        return deck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return player;
    }
}
//
//
//    private Player getWinner() {
//        int highestValue = Integer.MIN_VALUE;
//        Player winner = null;
//
//        for (Player player: players) {
//            int currentValue = player.getCard().getValue();
//            if (currentValue > highestValue) {
//                highestValue = currentValue;
//                winner = player;
//            }
//        }
//        return winner;