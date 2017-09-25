package com.example.simonanger.cardgames;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CardCountActivity extends AppCompatActivity {

    CardCountGame game;

    Deck deck;
    PlayingDealer dealer;
    Player player;

    ImageView cardOne;
    ImageView cardTwo;
    ImageView cardThree;

    TextView cardOneTextViewUp;
    TextView cardOneTextViewDown;
    TextView cardTwoTextViewUp;
    TextView cardTwoTextViewDown;
    TextView cardThreeTextViewUp;
    TextView cardThreeTextViewDown;
    TextView cardCountResult;

    Button cardCountBeginButton;
    Button answerButton;

    EditText answerText;

    int result;
    int finalAnswer;

    long animationDuration = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_count);

        deck = new Deck();
        deck.generate();
        dealer = new PlayingDealer(deck);
        player = new Player("Classic Harrison");
        game = new CardCountGame(deck, dealer, player);
        result = 0;

        cardOne = (ImageView) findViewById(R.id.cardCountFirstCardImage);
        cardTwo = (ImageView) findViewById(R.id.cardCountSecondCardImage);
        cardThree = (ImageView) findViewById(R.id.cardCountThirdCardImage);

        cardOneTextViewUp = (TextView) findViewById(R.id.cardCountFirstCardRankViewUp);
        cardOneTextViewDown = (TextView) findViewById(R.id.cardCountFirstCardRankViewDown);
        cardTwoTextViewUp = (TextView) findViewById(R.id.cardCountSecondCardRankViewUp);
        cardTwoTextViewDown = (TextView) findViewById(R.id.cardCountSecondCardRankViewDown);
        cardThreeTextViewUp = (TextView) findViewById(R.id.cardCountThirdCardRankViewUp);
        cardThreeTextViewDown = (TextView) findViewById(R.id.cardCountThirdCardRankViewDown);

        cardCountBeginButton = (Button) findViewById(R.id.cardCountBegin);
        answerButton = (Button) findViewById(R.id.answerButton);

        answerText = (EditText) findViewById(R.id.cardCountAnswerTextBox);
        cardCountResult = (TextView) findViewById(R.id.cardCountResult);
        answerButton.setVisibility(View.GONE);


        ObjectAnimator animatorX = ObjectAnimator.ofFloat(cardOne, "x", 100f);
        animatorX.setDuration(animationDuration);

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(cardOne, "y", 300f);
        animatorY.setDuration(animationDuration);

        ObjectAnimator alphaAnimation = ObjectAnimator
                .ofFloat(cardOne, View.ALPHA, 1.0f, 0.0f );
        alphaAnimation.setDuration(animationDuration);

        ObjectAnimator rotateAnimation = ObjectAnimator
                .ofFloat(cardOne, "rotation", 0f, 360f );
        rotateAnimation.setDuration(animationDuration);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX, rotateAnimation);
        animatorSet.start();


        ObjectAnimator animatorX2 = ObjectAnimator.ofFloat(cardTwo, "x", 400f);
        animatorX2.setDuration(animationDuration);

        ObjectAnimator animatorY2 = ObjectAnimator.ofFloat(cardTwo, "y", 300f);
        animatorY2.setDuration(animationDuration);

        ObjectAnimator alphaAnimation2 = ObjectAnimator
                .ofFloat(cardTwo, View.ALPHA, 1.0f, 0.0f );
        alphaAnimation2.setDuration(animationDuration);

        ObjectAnimator rotateAnimation2 = ObjectAnimator
                .ofFloat(cardTwo, "rotation", 0f, 360f );
        rotateAnimation2.setDuration(animationDuration);

        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animatorX2, rotateAnimation2);
        animatorSet2.start();



        ObjectAnimator animatorX3 = ObjectAnimator.ofFloat(cardThree, "x", 700f);
        animatorX3.setDuration(animationDuration);

        ObjectAnimator animatorY3 = ObjectAnimator.ofFloat(cardThree, "y", 300f);
        animatorY3.setDuration(animationDuration);

        ObjectAnimator alphaAnimation3 = ObjectAnimator
                .ofFloat(cardThree, View.ALPHA, 1.0f, 0.0f );
        alphaAnimation3.setDuration(animationDuration);

        ObjectAnimator rotateAnimation3 = ObjectAnimator
                .ofFloat(cardThree, "rotation", 0f, 360f );
        rotateAnimation3.setDuration(animationDuration);


        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(animatorX3, rotateAnimation3);
        animatorSet3.start();

    }

    public void onCardCountButtonClicked(View Button) throws InterruptedException {

        player.emptyHand();

        result = game.draw();

        switch (player.revealSingleCard(0).getSuit()) {
            case SPADES:
                cardOne.setImageResource(R.drawable.spades);
                break;
            case CLUBS:
                cardOne.setImageResource(R.drawable.clubs);
                break;
            case DIAMONDS:
                cardOne.setImageResource(R.drawable.diamonds);
                break;
            case HEARTS:
                cardOne.setImageResource(R.drawable.hearts);
                break;
        }

        switch (player.revealSingleCard(1).getSuit()) {
            case SPADES:
                cardTwo.setImageResource(R.drawable.spades);
                break;
            case CLUBS:
                cardTwo.setImageResource(R.drawable.clubs);
                break;
            case DIAMONDS:
                cardTwo.setImageResource(R.drawable.diamonds);
                break;
            case HEARTS:
                cardTwo.setImageResource(R.drawable.hearts);
                break;
        }

        switch (player.revealSingleCard(2).getSuit()) {
            case SPADES:
                cardThree.setImageResource(R.drawable.spades);
                break;
            case CLUBS:
                cardThree.setImageResource(R.drawable.clubs);
                break;
            case DIAMONDS:
                cardThree.setImageResource(R.drawable.diamonds);
                break;
            case HEARTS:
                cardThree.setImageResource(R.drawable.hearts);
                break;
        }

        if (player.revealSingleCard(0).getRankNumerically() == 1) {
            cardOneTextViewUp.setText("A");
            cardOneTextViewDown.setText("A");
        }
        else if (player.revealSingleCard(0).getRankNumerically() == 11) {
            cardOneTextViewUp.setText("J");
            cardOneTextViewDown.setText("J");
        }
        else if (player.revealSingleCard(0).getRankNumerically() == 12) {
            cardOneTextViewUp.setText("Q");
            cardOneTextViewDown.setText("Q");
        }
        else if (player.revealSingleCard(0).getRankNumerically() == 13) {
            cardOneTextViewUp.setText("K");
            cardOneTextViewDown.setText("K");
        }
        else {
            cardOneTextViewUp.setText(String.valueOf(player.revealSingleCard(0).getRankNumerically()));
            cardOneTextViewDown.setText(String.valueOf(player.revealSingleCard(0).getRankNumerically()));
        }

        if (player.revealSingleCard(1).getRankNumerically() == 1) {
            cardTwoTextViewUp.setText("A");
            cardTwoTextViewDown.setText("A");
        }
        else if (player.revealSingleCard(1).getRankNumerically() == 11) {
            cardTwoTextViewUp.setText("J");
            cardTwoTextViewDown.setText("J");
        }
        else if (player.revealSingleCard(1).getRankNumerically() == 12) {
            cardTwoTextViewUp.setText("Q");
            cardTwoTextViewDown.setText("Q");
        }
        else if (player.revealSingleCard(1).getRankNumerically() == 13) {
            cardTwoTextViewUp.setText("K");
            cardTwoTextViewDown.setText("K");
        }
        else {
            cardTwoTextViewUp.setText(String.valueOf(player.revealSingleCard(1).getRankNumerically()));
            cardTwoTextViewDown.setText(String.valueOf(player.revealSingleCard(1).getRankNumerically()));
        }

        if (player.revealSingleCard(2).getRankNumerically() == 1) {
            cardThreeTextViewUp.setText("A");
            cardThreeTextViewDown.setText("A");
        }
        else if (player.revealSingleCard(2).getRankNumerically() == 11) {
            cardThreeTextViewUp.setText("J");
            cardThreeTextViewDown.setText("J");
        }
        else if (player.revealSingleCard(2).getRankNumerically() == 12) {
            cardThreeTextViewUp.setText("Q");
            cardThreeTextViewDown.setText("Q");
        }
        else if (player.revealSingleCard(2).getRankNumerically() == 13) {
            cardThreeTextViewUp.setText("K");
            cardThreeTextViewDown.setText("K");
        }
        else {
            cardThreeTextViewUp.setText(String.valueOf(player.revealSingleCard(2).getRankNumerically()));
            cardThreeTextViewDown.setText(String.valueOf(player.revealSingleCard(2).getRankNumerically()));
        }

        Handler h=new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
            cardOneTextViewUp.setText("");
            cardOneTextViewDown.setText("");
            cardTwoTextViewUp.setText("");
            cardTwoTextViewDown.setText("");
            cardThreeTextViewUp.setText("");
            cardThreeTextViewDown.setText("");
            }
        }, 2000);

        deck.generate();

        answerButton.setVisibility(View.VISIBLE);

    }

    public void onAnswerButtonClicked(View Button) {
        if (answerText.getText().toString().length() == 0) {
            cardCountResult.setText("Please provide an answer or draw again.");
        }

        else {

            String answer = answerText.getText().toString();
            finalAnswer = Integer.parseInt(answer);

            if (result == finalAnswer) {
                cardCountResult.setText("You are correct! Draw again?");
                answerText.setText("");
                answerButton.setVisibility(View.GONE);

            }

            if (result != finalAnswer) {
                cardCountResult.setText("You are incorrect! Try again?");
            }
        }
    }



}
