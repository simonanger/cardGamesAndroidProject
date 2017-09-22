package com.example.simonanger.cardgames;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simonanger on 22/09/2017.
 */
public class PlayerTest {
    Player player;
    Card card1;
    Card card2;

    @Before
    public void before() {
        player = new Player("Classic Harrison");
        card1 = new Card(Suit.CLUBS, Rank.FIVE);
        card2 = new Card(Suit.DIAMONDS, Rank.FOUR);
    }

    @Test
    public void testGetName() {
        assertEquals("Classic Harrison", player.getName());
    }

    @Test
    public void testHandStartsEmpty() {
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void testGetCard() {
        player.getCard(card1);
        assertEquals(1, player.getHand().size());
    }

    @Test
    public void testLoseCard() {
        player.getCard(card1);
        player.loseCard(card1);
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void testEmptyHand() {
        player.getCard(card1);
        player.getCard(card2);
        player.emptyHand();
        assertEquals(0, player.getHand().size());
    }

    @Test
    public void testRevealSingleCard() {
        player.getCard(card1);
        Card singleCard = player.revealSingleCard();
        assertEquals(Rank.FIVE, singleCard.getRank());
    }


}