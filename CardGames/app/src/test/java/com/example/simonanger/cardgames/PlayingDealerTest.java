package com.example.simonanger.cardgames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simonanger on 22/09/2017.
 */
public class PlayingDealerTest {
    PlayingDealer playingDealer;
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
        playingDealer = new PlayingDealer(deck);
        player = new Player("Classic Harrison");
    }

    @Test
    public void deal() {
        Card randomCard = playingDealer.deal();
        player.getCard(randomCard);
        assertEquals(1, player.getHand().size() );
//        assertEquals(Rank.SEVEN, randomCard.getRank()); test to see if random - it is!

    }

    @Test
    public void testHandStartsEmpty() {
        assertEquals(0, playingDealer.getHand().size());
    }

    @Test
    public void testGetCard() {
        playingDealer.getCard(card1);
        assertEquals(1, playingDealer.getHand().size());
    }

    @Test
    public void testLoseCard() {
        playingDealer.getCard(card1);
        playingDealer.loseCard(card1);
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void testEmptyHand() {
        playingDealer.getCard(card1);
        playingDealer.getCard(card2);
        playingDealer.emptyHand();
        assertEquals(0, playingDealer.getHand().size());
    }

    @Test
    public void testRevealSingleCard() {
        playingDealer.getCard(card1);
        Card singleCard = playingDealer.revealSingleCard(0);
        assertEquals(Rank.SEVEN, singleCard.getRank());
    }


}