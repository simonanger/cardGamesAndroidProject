package com.example.simonanger.cardgames;

/**
 * Created by simonanger on 25/09/2017.
 */

public class AdvancedHighLow implements Game {

    Deck deck;
    PlayingDealer dealer;
    Player player;
    int playerScore;
    int dealerScore;
    boolean isHigher;
    boolean playersChoice;

        public AdvancedHighLow(Deck deck, PlayingDealer dealer, Player player) {
            this.deck = deck;
            this.dealer = dealer;
            this.player = player;
            playerScore = 0;
            dealerScore = 0;
            this.isHigher = false;
            this.playersChoice = false;

        }

    public int draw() {
        Card playerCard = dealer.deal();
        player.getCard(playerCard);
        Card dealerCard = dealer.deal();
        dealer.getCard(dealerCard);


        playerScore = player.revealSingleCard(0).getRankNumerically();
        dealerScore = dealer.revealSingleCard(0).getRankNumerically();

        if (dealerScore == playerScore) {
            dealer.emptyHand();
            Card newCard = dealer.deal();
            dealer.getCard(newCard);
            dealerScore = dealer.revealSingleCard(0).getRankNumerically();
        }



        if (playerScore == 1) {
            playerScore = 14;
        }

        if (dealerScore == 1) {
            dealerScore = 14;
        }



        return -1;

    }

//        if (playerCardValue == 0) {
//            return 0;
//        }

        public int assess() {

            if (playerScore > dealerScore) {
                isHigher = true;
            }

            if (playerScore < dealerScore) {
                isHigher = false;
            }

            if (playerScore == dealerScore) {
                isHigher = false;
            }

            if (playersChoice == true && isHigher == true) {
                return 1;
            }

            if (playersChoice == false && isHigher == false) {
                return 1;
            }

            if (playersChoice == false && isHigher == true) {
                return 2;
            }
            else {
                return 2;
            }


        }


    }
