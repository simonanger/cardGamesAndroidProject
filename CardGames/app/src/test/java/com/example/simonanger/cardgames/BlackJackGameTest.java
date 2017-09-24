package com.example.simonanger.cardgames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simonanger on 24/09/2017.
 */
public class BlackJackGameTest {

    BlackJackGame blackJackGame;
    Deck deck;
    PlayingDealer dealer;
    Player player;

    @Before
    public void before() {
        deck = new Deck();
        deck.generate();
        dealer = new PlayingDealer(deck);
        player = new Player("Classic Harrison");
        blackJackGame = new BlackJackGame(deck, dealer, player);
    }

    @Test
    public void testGamePlays() {
        blackJackGame.draw();
        assertEquals(2, player.hand.size());
    }

    @Test
    public void testPlayerCardValueStartsZero() {
        assertEquals(0, blackJackGame.getPlayerCardValue());
    }

    @Test
    public void testDealerCardValueStartsZero() {
        assertEquals(0, blackJackGame.getDealerCardValue());
    }

    @Test
    public void testPlayerTwist() {
        blackJackGame.draw();
        blackJackGame.playerTwist();
        assertEquals(3, player.getHand().size());
    }

//    This tests that the less than 17 method works
//    @Test
//    public void testDealerHandLessThan17() {
//        blackJackGame.draw();
//        blackJackGame.dealersHandLessThan17();
//        assertEquals(0, blackJackGame.getDealerCardValue());
//    }

    // This tests that the assess method will return a winner

//    @Test
//    public void testAssess() {
//        blackJackGame.draw();
//        blackJackGame.playerTwist();
//        blackJackGame.dealersHandLessThan17();
//        assertEquals(0, blackJackGame.assess());
//    }

}