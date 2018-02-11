package com.example.ikego.teststorygame1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by ikego on 2018/02/02.
 */

public class Kirby {
    private final Paint paint = new Paint();

    //private static int KirbySIZE =384;

    private static float centerX;
    private static float centerY;

    private static RectF rect;
    private static RectF setRect;
    //private static final Rect BITMAP_SRC_SMILE = new Rect(0,0,KirbySIZE,318);
    //private static final Rect BITMAP_SRC_ITE = new Rect(KirbySIZE,0,KirbySIZE * 2,318);

    private static boolean judge = true;

    private static Bitmap bmp;

    private static Canvas canvas;

    public Kirby(Bitmap bmp,Canvas canvas){
        this.bmp = bmp;
        this.canvas = canvas;

        //kirby3
        //rect = new Rect(0,0,bmp.getWidth(),bmp.getHeight());
        //kirby8
        //rect =new RectF(0,0,KirbySIZE,bmp.getHeight());

        //kirby3を使用する際は下の2つの変数をint型に変える
        //centerX = rect.centerX();
        //centerY = rect.centerY();
    }



    void drawKiby(float x,float y,boolean judge){
        //kirby3
        //canvas.drawBitmap(bmp,x - centerX,y - centerY,paint);
        int KirbySIZE = bmp.getWidth() / 2;
        //kirby8
        rect =new RectF(x,y,x + KirbySIZE,y + bmp.getHeight());

        Rect BITMAP_SRC_SMILE = new Rect(0,0,KirbySIZE,bmp.getHeight());
        Rect BITMAP_SRC_ITE = new Rect(KirbySIZE,0,KirbySIZE * 2,bmp.getHeight());

        //kirby8用
        //centerX = rect.centerX();
        centerX = KirbySIZE / 2;
        //centerY = rect.centerY();
        centerY = bmp.getHeight() / 2;
        setRect =new RectF(x-centerX,y-centerY,x+KirbySIZE-centerX,y+bmp.getHeight()-centerY);

        if(judge){
            canvas.drawBitmap(bmp,BITMAP_SRC_SMILE,setRect,paint);
        }else{
            canvas.drawBitmap(bmp,BITMAP_SRC_ITE,setRect,paint);
        }

    }
}
