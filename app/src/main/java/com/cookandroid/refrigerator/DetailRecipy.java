package com.cookandroid.refrigerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailRecipy extends Activity {

    TextView food_name, food_summary, food_need, food_recipy;
    ImageView food_image;
    YouTubePlayerView food_video;
    String name;
    String summary;
    String need;
    String recipy;
    String video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailrecipy);

        food_image = (ImageView)findViewById(R.id.food_image);
        food_name = (TextView)findViewById(R.id.food_name);
        food_summary = (TextView)findViewById(R.id.food_summary);
        food_need = (TextView)findViewById(R.id.food_need);
        food_recipy = (TextView)findViewById(R.id.food_recipy);
        food_video = (YouTubePlayerView)findViewById(R.id.food_video);

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();

        name = extras.getString("Name");
        summary = extras.getString("Summary");
        need = extras.getString("Need");
        recipy = extras.getString("Recipy");

        food_name.setText(name);
        food_summary.setText(summary);
        food_need.setText(need);
        food_recipy.setText(recipy);




    }
}