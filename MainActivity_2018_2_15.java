package com.example.ikego.listtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //try {
            ListBody listBody = new ListBody(this);
        setContentView(listBody.layoutView());
        //setContentView(listBody.layoutView());
        //}catch (NullPointerException e){
        //    Toast.makeText(this,"NullPointerException",Toast.LENGTH_SHORT).show();
        //}

        /*
        //リスト項目をArrayListとして準備
        ArrayList<String> data = new ArrayList<>();
        data.add("1番目");
        data.add("2番目");
        data.add("3番目");
        data.add("4番目");
        data.add("5番目");
        data.add("6番目");
        data.add("7番目");
        data.add("8番目");
        data.add("9番目");
        data.add("10番目");
        data.add("11番目");
        data.add("12番目");
        data.add("13番目");
        data.add("14番目");
        data.add("15番目");
        data.add("16番目");
        data.add("17番目");
        data.add("18番目");
        data.add("19番目");

        //配列アダプターを作成＆ListViewに登録
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,data);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        */
    }
}
