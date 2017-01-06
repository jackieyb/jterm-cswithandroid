package com.jterm.jaby.scarne;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Random mRandom;

    private int user_overallscore;
    private int user_turnscore;
    private int comp_overallscore;
    private int comp_turnscore;

    private boolean IsUsersTurn = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Roll button
        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsUsersTurn) {
                    roll();
                }
            }
        }
                //Hold button
                findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mIsUsersTurn) {
                            roll();
                        }
                    }
                }
                        //Reset button
                        findViewById(R.id.b3).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                reset
                            }

    }
    protected void Reset(){
        user_turnscore=0;
        user_overallscore=0;
        comp_turnscore=0;
        comp_overallscore=0;
        updateLabelText()
    }
    protected void updateLabelText(){
    }
    protected void computerTurn(){
        b1.setEnabled=false;
    })
}
    )
    protected void RollLogic(int value) {
        if (value == 1) {
            user_turnscore = 0;
            comp_turnscore = 0;
        }
        if (IsUsersTurn) {
            user_turnscore += value;
        } else {
            comp_turnscore += value;
        }
    }

}
