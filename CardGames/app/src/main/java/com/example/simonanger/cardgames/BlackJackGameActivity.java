package com.example.simonanger.cardgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BlackJackGameActivity extends AppCompatActivity {

    BlackJackGame game;

    Deck deck;
    PlayingDealer dealer;
    Player player;

    Button blackJackDrawButton;

    TextView playerCardValueText;
    TextView dealerCardValueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack_game);

        deck = new Deck();
        deck.generate();
        dealer = new PlayingDealer(deck);
        player = new Player("Classic Harrison");
        game = new BlackJackGame(deck, dealer, player);

        blackJackDrawButton = (Button) findViewById(R.id.blackjackDrawButton);

        playerCardValueText = (TextView) findViewById(R.id.blackJackPlayerScoreTextView);
        dealerCardValueText = (TextView) findViewById(R.id.blackJackDealerScoreTextView);
    }

    public void onBlackJackDrawButtonClicked (View Button) {
        player.emptyHand();
        game.playerCardValue = 0;
        dealer.emptyHand();
        game.dealerCardValue = 0;

        if (deck.getCards().size() == 0) {
//            playerCardValueText.setText("The deck is now empty, press the reset button to reshuffle.");
        } else {
            int result = game.draw();

            playerCardValueText.setText("Your card total is " + result
                    + ". \n What would you like to do?");
            dealerCardValueText.setText("Dealers first card is "
                    + dealer.revealSingleCard(0).getRankNumerically() + ".");

        }
    }
}
