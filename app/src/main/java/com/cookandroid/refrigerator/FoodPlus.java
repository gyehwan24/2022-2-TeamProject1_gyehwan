package com.cookandroid.refrigerator;

import static android.content.Intent.getIntent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FoodPlus extends Fragment {

    EditText edtname, edtessyear, edtessmonth, edtessday, edtinpyear, edtinpmonth, edtinpday;
    Button btnadd;
    String inputdate = "";
    String expdate = "";
    String name = "";
    FragmentPlusListener listener;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentPlusListener){
            listener = (FragmentPlusListener) context;
        }
        else{
            //오류
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.food_plus, container, false);

        edtname = v.findViewById(R.id.edtfoodname);
        edtessyear = v.findViewById(R.id.edtexpyear);
        edtessmonth = v.findViewById(R.id.edtexpmonth);
        edtessday = v.findViewById(R.id.edtexpday);
        edtinpyear = v.findViewById(R.id.edtinyear);
        edtinpmonth = v.findViewById(R.id.edtinmonth);
        edtinpday = v.findViewById(R.id.edtinday);
        btnadd = v.findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = String.valueOf(edtname.getText());
                inputdate = edtinpyear.getText() +"-"+edtinpmonth.getText() +"-" + edtinpday.getText();
                expdate = edtessyear.getText() +"-"+edtessmonth.getText() +"-" + edtessday.getText();

                //food 생성 후 activity 에 전송
                Food food = new Food(name, expdate, inputdate, 0, "보관법", R.drawable.apple);
                listener.onInputSend(food);

                //finish(); <- 액티비티 종료
            }
        });

        //food 생성 후 activity 에 전송


        /*
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);

        intent.putExtra("Foodplus", food);
        setResult(RESULT_OK, intent);

        startActivityForResult(intent, 0);


         */

        return v;
    }

    public interface FragmentPlusListener{
        void onInputSend(Food input);
    }
}
