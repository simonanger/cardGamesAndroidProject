package com.example.simonanger.cardgames;

/**
 * Created by simonanger on 22/09/2017.
 */

public class HighCardGame implements Game {
    Deck deck;
    PlayingDealer dealer;
    Player player;

    public HighCardGame(Deck deck, PlayingDealer dealer, Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
    }

    public int draw() {
        Card playerCard = dealer.deal();
        player.getCard(playerCard);
        Card dealerCard = dealer.deal();
        dealer.getCard(dealerCard);


        int playerCardValue = player.revealSingleCard(0).getRankNumerically();
        int dealerCardValue = dealer.revealSingleCard(0).getRankNumerically();

        if(playerCardValue == 1) {
            playerCardValue = 14;
        }

        if(dealerCardValue == 1) {
            dealerCardValue = 14;
        }

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