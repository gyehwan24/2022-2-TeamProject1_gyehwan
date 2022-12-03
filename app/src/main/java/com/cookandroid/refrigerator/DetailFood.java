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
    int point;


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

        image = extras.getInt("Image");
        name = extras.getString("Name");
        date = "유통기한 : "+ extras.getString("Date");
        storagy = "<보관방법>\n\n" + extras.getString("Storagy");

        //point 값에 위치 저장 ->다시 main activity 에 전달하여 리스트 수정
        point = extras.getInt("Point");

        food_image.setImageResource(image);
        food_name.setText(name);
        food_date.setText(date);
        food_storagy.setText(storagy);
        //데이터 입력 못받으면 avd오류
        /*
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
        */
    }
}
