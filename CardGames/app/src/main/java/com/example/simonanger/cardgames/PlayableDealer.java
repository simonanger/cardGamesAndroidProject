package com.example.simonanger.cardgames;

import java.util.ArrayList;

/**
 * Created by simonanger on 24/09/2017.
 */

public interface PlayableDealer {

    Card deal();

    ArrayList getHand();

    void getCard(Card card);

    void loseCard(Card card);

    void emptyHand();

    Card revealSingleCard(int num);
}
