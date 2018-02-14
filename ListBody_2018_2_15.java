package com.example.ikego.listtest;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ikego on 2018/02/08.
 */

public class ListBody extends View implements ListView.OnItemClickListener{
    int sli = android.R.layout.simple_list_item_1;
    Context context;
    public static LinearLayout layout;
    Bitmap bgBitmap;
    //LinearLayout layout2;
    //public static LinearLayout[] linearLayouts;

    TextView tv;

    ListView listView;

    ImageView imageView;

    SaveView saveView;

    ArrayAdapter<String> data;

    public ListBody(Context context){
        super(context);
        layout = new LinearLayout(context);
        //layout2 = new LinearLayout(context);

        this.context = context;

        imageView = new ImageView(context);
        bgBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.save2);

        data = new ArrayAdapter<String>(context,sli);

        data.add("1番目                                                                   " +
                "                                                                         ");
        data.add("2番目                                                                   " +
                "                                                                         ");
        data.add("3番目                                                                   " +
                "                                                                         ");
        data.add("4番目                                                                   " +
                "                                                                         ");
        data.add("5番目                                                                   " +
                "                                                                         ");
        data.add("6番目                                                                   " +
                "                                                                         ");
        data.add("7番目                                                                   " +
                "                                                                         ");
        data.add("8番目                                                                   " +
                "                                                                         ");
        data.add("9番目                                                                   " +
                "                                                                         ");
        data.add("10番目                                                                  " +
                "                                                                         ");
        data.add("11番目                                                                  " +
                "                                                                         ");
        data.add("12番目                                                                  " +
                "                                                                         ");
        data.add("13番目                                                                  " +
                "                                                                         ");
        data.add("14番目                                                                  " +
                "                                                                         ");
        data.add("15番目                                                                  " +
                "                                                                         ");
        data.add("16番目                                                                  " +
                "                                                                         ");
        data.add("17番目                                                                  " +
                "                                                                         ");
        data.add("18番目                                                                  " +
                "                                                                         ");
        data.add("19番目                                                                  " +
                "                                                                         ");

//        tv = new TextView(context);
//        tv.setBackgroundColor(Color.CYAN);
//        tv.setTextSize(36);
//        tv.setText("SAVE");
//        tv.setTag("Text");
//        tv.setGravity(Gravity.CENTER);
//        layout.addView(tv);

        saveView = new SaveView(context);
        //layout.addView(saveView);
        //imageView.setImageResource(R.drawable.save2);
        imageView.setImageBitmap(bgBitmap);
        //imageView.setAdjustViewBounds(true);
        imageView.setRight(bgBitmap.getWidth());
        layout.addView(imageView);


        listView = new ListView(context);
        listView.setBackgroundColor(Color.WHITE);

        listView.setAdapter(data);
        listView.setOnItemClickListener(this);
        layout.addView(listView);
        //layout2.addView(imageView);

        //linearLayouts[0] = layout1;
        //linearLayouts[1] = layout2;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view,int pos,long id){
        AlertDialog.Builder ad = new AlertDialog.Builder(context);
        ad.setMessage(((TextView)view).getText());

        ad.setPositiveButton("OK",null);
        ad.show();
    }

    LinearLayout layoutView(){
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);

        //return linearLayouts;
        return  layout;
    }
}
