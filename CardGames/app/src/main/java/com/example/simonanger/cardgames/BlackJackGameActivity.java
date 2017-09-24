package com.example.simonanger.cardgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BlackJackGameActivity extends AppCompatActivity {

    BlackJackGame game;

    Deck deck;
    PlayingDealer dealer;
    Player player;

    Button blackJackDrawButton;
    Button twistButton;

    TextView playerCardValueText;
    TextView dealerCardValueText;

    ImageView playersFirstCardImage;
    ImageView playersSecondCardImage;
    ImageView playersThirdCardImage;
    ImageView playersFourthCardImage;
    ImageView dealersFirstCardImage;
    ImageView dealersSecondCardImage;
    ImageView dealersThirdCardImage;
    ImageView dealersFourthCardImage;

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
        twistButton = (Button) findViewById(R.id.twistButton);

        playerCardValueText = (TextView) findViewById(R.id.blackJackPlayerScoreTextView);
        dealerCardValueText = (TextView) findViewById(R.id.blackJackDealerScoreTextView);

        playersFirstCardImage = (ImageView) findViewById(R.id.blackJackPlayersFirstCardImage);
        playersSecondCardImage = (ImageView) findViewById(R.id.blackJackPlayersSecondCardImage);


        dealersFirstCardImage = (ImageView) findViewById(R.id.blackJackDealersFirstCardImage);
        dealersSecondCardImage = (ImageView) findViewById(R.id.blackJackDealersSecondCardImage);
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

        switch (player.revealSingleCard(0).getSuit()) {
            case SPADES:
                playersFirstCardImage.setImageResource(R.drawable.spades);
                break;
            case CLUBS:
                playersFirstCardImage.setImageResource(R.drawable.clubs);
                break;
            case DIAMONDS:
                playersFirstCardImage.setImageResource(R.drawable.diamonds);
                break;
            case HEARTS:
                playersFirstCardImage.setImageResource(R.drawable.hearts);
                break;
        }

        switch (player.revealSingleCard(1).getSuit()) {
            case SPADES:
                playersSecondCardImage.setImageResource(R.drawable.spades);
                break;
            case CLUBS:
                playersSecondCardImage.setImageResource(R.drawable.clubs);
                break;
            case DIAMONDS:
                playersSecondCardImage.setImageResource(R.drawable.diamonds);
                break;
            case HEARTS:
                playersSecondCardImage.setImageResource(R.drawable.hearts);
                break;
        }

        switch (dealer.revealSingleCard(0).getSuit()) {
            case SPADES:
                dealersFirstCardImage.setImageResource(R.drawable.spades);
                break;
            case CLUBS:
                dealersFirstCardImage.setImageResource(R.drawable.clubs);
                break;
            case DIAMONDS:
                dealersFirstCardImage.setImageResource(R.drawable.diamonds);
                break;
            case HEARTS:
                dealersFirstCardImage.setImageResource(R.drawable.hearts);
                break;
        }

    }

    public void onTwistButtonClicked (View Button) {

        playersThirdCardImage = (ImageView) findViewById(R.id.blackJackPlayersThirdCardImage);
        playersFourthCardImage = (ImageView) findViewById(R.id.blackJackPlayersFourthCardImage);

        if (game.playerCardValue >= 21) {
            playerCardValueText.setText("You are bust. Press deal to start again.");
        }
        else {
            game.playerTwist();
            playerCardValueText.setText("Your card total is " + game.playerCardValue
                    + ". \n What would you like to do?");
        }
    }

    public void onStickButtonClicked (View Button) {
        game.dealersHandLessThan17();

        int result = game.assess();

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

        playerCardValueText.setText(winnerMessage);
        if (game.dealerCardValue > 21) {
            dealerCardValueText.setText("The dealer has "
                    + game.dealerCardValue + ". The dealer is bust!");
        }
        else {
            dealerCardValueText.setText("The dealer has "
                    + game.dealerCardValue);
        }
    }
}