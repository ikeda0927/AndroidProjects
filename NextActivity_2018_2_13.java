package com.example.ikego.testintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ikego on 2018/02/08.
 */

public class NextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NextActivity.this,"BACK",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NextActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event){
        if(event.getAction()==KeyEvent.ACTION_DOWN){
            switch (event.getKeyCode()){
                case KeyEvent.KEYCODE_BACK:
                    //Backボタン押下時にダイアログなどを表示したい場合はここに記述
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
