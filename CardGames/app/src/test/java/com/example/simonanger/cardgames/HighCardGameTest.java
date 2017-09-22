package com.example.simonanger.cardgames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simonanger on 22/09/2017.
 */
public class HighCardGameTest {
    HighCardGame highCardGame;
    Deck deck;
    HighCardDealer highCardDealer;
    Player player;


    @Before
    public void before() {
        deck = new Deck();
        deck.generate();
        highCardDealer = new HighCardDealer(deck);
        player = new Player("Classic Harrison");
        highCardGame = new HighCardGame(deck, highCardDealer, player);
    }

    // This tests if the game method works as random, ran multiple times to see if the random works.
//    @Test
//    public void testGamesPlays() {
//        assertEquals(0, highCardGame.play());
//    }

}