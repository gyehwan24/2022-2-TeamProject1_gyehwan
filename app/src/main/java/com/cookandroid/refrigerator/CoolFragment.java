package com.cookandroid.refrigerator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class CoolFragment extends Fragment {

    //context controll
    Context ct;

    ArrayList<Food> foodArrayList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    //gridview
    public class MyGridAdapter extends BaseAdapter{
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }
        public int getCount(){
            return foodArrayList.toArray().length;
        }
        public Object getItem(int arg0){
            return null;
        }
        public long getItemId(int arg0){
            return 0;
        }
        public View getView(int position, View arg1, ViewGroup arg2){
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);

            imageview.setImageResource(foodArrayList.get(position).getImage());
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), DetailFood.class);
                    //imageID[position] -> Foodlist[position].getPicture getName ...
                    intent.putExtra("Image", foodArrayList.get(position).getImage());
                    intent.putExtra("Name", foodArrayList.get(position).getName());
                    intent.putExtra("Date", foodArrayList.get(position).getExpiration_date());
                    intent.putExtra("Storagy", foodArrayList.get(position).getStorage());
                    startActivity(intent);
                }
            });



            return imageview;
        }
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cool_fragment, container, false);

        //gridview, context
        final GridView gv = (GridView) v.findViewById(R.id.gridViewCool);
        ct = container.getContext();

        Bundle data = getArguments();
        if( data != null ){
            foodArrayList = data.getParcelableArrayList("Food");
        }
        else{
        }


        MyGridAdapter gAdapter = new MyGridAdapter(getActivity());
        gv.setAdapter(gAdapter);


        return v;
    }
}
