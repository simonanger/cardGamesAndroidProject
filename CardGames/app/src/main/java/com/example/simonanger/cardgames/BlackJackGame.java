package com.example.simonanger.cardgames;

/**
 * Created by simonanger on 24/09/2017.
 */

public class BlackJackGame implements Game {
    Deck deck;
    PlayingDealer dealer;
    Player player;
    int playerCardValue;
    int dealerCardValue;

    public BlackJackGame (Deck deck, PlayingDealer dealer, Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
        playerCardValue = 0;
        dealerCardValue = 0;
    }

    public int getPlayerCardValue() {
        return playerCardValue;
    }

    public int getDealerCardValue() {
        return dealerCardValue;
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

        if (playerCardValue <= 10) {
            switch (playersFirstCard) {
                case 1:
                    playersFirstCard = 11;
            }

        }

        if (playerCardValue <= 10) {
            switch (playersSecondCard) {
                case 1:
                    playersSecondCard = 11;
            }
        }

        if (dealerCardValue <= 10) {
            switch (dealersFirstCard) {
                case 1:
                    dealersFirstCard = 11;
            }
        }

        if (dealerCardValue <= 10) {
            switch (dealersSecondCard) {
                case 1:
                    dealersSecondCard = 11;
            }
        }

        playerCardValue += (playersFirstCard + playersSecondCard);
        dealerCardValue += (dealersFirstCard + dealersSecondCard);

        return playerCardValue;
    }

    public void playerTwist() {
        player.getCard(dealer.deal());

        int playersNewCard = player.revealSingleCard(player.getHand()
                .size()-1).getRankNumerically();

        if (playerCardValue <= 10) {
            switch (playersNewCard) {
                case 1:
                    playersNewCard = 11;
            }
        }

        switch (playersNewCard) {
            case 11:
            case 12:
            case 13:
                playersNewCard = 10;
        }

        playerCardValue += playersNewCard;

        if (playerCardValue > 21) {
            this.assess();
        }
    }

    public void dealersHandLessThan17() {
        if (dealerCardValue < 17 ) {
            dealer.getCard(dealer.deal());

            int dealersNewCard = dealer.revealSingleCard(dealer.getHand()
                    .size()-1).getRankNumerically();


            switch (dealersNewCard) {
                case 11:
                case 12:
                case 13:
                    dealersNewCard = 10;
            }
            dealerCardValue += dealersNewCard;
        }

    }

    public int assess() {
//        this.dealersHandLessThan17();

        if (playerCardValue > 21) {
            return 2;
        }

        if (dealerCardValue > 21) {
            return 1;
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

}
