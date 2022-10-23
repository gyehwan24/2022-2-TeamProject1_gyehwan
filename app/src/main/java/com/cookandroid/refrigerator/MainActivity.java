package com.cookandroid.refrigerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnRecipy, btnIce, btnFood;       //레시피 , 냉장버튼
    boolean isItIce = false;        //냉동|냉장 구분
    List<Food> foodlist = new LinkedList<Food>();  //링크드 리스트 선언
    String name;
    String storagy;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecipy = (Button)findViewById(R.id.btnRecipy);
        btnIce = (Button)findViewById(R.id.btnIce);
        btnFood = (Button)findViewById(R.id.btnFood);


        date = "2022 - 10 - 10";
        name ="김치";
        storagy = "보관법 : 1 어쩌구 2 저쩌구";


        //레시피 버튼 기능 구현
        btnRecipy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Recipy.class);
                startActivity(intent);
            }
        });

        //냉장버튼 기능 구현
        btnIce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isItIce){
                    //냉동실 출력
                    isItIce = false;

                    //fragment 출력


                }
                else{
                    //냉장실 출력
                    isItIce = true;
                    //fragment 출력


                }

            }
        });

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), DetailFood.class);
                intent2.putExtra("Name", name);
                intent2.putExtra("Date", date);
                intent2.putExtra("Storagy", storagy);
                startActivity(intent2);
            }
        });

    }

}