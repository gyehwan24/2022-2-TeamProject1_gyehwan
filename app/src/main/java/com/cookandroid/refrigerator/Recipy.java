package com.cookandroid.refrigerator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Recipy extends Activity {

    Button Recent, Korea, China, West, Japan, Boon, Etc;
    View.OnClickListener clickListener;
    Integer[] btn = { R.id.btnkorea, R.id.btnchina, R.id.btnwest, R.id.btnjapan, R.id.btnboon, R.id.btnetc};

    ListView list;
    ListAdapter adapter;

    String name;
    String summary;
    String need;
    String recipy;
    int i = 0;
    List<RecipyInfo> recipylist = new LinkedList<RecipyInfo>();  //링크드 리스트 선언




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipy);

        Recent = (Button)findViewById(R.id.btnrecent);
        Korea = (Button)findViewById(R.id.btnkorea);
        China = (Button)findViewById(R.id.btnchina);
        West = (Button)findViewById(R.id.btnwest);
        Japan = (Button)findViewById(R.id.btnjapan);
        Boon = (Button)findViewById(R.id.btnboon);
        Etc = (Button)findViewById(R.id.btnetc);
        list = (ListView)findViewById(R.id.listview);

        name = "음식 이름";
        summary = "음식 간단 설명";
        need = "필요 조미료";
        recipy = "레시피\n" +
                "ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ";

        //동적 추가 위한 리스트 -> 메인 리스트와 타입 맞춘 후  메인 리스트에 추가
        /*
        final ArrayList<String> midlist = new ArrayList<String>();
        final String[] item = {" item"," item"," item"," item"," item"," item"," item"," item"," item"," item"," item"," item"," item"," item"," item",};


         */
        adapter = new ListAdapter();
        //adapter 에 리스트 추가 <-밑의 버튼 리스너에 각각 지정 (어떤 객체를 지정할지는 미리 설정)
        adapter.addItem(new ListItem(R.drawable.apple, "음식이름"));
        adapter.addItem(new ListItem(R.drawable.apple, "음식이름"));
        adapter.addItem(new ListItem(R.drawable.apple, "음식이름"));
        adapter.addItem(new ListItem(R.drawable.apple, "음식이름"));

        list.setAdapter(adapter);
        /*
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, item);
        list.setAdapter(adapter);
         */
        //리스트 동적 추가
        /*midlist.add(type);
          adapter.notifyDataSetChanged(); //반영
         */
        //리스트 동적 삭제
        /*
        클릭 리스너로 position(int) 값 가져옴
        midlist.remove(position);
        adapter.notifyDataSetChanged();
         */

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailRecipy.class);
                intent.putExtra("Name", name);
                intent.putExtra("Summary", summary);
                intent.putExtra("Need", need);
                intent.putExtra("Recipy", recipy);
                startActivity(intent);
            }
        });





        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnkorea:
                        //code
                        West.setBackgroundResource(R.drawable.button);
                        China.setBackgroundResource(R.drawable.button);
                        Japan.setBackgroundResource(R.drawable.button);
                        Boon.setBackgroundResource(R.drawable.button);
                        Etc.setBackgroundResource(R.drawable.button);
                        Korea.setBackgroundResource(R.drawable.button_push);

                        //list 변경 (flagment?)
                        break;
                    case R.id.btnchina:
                        //code
                        West.setBackgroundResource(R.drawable.button);
                        China.setBackgroundResource(R.drawable.button_push);
                        Japan.setBackgroundResource(R.drawable.button);
                        Boon.setBackgroundResource(R.drawable.button);
                        Etc.setBackgroundResource(R.drawable.button);
                        Korea.setBackgroundResource(R.drawable.button);
                        break;
                    case R.id.btnwest:
                        //code
                        West.setBackgroundResource(R.drawable.button_push);
                        China.setBackgroundResource(R.drawable.button);
                        Japan.setBackgroundResource(R.drawable.button);
                        Boon.setBackgroundResource(R.drawable.button);
                        Etc.setBackgroundResource(R.drawable.button);
                        Korea.setBackgroundResource(R.drawable.button);
                        break;
                    case R.id.btnjapan:
                        //code
                        West.setBackgroundResource(R.drawable.button);
                        China.setBackgroundResource(R.drawable.button);
                        Japan.setBackgroundResource(R.drawable.button_push);
                        Boon.setBackgroundResource(R.drawable.button);
                        Etc.setBackgroundResource(R.drawable.button);
                        Korea.setBackgroundResource(R.drawable.button);
                        break;
                    case R.id.btnboon:
                        //code
                        West.setBackgroundResource(R.drawable.button);
                        China.setBackgroundResource(R.drawable.button);
                        Japan.setBackgroundResource(R.drawable.button);
                        Boon.setBackgroundResource(R.drawable.button_push);
                        Etc.setBackgroundResource(R.drawable.button);
                        Korea.setBackgroundResource(R.drawable.button);
                        break;
                    case R.id.btnetc:
                        //code
                        West.setBackgroundResource(R.drawable.button);
                        China.setBackgroundResource(R.drawable.button);
                        Japan.setBackgroundResource(R.drawable.button);
                        Boon.setBackgroundResource(R.drawable.button);
                        Etc.setBackgroundResource(R.drawable.button_push);
                        Korea.setBackgroundResource(R.drawable.button);
                        break;
                }
            }
        };

        Korea.setOnClickListener(clickListener);
        West.setOnClickListener(clickListener);
        China.setOnClickListener(clickListener);
        Japan.setOnClickListener(clickListener);
        Boon.setOnClickListener(clickListener);
        Etc.setOnClickListener(clickListener);


        //list 전체 레시피 생성 후 종류따라 setvisible로

        //list btn 넣어야 할 기능
        /*
        btnDetail.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailRecipy.class);
                intent.putExtra("Name", name);
                intent.putExtra("Summary", summary);
                intent.putExtra("Need", need);
                intent.putExtra("Recipy", recipy);
                startActivity(intent);
            }

        });
         */
    }
}
