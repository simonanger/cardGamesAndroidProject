package com.example.simonanger.cardgames;

/**
 * Created by simonanger on 24/09/2017.
 */

public class CardCountGame implements Game {

    Deck deck;
    PlayingDealer dealer;
    Player player;
    int totalToGuess;

    public CardCountGame(Deck deck, PlayingDealer dealer, Player player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
        totalToGuess = 0;
    }

    public int draw() {
        Card playerCard1 = dealer.deal();
        player.getCard(playerCard1);
        Card playerCard2 = dealer.deal();
        player.getCard(playerCard2);
        Card playerCard3 = dealer.deal();
        player.getCard(playerCard3);


        int playerCard1Value = player.revealSingleCard(0).getRankNumerically();
        int playerCard2Value = player.revealSingleCard(1).getRankNumerically();
        int playerCard3Value = player.revealSingleCard(2).getRankNumerically();

        if (playerCard1Value > 10 ) {
            playerCard1Value = 10;
        }

        if (playerCard2Value > 10 ) {
            playerCard2Value = 10;
        }

        if (playerCard3Value > 10 ) {
            playerCard3Value = 10;
        }

        totalToGuess = (playerCard1Value + playerCard2Value + playerCard3Value);

        return totalToGuess;

    }
}
