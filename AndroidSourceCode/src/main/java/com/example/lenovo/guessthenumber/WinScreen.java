package com.example.lenovo.guessthenumber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class WinScreen extends Activity {

    TextView numberOfGuessess;
    int counterOfGuessess = 0;

    TextView score1, score2, score3, score4, score5;
    TextView user1, user2, user3, user4, user5;
    int score1Value, score2Value, score3Value, score4Value, score5Value;
    String user1Value, user2Value, user3Value, user4Value, user5Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winscreen);
        counterOfGuessess = getIntent().getIntExtra("counterOfGuessess", -1);
        numberOfGuessess = (TextView) findViewById(R.id.numberOfGuessess);
        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);
        score3 = (TextView) findViewById(R.id.score3);
        score4 = (TextView) findViewById(R.id.score4);
        score5 = (TextView) findViewById(R.id.score5);

        user1 = (TextView) findViewById(R.id.user1);
        user2 = (TextView) findViewById(R.id.user2);
        user3 = (TextView) findViewById(R.id.user3);
        user4 = (TextView) findViewById(R.id.user4);
        user5 = (TextView) findViewById(R.id.user5);

        score1Value = getIntent().getIntExtra("score1", -1);
        score2Value = getIntent().getIntExtra("score2", -1);
        score3Value = getIntent().getIntExtra("score3", -1);
        score4Value = getIntent().getIntExtra("score4", -1);
        score5Value = getIntent().getIntExtra("score5", -1);

        user1Value = getIntent().getStringExtra("user1");
        user2Value = getIntent().getStringExtra("user2");
        user3Value = getIntent().getStringExtra("user3");
        user4Value = getIntent().getStringExtra("user4");
        user5Value = getIntent().getStringExtra("user5");

        user1.setText(user1Value);
        user2.setText(user2Value);
        user3.setText(user3Value);
        user4.setText(user4Value);
        user5.setText(user5Value);


        score1.setText(Integer.toString(score1Value));
        score2.setText(Integer.toString(score2Value));
        score3.setText(Integer.toString(score3Value));
        score4.setText(Integer.toString(score4Value));
        score5.setText(Integer.toString(score5Value));

        numberOfGuessess.setText(Integer.toString(counterOfGuessess));


    }
}
