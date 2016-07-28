package com.fuzzproductions.ratingbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fuzzproductions.ratingbar.RatingBar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.justsometext);

        final RatingBar bar = (RatingBar) findViewById(R.id.rating_bar);
        if(bar != null) {
            bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if(textView != null) {
                        textView.setText(
                                String.format(
                                        "Currently selected: %s isFromUser: %s",
                                        rating,
                                        fromUser
                                )

                        );
                    }
                }
            });
        }

        View b = findViewById(R.id.random_starSize);
        if(b != null) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Random r = new Random(System.currentTimeMillis());
                    if(bar != null) {
                        bar.setStarSizeInDp(r.nextInt(100));
                    }

                }
            });
        }

        b = findViewById(R.id.random_starCount);
        if(b != null){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Random r = new Random(System.currentTimeMillis());
                    if(bar != null) {
                        bar.setMax(r.nextInt(10));
                    }

                }
            });
        }
    }
}
