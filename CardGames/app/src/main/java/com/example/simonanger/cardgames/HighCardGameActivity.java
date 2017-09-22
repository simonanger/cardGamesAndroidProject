package com.example.simonanger.cardgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HighCardGameActivity extends AppCompatActivity {

    HighCardGame game;
    Deck deck;
    HighCardDealer dealer;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_card_game);

//        game = new HighCardGame(deck, dealer, player);
    }
}
