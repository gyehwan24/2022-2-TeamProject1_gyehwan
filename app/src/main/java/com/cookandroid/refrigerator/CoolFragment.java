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

public class CoolFragment extends Fragment {

    //context controll
    Context ct;
    String check;

    //그리드 뷰
    Integer[] ImageID = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6,
            R.drawable.img5, R.drawable.img5, R.drawable.img5,
            R.drawable.img5, R.drawable.img5, R.drawable.img5,
            R.drawable.img5, R.drawable.img5, R.drawable.img5,
            R.drawable.img5, R.drawable.img5, R.drawable.img5,
            R.drawable.img5, R.drawable.img5, R.drawable.img5,
            R.drawable.img5, R.drawable.img5, R.drawable.img5,
            R.drawable.img5, R.drawable.img5, R.drawable.img5,
            R.drawable.img5, R.drawable.img5, R.drawable.img5,
            R.drawable.img5, R.drawable.img5, R.drawable.img5,
            R.drawable.img5, R.drawable.img5, R.drawable.img5
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Bundle data = getArguments();
        if( data != null ){
            check = data.getString("Check");
        }
        else{
            check = "none";
        }

        //그리드 뷰


    }

    //gridview
    public class MyGridAdapter extends BaseAdapter{
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }
        public int getCount(){
            return ImageID.length;
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

            imageview.setImageResource(ImageID[position]);
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), DetailFood.class);
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
        MyGridAdapter gAdapter = new MyGridAdapter(getActivity());
        gv.setAdapter(gAdapter);


        return v;
    }
}
