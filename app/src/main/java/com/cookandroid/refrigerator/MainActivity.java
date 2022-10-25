package com.cookandroid.refrigerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageButton btnRecipy;
    Switch btnIce;                               //레시피 , 냉장버튼
    boolean isItCool = true;                      //냉동|냉장 구분
    List<Food> foodlist = new LinkedList<Food>();    //링크드 리스트 선언
    String name;
    String storagy;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecipy = (ImageButton)findViewById(R.id.btnRecipy);
        btnIce = (Switch) findViewById(R.id.btnIce);

        IceFragment fragice = new IceFragment();
        CoolFragment fragcool = new CoolFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, fragice);
        fragmentTransaction.addToBackStack("fragice");
        fragmentTransaction.commit();


        date = "2022-10-10";
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
        btnIce.setText("냉장 ");
        Bundle data = new Bundle();
        data.putString("Check", "noice");

        CoolFragment fragCool = new CoolFragment();
        fragCool.setArguments(data);

        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction2.replace(R.id.frame_layout, fragCool);
        fragmentTransaction2.commit();


        btnIce.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //냉동
                    btnIce.setText("냉동 ");
                    Bundle data = new Bundle();
                    data.putString("Check", "ice");

                    IceFragment fragIce = new IceFragment();
                    fragIce.setArguments(data);

                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_layout, fragIce);
                    fragmentTransaction1.commit();
                }
                else{
                    //냉장
                    btnIce.setText("냉장 ");
                    Bundle data = new Bundle();
                    data.putString("Check", "noice");

                    CoolFragment fragCool = new CoolFragment();
                    fragCool.setArguments(data);

                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame_layout, fragCool);
                    fragmentTransaction2.commit();
                }
            }
        });

        /*
        btnIce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isItCool){

                    //냉장실 출력
                    isItCool = false;
                    //fragment 출력
                    Bundle data = new Bundle();
                    data.putString("Check", "noice");

                    CoolFragment fragCool = new CoolFragment();
                    fragCool.setArguments(data);

                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frame_layout, fragCool);
                    fragmentTransaction2.commit();

                }
                else{
                    //냉동실 출력
                    isItCool = true;

                    //fragment 출력

                    //데이터 이동 수단
                    Bundle data = new Bundle();
                    data.putString("Check", "ice");

                    IceFragment fragIce = new IceFragment();
                    fragIce.setArguments(data);

                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_layout, fragIce);
                    fragmentTransaction1.commit();

                }

            }
        });

         */


    }

}