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

    TextView recipy_name, recipy_summary, recipy_need, recipy_recipy;
    ImageView recipy_image;
    YouTubePlayerView recipy_video;
    String name;
    String summary;
    String need;
    String recipy;
    String video;
    int image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailrecipy);

        recipy_image = (ImageView)findViewById(R.id.recipy_image);
        recipy_name = (TextView)findViewById(R.id.recipy_name);
        recipy_summary = (TextView)findViewById(R.id.recipy_summary);
        recipy_need = (TextView)findViewById(R.id.recipy_need);
        recipy_recipy = (TextView)findViewById(R.id.recipy_recipy);
        recipy_video = (YouTubePlayerView)findViewById(R.id.recipy_video);

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();

        name = extras.getString("Name");
        summary = extras.getString("Summary");
        need = extras.getString("Need");
        recipy = extras.getString("Recipy");

        recipy_name.setText(name);
        recipy_summary.setText(summary);
        recipy_need.setText(need);
        recipy_recipy.setText(recipy);

        image = R.drawable.apple;

        recipy_image.setImageResource(image);
        video = "qWbHSOplcvY";
        //동영상 주소 변경 구현 필요

    }
}