package com.example.simonanger.cardgames;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdvancedHighLowActivity extends AppCompatActivity {
    AdvancedHighLow game;

    Deck deck;
    PlayingDealer dealer;
    Player player;

    Button advancedHLDealButton;
    Button higherButton;
    Button lowerButton;
    Button rageButton;

    TextView highOrLow;
    TextView dealerText;
    TextView playerCardTextUp;
    TextView playerCardTextDown;
    TextView dealerCardTextUp;
    TextView dealerCardTextDown;
    TextView highLowScoreCount;

    ImageView playersCardImage;
    ImageView dealersCardImage;

    long animationDuration = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_high_low);

        deck = new Deck();
        deck.generate();
        dealer = new PlayingDealer(deck);
        player = new Player("Classic Harrison");
        game = new AdvancedHighLow(deck, dealer, player);

        advancedHLDealButton = (Button) findViewById(R.id.advancedHLButton);

        highOrLow = (TextView) findViewById(R.id.highOrLowTV);

        higherButton = (Button) findViewById(R.id.aHLHigherButton);
        higherButton.setVisibility(View.GONE);

        lowerButton = (Button) findViewById(R.id.aHLLowerButton);
        lowerButton.setVisibility(View.GONE);

        dealerText = (TextView) findViewById(R.id.dealerText);

        playersCardImage = (ImageView) findViewById(R.id.playersCardImage);

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(playersCardImage, "translationX", -400f, 0);
        animatorX.setDuration(animationDuration);

        ObjectAnimator alphaAnimation = ObjectAnimator
                .ofFloat(playersCardImage, View.ALPHA, 1.0f, 0.0f );
        alphaAnimation.setDuration(animationDuration);

        ObjectAnimator rotateAnimation = ObjectAnimator
                .ofFloat(playersCardImage, "rotation", 0f, 360f );
        rotateAnimation.setDuration(animationDuration);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX, rotateAnimation);
        animatorSet.start();


        dealersCardImage = (ImageView) findViewById(R.id.dealersCardImage);

        ObjectAnimator animatorX2 = ObjectAnimator.ofFloat(dealersCardImage, "translationX", 400f, 0);
        animatorX2.setDuration(animationDuration);

        ObjectAnimator alphaAnimation2 = ObjectAnimator
                .ofFloat(dealersCardImage, View.ALPHA, 1.0f, 0.0f );
        alphaAnimation2.setDuration(animationDuration);

        ObjectAnimator rotateAnimation2 = ObjectAnimator
                .ofFloat(dealersCardImage, "rotation", 0f, 360f );
        rotateAnimation2.setDuration(animationDuration);


        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animatorX2, rotateAnimation2);
        animatorSet2.start();

        playerCardTextUp = (TextView) findViewById(R.id.playerCardTextUp);
        playerCardTextDown = (TextView) findViewById(R.id.playerCardTextDown);
        dealerCardTextUp = (TextView) findViewById(R.id.dealerCardTextUp);
        dealerCardTextDown = (TextView) findViewById(R.id.dealerCardTextDown);

        rageButton = (Button) findViewById(R.id.rageButton);

        highLowScoreCount = (TextView) findViewById(R.id.highLowScoreCount);

    }

    public void onAdvancedHLClicked(View button) {

        dealerText.setText("");
        dealersCardImage.setImageResource(R.drawable.cardback);

        game.draw();

        String playerCardSuit = player.revealSingleCard(0).getSuit().toString().toLowerCase();
        String playerCardRank = player.revealSingleCard(0).getRank().toString().toLowerCase();


        String resultMessage = "You have the " + playerCardRank + " of " + playerCardSuit
                + ". \n Will your card be higher or lower?";

        highOrLow.setText(resultMessage);

        playersCardImage = (ImageView) findViewById(R.id.playersCardImage);
        String playersCardSuit = game.player.getHand().get(0).getSuitString();
        int playersCardSuitId = getResources().getIdentifier(playersCardSuit, "drawable", getPackageName());
        playersCardImage.setImageResource((playersCardSuitId));


        if (player.revealSingleCard(0).getRankNumerically() == 1) {
            playerCardTextUp.setText("A");
            playerCardTextDown.setText("A");
        }
        else if (player.revealSingleCard(0).getRankNumerically() == 11) {
            playerCardTextUp.setText("J");
            playerCardTextDown.setText("J");
        }
        else if (player.revealSingleCard(0).getRankNumerically() == 12) {
            playerCardTextUp.setText("Q");
            playerCardTextDown.setText("Q");
        }
        else if (player.revealSingleCard(0).getRankNumerically() == 13) {
            playerCardTextUp.setText("K");
            playerCardTextDown.setText("K");
        }
        else {
            playerCardTextUp.setText(String.valueOf(player.revealSingleCard(0).getRankNumerically()));
            playerCardTextDown.setText(String.valueOf(player.revealSingleCard(0).getRankNumerically()));
        }

        higherButton.setVisibility(View.VISIBLE);
        lowerButton.setVisibility(View.VISIBLE);

    }

    public void onDecisionButtonClicked(View button) {
        if (button.getId() == R.id.aHLHigherButton) {
            game.playersChoice = true;
        }
        else if (button.getId() == R.id.aHLLowerButton) {
            game.playersChoice = false;
        }


        int result = game.assess();

        String winnerMessage;

        switch (result) {
            case 0:
                winnerMessage = "Error";
                break;
            case 1:
                winnerMessage = "You're right. You win!";
                break;
            case 2:
                winnerMessage = "Better luck next time!";
                break;
            default:
                winnerMessage = "Error";
        }

        dealersCardImage = (ImageView) findViewById(R.id.dealersCardImage);
        String dealersCardSuit = game.dealer.revealSingleCard(0).getSuitString();
        int dealersCardSuitId = getResources().getIdentifier(dealersCardSuit, "drawable", getPackageName());
        dealersCardImage.setImageResource((dealersCardSuitId));


        if (dealer.revealSingleCard(0).getRankNumerically() == 1) {
            dealerCardTextUp.setText("A");
            dealerCardTextDown.setText("A");
        }
        else if (dealer.revealSingleCard(0).getRankNumerically() == 11) {
            dealerCardTextUp.setText("J");
            dealerCardTextDown.setText("J");
        }
        else if (dealer.revealSingleCard(0).getRankNumerically() == 12) {
            dealerCardTextUp.setText("Q");
            dealerCardTextDown.setText("Q");
        }
        else if (dealer.revealSingleCard(0).getRankNumerically() == 13) {
            dealerCardTextUp.setText("K");
            dealerCardTextDown.setText("K");
        }
        else {
            dealerCardTextUp.setText(String.valueOf(dealer.revealSingleCard(0).getRankNumerically()));
            dealerCardTextDown.setText(String.valueOf(dealer.revealSingleCard(0).getRankNumerically()));
        }

        String dealerCardSuit = dealer.revealSingleCard(0).getSuit().toString().toLowerCase();
        String dealerCardRank = dealer.revealSingleCard(0).getRank().toString().toLowerCase();


        String dealersInfo = "The dealer had the " + dealerCardRank + " of " + dealerCardSuit +".";

        dealerText.setText(dealersInfo);

        highOrLow.setText(winnerMessage);

        higherButton.setVisibility(View.GONE);
        lowerButton.setVisibility(View.GONE);

        highLowScoreCount.setText(String.valueOf(game.playersPoints));

        player.emptyHand();
        dealer.emptyHand();
    }

    public void onRageButtonClicked(View button) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.scream);
        mp.start();
    }
}
