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

        int result = game.play();

        String winnerMessage;

        switch (result) {
            case 0:
                winnerMessage = "Error"; break;
            case 1:
                winnerMessage = "You win!"; break;
            case 2:
                winnerMessage = "Dealer wins! Better luck next time"; break;
            default:
                winnerMessage = "Error";
        }

//        Log.d("this", String.valueOf(player.revealSingleCard().getRankNumerically()));

        String resultMessage = "Unbelievably " + winnerMessage;

        resultTextView.setText(resultMessage);

        if (deck.getCards().size() == 0) {
            resultTextView.setText("The deck is now empty, press the reset button to reshuffle");
        }

        switch (player.revealSingleCard().getSuit()) {
            case SPADES:
                playersCardImage.setImageResource(R.drawable.spades); break;
            case CLUBS:
                playersCardImage.setImageResource(R.drawable.clubs); break;
            case DIAMONDS:
                playersCardImage.setImageResource(R.drawable.diamonds); break;
            case HEARTS:
                playersCardImage.setImageResource(R.drawable.hearts); break;
        }

        switch (dealer.revealSingleCard().getSuit()) {
            case SPADES:
                dealersCardImage.setImageResource(R.drawable.spades); break;
            case CLUBS:
                dealersCardImage.setImageResource(R.drawable.clubs); break;
            case DIAMONDS:
                dealersCardImage.setImageResource(R.drawable.diamonds); break;
            case HEARTS:
                dealersCardImage.setImageResource(R.drawable.hearts); break;
        }

        switch (player.revealSingleCard().getRankNumerically()){
            case 1:
                playerCardRankTextViewUp.setText("A"); break;
            case 11:
                playerCardRankTextViewUp.setText("J"); break;
            case 12:
                playerCardRankTextViewUp.setText("Q"); break;
            case 13:
                playerCardRankTextViewUp.setText("K"); break;
            default:
                playerCardRankTextViewUp.setText(String.valueOf(player.revealSingleCard().getRankNumerically()));
        }

        switch (player.revealSingleCard().getRankNumerically()){
            case 1:
                playerCardRankTextViewDown.setText("A"); break;
            case 11:
                playerCardRankTextViewDown.setText("J"); break;
            case 12:
                playerCardRankTextViewDown.setText("Q"); break;
            case 13:
                playerCardRankTextViewDown.setText("K"); break;
            default:
                playerCardRankTextViewDown.setText(String.valueOf(player.revealSingleCard().getRankNumerically()));
        }

        switch (dealer.revealSingleCard().getRankNumerically()){
            case 1:
                dealerCardRankTextViewUp.setText("A"); break;
            case 11:
                dealerCardRankTextViewUp.setText("J"); break;
            case 12:
                dealerCardRankTextViewUp.setText("Q"); break;
            case 13:
                dealerCardRankTextViewUp.setText("K"); break;
            default:
                dealerCardRankTextViewUp.setText(String.valueOf(dealer.revealSingleCard().getRankNumerically()));
        }

        switch (dealer.revealSingleCard().getRankNumerically()){
            case 1:
                dealerCardRankTextViewDown.setText("A"); break;
            case 11:
                dealerCardRankTextViewDown.setText("J"); break;
            case 12:
                dealerCardRankTextViewDown.setText("Q"); break;
            case 13:
                dealerCardRankTextViewDown.setText("K"); break;
            default:
                dealerCardRankTextViewDown.setText(String.valueOf(dealer.revealSingleCard().getRankNumerically()));
        }

        player.emptyHand();
        dealer.emptyHand();
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