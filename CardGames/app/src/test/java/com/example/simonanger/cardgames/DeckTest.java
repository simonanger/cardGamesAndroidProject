package com.example.simonanger.cardgames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simonanger on 22/09/2017.
 */
public class DeckTest {

    Deck deck;
    Card card;

    @Before
    public void before() {
        deck = new Deck();
        card = new Card(Suit.CLUBS, Rank.NINE);
    }

    @Test
    public void testDeckStartsEmpty() {
        assertEquals(0, deck.getCards().size());
    }

    @Test
    public void testAddCard() {
        deck.addCard(card);
        assertEquals(1, deck.getCards().size());

    }

    @Test
    public void testRemoveCard() {
        deck.addCard(card);
        deck.removeCard(card);
        assertEquals(0, deck.getCards().size());
    }

    @Test
    public void testDeckGenerate() {
        deck.generate();
        assertEquals(52, deck.getCards().size());
    }

}