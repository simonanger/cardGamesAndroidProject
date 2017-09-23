package com.example.simonanger.cardgames;

import android.util.Log;

/**
 * Created by simonanger on 22/09/2017.
 */

public class HighCardGame {
    Deck deck;
    HighCardDealer highCardDealer;
    Player player;

    public HighCardGame(Deck deck, HighCardDealer highCardDealer, Player player) {
        this.deck = deck;
        this.highCardDealer = highCardDealer;
        this.player = player;
    }

    public int play() {
        Card playerCard = highCardDealer.deal();
        player.getCard(playerCard);
        Card dealerCard = highCardDealer.deal();
        highCardDealer.getCard(dealerCard);

        int playerCardValue = player.revealSingleCard().getRankNumerically();
        int dealerCardValue = highCardDealer.revealSingleCard().getRankNumerically();

//        if (playerCardValue == 0) {
//            return 0;
//        }

        if (playerCardValue > dealerCardValue) {
            return 1;
        }

        if (playerCardValue < dealerCardValue) {
            return 2;
        }

        if (playerCardValue == dealerCardValue) {
            return 2;
        }

        return -1;


    }


}