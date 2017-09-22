package com.example.simonanger.cardgames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simonanger on 22/09/2017.
 */
public class CardTest {
    Suit suit;
    Rank rank;
    Card card;


    @Before
    public void before() {
        card = new Card(Suit.CLUBS, Rank.EIGHT);
    }

    @Test
    public void testGetSuit() {
        assertEquals(Suit.CLUBS, card.getSuit());
    }

    @Test
    public void testGetRank() {
        assertEquals(Rank.EIGHT, card.getRank() );
    }

    @Test
    public void testGetRankNumerically() {
        assertEquals(8, card.getRankNumerically());
    }

}