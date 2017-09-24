package com.example.simonanger.cardgames;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HighCardGameActivity extends AppCompatActivity {

    HighCardGame game;

    Deck deck;
    HighCardDealer dealer;
    Player player;

    TextView playersCardText;
    TextView dealersCardText;
    TextView resultTextView;
    TextView playerCardRankTextViewUp;
    TextView playerCardRankTextViewDown;
    TextView dealerCardRankTextViewUp;
    TextView dealerCardRankTextViewDown;

    ImageView playersCardImage;
    ImageView dealersCardImage;

    Button highCardDrawButton;
    Button resetDeckButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_card_game);

        deck = new Deck();
        deck.generate();
        dealer = new HighCardDealer(deck);
        player = new Player("Classic Harrison");
        game = new HighCardGame(deck, dealer, player);

        playersCardText = (TextView)findViewById(R.id.playersCardText);
        dealersCardText = (TextView) findViewById(R.id.dealersCardText);

        resultTextView = (TextView) findViewById(R.id.resultTextView);

        playerCardRankTextViewUp = (TextView) findViewById(R.id.playerCardRankTextViewUp);
        playerCardRankTextViewDown = (TextView) findViewById(R.id.playerCardRankTextViewDown);
        dealerCardRankTextViewUp = (TextView) findViewById(R.id.dealerCardRankTextViewUp);
        dealerCardRankTextViewDown = (TextView) findViewById(R.id.dealerCardRankTextViewDown);

        playersCardImage = (ImageView) findViewById(R.id.playersCardImage);
        dealersCardImage = (ImageView) findViewById(R.id.dealersCardImage);

        highCardDrawButton = (Button) findViewById(R.id.highCardDrawButton);
        resetDeckButton = (Button) findViewById(R.id.resetDeckButton);


    }

    public void onHighCardDrawButtonClicked (View Button) {
        if (deck.getCards().size() == 0) {
            resultTextView.setText("The deck is now empty, press the reset button to reshuffle.");
        }
        else {
            int result = game.play();

            String winnerMessage;

            switch (result) {
                case 0:
                    winnerMessage = "Error";
                    break;
                case 1:
                    winnerMessage = "You win!";
                    break;
                case 2:
                    winnerMessage = "Dealer wins! Better luck next time.";
                    break;
                default:
                    winnerMessage = "Error";
            }

            String playerCardSuit = player.revealSingleCard(0).getSuit().toString().toLowerCase();
            String playerCardRank = player.revealSingleCard(0).getRank().toString().toLowerCase();

            String dealerCardSuit = dealer.revealSingleCard(0).getSuit().toString().toLowerCase();
            String dealerCardRank = dealer.revealSingleCard(0).getRank().toString().toLowerCase();

            String resultMessage = "You had the " + playerCardRank + " of " + playerCardSuit
                    + ". \n The dealer had the " + dealerCardRank + " of " + dealerCardSuit + ". \n"
                    + winnerMessage;

            resultTextView.setText(resultMessage);

            switch (player.revealSingleCard(0).getSuit()) {
                case SPADES:
                    playersCardImage.setImageResource(R.drawable.spades);
                    break;
                case CLUBS:
                    playersCardImage.setImageResource(R.drawable.clubs);
                    break;
                case DIAMONDS:
                    playersCardImage.setImageResource(R.drawable.diamonds);
                    break;
                case HEARTS:
                    playersCardImage.setImageResource(R.drawable.hearts);
                    break;
            }

            switch (dealer.revealSingleCard(0).getSuit()) {
                case SPADES:
                    dealersCardImage.setImageResource(R.drawable.spades);
                    break;
                case CLUBS:
                    dealersCardImage.setImageResource(R.drawable.clubs);
                    break;
                case DIAMONDS:
                    dealersCardImage.setImageResource(R.drawable.diamonds);
                    break;
                case HEARTS:
                    dealersCardImage.setImageResource(R.drawable.hearts);
                    break;
            }

            if (player.revealSingleCard(0).getRankNumerically() == 1) {
                playerCardRankTextViewUp.setText("A");
                playerCardRankTextViewDown.setText("A");
            }
            else if (player.revealSingleCard(0).getRankNumerically() == 11) {
                playerCardRankTextViewUp.setText("J");
                playerCardRankTextViewDown.setText("J");
            }
            else if (player.revealSingleCard(0).getRankNumerically() == 12) {
                playerCardRankTextViewUp.setText("Q");
                playerCardRankTextViewDown.setText("Q");
            }
            else if (player.revealSingleCard(0).getRankNumerically() == 13) {
                playerCardRankTextViewUp.setText("K");
                playerCardRankTextViewDown.setText("K");
            }
            else {
                playerCardRankTextViewUp.setText(String.valueOf(player.revealSingleCard(0).getRankNumerically()));
                playerCardRankTextViewDown.setText(String.valueOf(player.revealSingleCard(0).getRankNumerically()));
            }

            if (dealer.revealSingleCard(0).getRankNumerically() == 1) {
                dealerCardRankTextViewUp.setText("A");
                dealerCardRankTextViewDown.setText("A");
            }
            else if (dealer.revealSingleCard(0).getRankNumerically() == 11) {
                dealerCardRankTextViewUp.setText("J");
                dealerCardRankTextViewDown.setText("J");
            }
            else if (dealer.revealSingleCard(0).getRankNumerically() == 12) {
                dealerCardRankTextViewUp.setText("Q");
                dealerCardRankTextViewDown.setText("Q");
            }
            else if (dealer.revealSingleCard(0).getRankNumerically() == 13) {
                dealerCardRankTextViewUp.setText("K");
                dealerCardRankTextViewDown.setText("K");
            }
            else {
                dealerCardRankTextViewUp.setText(String.valueOf(dealer.revealSingleCard(0).getRankNumerically()));
                dealerCardRankTextViewDown.setText(String.valueOf(dealer.revealSingleCard(0).getRankNumerically()));
            }

            player.emptyHand();
            dealer.emptyHand();
        }
    }

    public void onResetDeckButtonClicked (View button) {
        deck.generate();
    }
}

//
//
//        String resultMessage = "You played " + playerHand.name().toLowerCase() + "!\n"
//        + "Computer played " + computerHand.name().toLowerCase() + "!\n"
//        + winnerMessage;
//
//
//
//        resultText.setText(resultMessage);