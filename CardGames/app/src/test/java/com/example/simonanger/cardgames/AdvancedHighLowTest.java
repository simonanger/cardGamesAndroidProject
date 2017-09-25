package com.example.simonanger.cardgames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simonanger on 25/09/2017.
 */
public class AdvancedHighLowTest {
    Deck deck;
    PlayingDealer dealer;
    Player player;
    AdvancedHighLow game;


    @Before
    public void before() {
        deck = new Deck();
        deck.generate();
        dealer = new PlayingDealer(deck);
        player = new Player("Classic Harrison");
        game = new AdvancedHighLow(deck, dealer, player);
    }
    @Test
    public void draw() {
        game.draw();
        assertEquals(1, player.getHand().size());

    }

    @Test
    public void assess() {
        assertEquals(false, game.playersChoice);
    }

}