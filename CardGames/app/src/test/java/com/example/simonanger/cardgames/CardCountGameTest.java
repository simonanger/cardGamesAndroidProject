package com.example.simonanger.cardgames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simonanger on 24/09/2017.
 */
public class CardCountGameTest {
    CardCountGame cardCountGame;
    Deck deck;
    PlayingDealer dealer;
    Player player;


    @Before
    public void before() {
        deck = new Deck();
        deck.generate();
        dealer = new PlayingDealer(deck);
        player = new Player("Classic Harrison");
        cardCountGame = new CardCountGame(deck, dealer, player);
    }
    @Test
    public void draw() {
        cardCountGame.draw();
        assertEquals(3, player.getHand().size());
    }

}