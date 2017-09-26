package com.example.simonanger.cardgames;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
    TextView cardCountRules;

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

        cardOne = (ImageView) findViewById(R.id.cardCount1);
        cardTwo = (ImageView) findViewById(R.id.cardCount2);
        cardThree = (ImageView) findViewById(R.id.cardCount3);

        cardOneTextViewUp = (TextView) findViewById(R.id.cardCountUp1);
        cardOneTextViewDown = (TextView) findViewById(R.id.cardCountDown1);
        cardTwoTextViewUp = (TextView) findViewById(R.id.cardCountUp2);
        cardTwoTextViewDown = (TextView) findViewById(R.id.cardCountDown2);
        cardThreeTextViewUp = (TextView) findViewById(R.id.cardCountUp3);
        cardThreeTextViewDown = (TextView) findViewById(R.id.cardCountDown3);

        cardCountBeginButton = (Button) findViewById(R.id.cardCountBegin);
        answerButton = (Button) findViewById(R.id.answerButton);

        answerText = (EditText) findViewById(R.id.cardCountAnswerTextBox);
        cardCountResult = (TextView) findViewById(R.id.cardCountResult);
        answerButton.setVisibility(View.GONE);

        cardCountRules = (TextView) findViewById(R.id.cardCountRules);
        Typeface fontMedium = Typeface.createFromAsset(this.getAssets(), "fonts/opensans.ttf");
        cardCountRules.setTypeface(fontMedium);


        ObjectAnimator animatorX = ObjectAnimator.ofFloat(cardOne, "translationX", -400f, 0);
        animatorX.setDuration(animationDuration);

        ObjectAnimator alphaAnimation = ObjectAnimator
                .ofFloat(cardOne, View.ALPHA, 1.0f, 0.0f );
        alphaAnimation.setDuration(animationDuration);

        ObjectAnimator rotateAnimation = ObjectAnimator
                .ofFloat(cardOne, "rotation", 0f, 360f );
        rotateAnimation.setDuration(animationDuration);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX, rotateAnimation);
        animatorSet.start();


        ObjectAnimator animatorX2 = ObjectAnimator.ofFloat(cardTwo, "translationX", -400f, 0);
        animatorX2.setDuration(animationDuration);

        ObjectAnimator alphaAnimation2 = ObjectAnimator
                .ofFloat(cardTwo, View.ALPHA, 1.0f, 0.0f );
        alphaAnimation2.setDuration(animationDuration);

        ObjectAnimator rotateAnimation2 = ObjectAnimator
                .ofFloat(cardTwo, "rotation", 0f, 360f );
        rotateAnimation2.setDuration(animationDuration);

        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(animatorX2, rotateAnimation2);
        animatorSet2.start();



        ObjectAnimator animatorX3 = ObjectAnimator.ofFloat(cardThree, "translationX", -400f, 0);
        animatorX3.setDuration(animationDuration);

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

    public void onCardCountButtonClicked(View button) throws InterruptedException {

        cardCountResult.setText("");

        player.emptyHand();

        result = game.draw();

        for (int i = 0; i < player.getHand().size(); i++ ){
            String currentCardSuit = player.getHand().get(i).getSuit().toString().toLowerCase();
            int cardImageResource = getResources().getIdentifier(currentCardSuit, "drawable", getPackageName());
            String currentCardImageResourceName = "cardCount" + String.valueOf(i + 1);
            int cardImageViewId = getResources().getIdentifier(currentCardImageResourceName, "id", getPackageName());
            ImageView currentCardImageView = (ImageView) findViewById(cardImageViewId);
            currentCardImageView.setImageResource(cardImageResource);
        }

        for (int i = 0; i < player.getHand().size(); i++ ){
            int currentCardRank = player.getHand().get(i).getRankNumerically();
            String currentCardTextResourceNameUp = "cardCountUp" + String.valueOf(i + 1);
            String currentCardTextResourceNameDown = "cardCountDown" + String.valueOf(i + 1);
            int cardTextViewIdUp = getResources().getIdentifier(currentCardTextResourceNameUp, "id", getPackageName());
            int cardTextViewIdDown = getResources().getIdentifier(currentCardTextResourceNameDown, "id", getPackageName());
            TextView currentCardTextViewUp = (TextView) findViewById(cardTextViewIdUp);
            TextView currentCardTextViewDown = (TextView) findViewById(cardTextViewIdDown);
            currentCardTextViewUp.setText(String.valueOf(currentCardRank));
            currentCardTextViewDown.setText(String.valueOf(currentCardRank));

            if (player.revealSingleCard(i).getRankNumerically() == 1) {
                currentCardTextViewUp.setText("A");
                currentCardTextViewDown.setText("A");
            }
            else if (player.revealSingleCard(i).getRankNumerically() == 11) {
                currentCardTextViewUp.setText("J");
                currentCardTextViewDown.setText("J");
            }
            else if (player.revealSingleCard(i).getRankNumerically() == 12) {
                currentCardTextViewUp.setText("Q");
                currentCardTextViewDown.setText("Q");
            }
            else if (player.revealSingleCard(i).getRankNumerically() == 13) {
                currentCardTextViewUp.setText("K");
                currentCardTextViewDown.setText("K");
            }
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
