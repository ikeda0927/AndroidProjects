package com.example.ikego.listtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by ikego on 2018/02/10.
 */

public class SaveView extends View {

    Bitmap saveBitmap;
    Paint paint = new Paint();
    float width;

    public SaveView(Context context) {
        super(context);
        saveBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.save2);
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        if (Integer.valueOf(android.os.Build.VERSION.SDK_INT) < 13) {
            Log.d("TEST", "12までのが来てる！");
            width = display.getWidth();

        } else {
            Log.d("TEST", "13以降が来てる！");
            Point size = new Point();
            display.getSize(size);
            width = size.x;

        }
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(saveBitmap,0,0,paint);
    }
}
