package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random RAND = new Random();
    private Button higher,lower;
    private ImageView imageView1,imageView2;
    private TextView val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        higher = (Button) findViewById(R.id.button1);
        lower = (Button) findViewById(R.id.button2);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        val = (TextView) findViewById(R.id.textView);

        higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = random();
                int value2 = random();
                int result1 = getResources().getIdentifier("dice" +value1,"drawable", "com.example.dicegame");
                int result2 = getResources().getIdentifier("dice" +value2,"drawable", "com.example.dicegame");
                imageView1.setImageResource(result1);
                imageView2.setImageResource(result2);
                if(value1>value2){
                    val.setText("User Win");
                }
                else if(value1<value2){
                    val.setText("Computer Win");
                }
                else{
                    val.setText("Its a tie");
                }
            }
        });

        lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = random();
                int value2 = random();
                int result1 = getResources().getIdentifier("dice" +value1,"drawable", "com.example.dicegame");
                int result2 = getResources().getIdentifier("dice" +value2,"drawable", "com.example.dicegame");
                imageView1.setImageResource(result1);
                imageView2.setImageResource(result2);
                if(value1<value2){
                    val.setText("User Win");
                }
                else if(value1>value2){
                    val.setText("Computer Win");
                }
                else{
                    val.setText("Its a tie");
                }
            }
        });
    }
    public static int random(){
        return RAND.nextInt(6) + 1;
    }
}