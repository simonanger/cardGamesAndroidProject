package com.example.simonanger.cardgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ActivityTest extends AppCompatActivity {

    PlayingDealer dealer;
    Player player;
    Deck deck;




    HighCardGame game;

    Button runbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        deck = new Deck();
        deck.generate();
        dealer = new PlayingDealer(deck);
        player = new Player("Classic Harrison");
        game = new HighCardGame(deck, dealer, player);
    }
}
