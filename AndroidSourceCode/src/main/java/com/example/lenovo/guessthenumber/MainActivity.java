package com.example.lenovo.guessthenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    EditText answer, userName;
    Button newGame, guess;
    TextView result;
    int counterOfGuessess = 0;
    int randomNumber;
    Random r = new Random();
    SharedPreferences scores;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        answer = (EditText) findViewById(R.id.answer);
        newGame = (Button) findViewById(R.id.newGame);
        guess = (Button) findViewById(R.id.guess);
        result = (TextView) findViewById(R.id.result);
        scores = getSharedPreferences("scores", Context.MODE_PRIVATE);
        userName = (EditText) findViewById(R.id.userName);

        editor = scores.edit();




        for (int i = 1; i <= 5; i++) {
            int tmp = scores.getInt(""+i, Integer.MAX_VALUE);
            if(tmp == Integer.MAX_VALUE){
                editor.putInt(""+i, Integer.MAX_VALUE);
                editor.putString("user"+i, "");
            }
        }

//        editor.putString("user1", "");
//        editor.putString("user2", "");
//        editor.putString("user3", "");
//        editor.putString("user4", "");
//        editor.putString("user5", "");

        editor.apply();


//        int tmp = scores.getInt("1",Integer.MAX_VALUE);


        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber = (r.nextInt(100)+1);
                result.setText("");
            }
        });

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answerInt = Integer.parseInt(answer.getText().toString());
                if(answerInt > randomNumber){
                    result.setText("Za duzo");
                    counterOfGuessess++;
                }
                if(answerInt < randomNumber){
                    result.setText("Za malo");
                    counterOfGuessess++;
                }

                if(answerInt == randomNumber){
                    counterOfGuessess++;

                    for (int i = 1; i <= 5; i++) {
                        int tmp = scores.getInt(""+i,Integer.MAX_VALUE);
                        if(counterOfGuessess < tmp){
                            editor.putInt(""+i, counterOfGuessess);
                            editor.putString("user"+i, userName.getText().toString());
                            editor.apply();
                            for (int j = 5; j > i; j--) {
                                editor.putInt(""+j,scores.getInt(""+(j-1), -1));
                                editor.putString("user"+j, scores.getString("user"+(j-1), ""));
                            }
                            break;
                        }
                    }

                    Intent intent = new Intent(getApplicationContext(), WinScreen.class);
                    intent.putExtra("counterOfGuessess",counterOfGuessess);
                    for (int i = 1; i <= 5; i++) {
                        intent.putExtra("score"+i, scores.getInt(""+i, Integer.MAX_VALUE));
                        intent.putExtra("user"+i, scores.getString("user"+i, ""));
                    }
                    startActivity(intent);
                    //finish();
                    counterOfGuessess = 0;

                }
            }
        });


    }
}
