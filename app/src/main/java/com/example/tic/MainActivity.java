package com.example.tic;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    Button button;
    TextView textView;
    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean activePlay = true;
    public void drop (View v){
        Button button = findViewById(R.id.button2);
        ImageView counter = (ImageView) v;
        Log.i("Tag ", counter.getTag().toString());
        TextView textView = findViewById(R.id.textView);
        int counterTag = Integer.parseInt(counter.getTag().toString());
        if(gamestate[counterTag] ==2 && activePlay){
            counter.setTranslationY(1500);
            gamestate[counterTag] = player;
        if(player == 0){
            counter.setImageResource(R.drawable.coin1);
            player =1;
        }else{
            counter.setImageResource(R.drawable.coin2);
            player = 0;
        }counter.animate().alpha(1).translationYBy(-1500).rotation(3600).setDuration(1000);
        }else if(activePlay){
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show();
        }
        else{
            String a;
            if(player ==0){
                a = "gelb";}
            else
                a ="black";
            Toast.makeText(this, "The game is over, won " + a, Toast.LENGTH_SHORT).show();
        }
        for (int winsPositions[] :winPositions){
        if(gamestate[winsPositions[0]]==gamestate[winsPositions[1]]&&gamestate[winsPositions[1]]==gamestate[winsPositions[2]]&&gamestate[winsPositions[0]]!=2&&activePlay) {
            System.out.println("");
            String winner = "";
            if (player == 1) {
                winner = "black";
            } else if (player == 0) {
                winner = "gelb";
            }
            Toast.makeText(this, "The winner is " + winner, Toast.LENGTH_SHORT).show();
            textView.setVisibility(View.VISIBLE);
            textView.setText("Winner: " + winner);
            activePlay = false;
            button.animate().alpha(1);
        }
        }


    }
    public void newGame(View v) {
        ImageView img1 = findViewById(R.id.imageView1);
        img1.setImageResource(0);
        ImageView img2 = findViewById(R.id.imageView2);
        img2.setImageResource(0);
        ImageView img3 = findViewById(R.id.imageView3);
        img3.setImageResource(0);
        ImageView img4 = findViewById(R.id.imageView4);
        img4.setImageResource(0);
        ImageView img5 = findViewById(R.id.imageView5);
        img5.setImageResource(0);
        ImageView img6 = findViewById(R.id.imageView6);
        img6.setImageResource(0);
        ImageView img7 = findViewById(R.id.imageView7);
        img7.setImageResource(0);
        ImageView img8 = findViewById(R.id.imageView8);
        img1.setImageResource(0);
        ImageView img9 = findViewById(R.id.imageView9);
        img9.setImageResource(0);
        activePlay = true;
        textView.setVisibility(View.INVISIBLE);
        button.animate().alpha(0);
        for(int i =0 ; i <9 ; i ++){
            gamestate[i]=2;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);
        button.animate().alpha(0);

    }
}