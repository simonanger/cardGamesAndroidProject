package com.example.simonanger.cardgames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simonanger on 22/09/2017.
 */
public class HighCardDealerTest {
    HighCardDealer highCardDealer;
    Deck deck;
    Player player;
    Card card1;
    Card card2;

    @Before
    public void before() {
        deck = new Deck();
        card1 = new Card (Suit.CLUBS, Rank.SEVEN);
        card2 = new Card (Suit.SPADES, Rank.NINE);
        deck.addCard(card1);
        deck.addCard(card2);
        highCardDealer = new HighCardDealer(deck);
        player = new Player("Classic Harrison");
    }

    @Test
    public void deal() {
        Card randomCard = highCardDealer.deal();
        player.getCard(randomCard);
        assertEquals(1, player.getHand().size() );
//        assertEquals(Rank.SEVEN, randomCard.getRank()); test to see if random - it is!

    }

    @Test
    public void testHandStartsEmpty() {
        assertEquals(0, highCardDealer.getHand().size());
    }

    @Test
    public void testGetCard() {
        highCardDealer.getCard(card1);
        assertEquals(1, highCardDealer.getHand().size());
    }

    @Test
    public void testLoseCard() {
        highCardDealer.getCard(card1);
        highCardDealer.loseCard(card1);
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void testEmptyHand() {
        highCardDealer.getCard(card1);
        highCardDealer.getCard(card2);
        highCardDealer.emptyHand();
        assertEquals(0, highCardDealer.getHand().size());
    }

    @Test
    public void testRevealSingleCard() {
        highCardDealer.getCard(card1);
        Card singleCard = highCardDealer.revealSingleCard(0);
        assertEquals(Rank.SEVEN, singleCard.getRank());
    }


}