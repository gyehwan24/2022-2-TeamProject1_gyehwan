package com.cookandroid.refrigerator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailRecipy extends Activity {

    TextView recipy_name, recipy_need, recipy_recipy;
    ImageView recipy_image;
    ImageView recipy_video;
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
        recipy_need = (TextView)findViewById(R.id.recipy_need);
        recipy_recipy = (TextView)findViewById(R.id.recipy_recipy);
        recipy_video = (ImageView) findViewById(R.id.recipy_video);

        Intent rxIntent = getIntent();
        Bundle extras = rxIntent.getExtras();
        RecipyInfo recipyInfo;

        recipyInfo = (RecipyInfo) rxIntent.getSerializableExtra("Object");

        //need data -> image, name, need, recipy, youtube url
        /*
        name = extras.getString("Name");
        need = extras.getString("Need");
        recipy = extras.getString("Recipy");
        image = extras.getInt("Image");
        //video = extras.getString("Video");


         */
        name = recipyInfo.getName() ;
        recipy = recipyInfo.getDesc();
        image = recipyInfo.getPicture();
        need = "";

        recipy_name.setText(name);
        recipy_recipy.setText(recipy);
        recipy_need.setText(need);
        recipy_image.setImageResource(image);
        recipy_video.setImageResource(R.drawable.youtube);

        video = "https://youtube.com/watch?v=qWbHSOplcvY";
        String youtuberesource = "qWbHSOplcvY";
        String videoimage = "https://img.youtube.com/vi/"+youtuberesource+"/0.jpg";
        String videopath = "https://youtube.com/watch?v=" + youtuberesource;

        //동영상 주소 변경 구현 필요

        recipy_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse(video)).setPackage("com.google.android.youtube"));
            }
        });
        //유튜브 링크
        /*
        startActivity(new Intent(Intent.ACTION_VIEW)
            .setData(Uri.parse("youtube_url"))
            .setPackage("com.google.android.youtube"));
         */

    }
}
