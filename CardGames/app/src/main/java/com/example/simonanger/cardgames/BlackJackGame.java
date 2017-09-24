package com.example.simonanger.cardgames;

/**
 * Created by simonanger on 24/09/2017.
 */

public class BlackJackGame implements Game {
    Deck deck;
    PlayingDealer dealer;
    Player player;

    public BlackJackGame (Deck deck, PlayingDealer dealer, Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
    }

    public int draw() {
        Card playerCard1 = dealer.deal();
        player.getCard(playerCard1);
        Card dealerCard1 = dealer.deal();
        dealer.getCard(dealerCard1);
        Card playerCard2 = dealer.deal();
        player.getCard(playerCard2);
        Card dealerCard2 = dealer.deal();
        dealer.getCard(dealerCard2);

        int playersFirstCard = player.revealSingleCard(0).getRankNumerically();
        int playersSecondCard = player.revealSingleCard(1).getRankNumerically();

        int dealersFirstCard = dealer.revealSingleCard(0).getRankNumerically();
        int dealersSecondCard = dealer.revealSingleCard(1).getRankNumerically();

        switch (playersFirstCard) {
            case 11:
            case 12:
            case 13:
                playersFirstCard = 10;
        }

        switch (playersSecondCard) {
            case 11:
            case 12:
            case 13:
                playersSecondCard = 10;
        }

        switch (dealersFirstCard) {
            case 11:
            case 12:
            case 13:
                dealersFirstCard = 10;
        }

        switch (dealersSecondCard) {
            case 11:
            case 12:
            case 13:
                dealersSecondCard = 10;
        }

        int playerCardValue = playersFirstCard + playersSecondCard;
        int dealerCardValue = dealersFirstCard + dealersSecondCard;

        if (playerCardValue > 21) {
            return 0;
        }

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

    public void playerTwist() {
//        Card playerCard1 = dealer.deal();
//        player.getCard(playerCard1);
    }

}
