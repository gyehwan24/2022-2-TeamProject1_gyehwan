package com.cookandroid.refrigerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailFood extends Activity {

    TextView food_name, food_date, food_storagy;
    ImageView food_image;
    String name;
    String date;
    String storagy;
    int image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailfood);

        food_image = (ImageView)findViewById(R.id.food_image);
        food_name = (TextView)findViewById(R.id.food_name);
        food_date = (TextView)findViewById(R.id.food_date);
        food_storagy = (TextView)findViewById(R.id.food_storagy);

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();

        name = extras.getString("Name");
        date = extras.getString("Date");
        storagy = extras.getString("Storagy");
        image = R.drawable.apple;

        food_name.setText(name);
        food_date.setText(date);
        food_storagy.setText(storagy);
        food_image.setImageResource(image);

    }
}
