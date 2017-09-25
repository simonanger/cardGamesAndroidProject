package com.example.simonanger.cardgames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void onHighCardButtonClicked(View Button) {
        Intent intent = new Intent(this, AdvancedHighLowActivity.class);
        startActivity(intent);
    }

    public void onCardCountButtonClicked(View Button) {
        Intent intent = new Intent(this, CardCountActivity.class);
        startActivity(intent);
    }

//    public void onAdvancedHLClicked(View button) {
//        Intent intent = new Intent(this, AdvancedHighLowActivity.class);
//        startActivity(intent);
//    }
}
