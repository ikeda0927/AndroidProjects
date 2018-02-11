package com.example.ikego.teststorygame1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by ikego on 2018/02/02.
 */

public class GameMap {

    //画像
    private static Bitmap bgbmp;
    //画面の幅と高さ
    private static int width;
    private static int height;

    private final RectF rect;
    private Rect srcRect;

    static int left;
    static int right;
    static int top;
    static int bottom;

    static int WIDTH;
    static int bg_width;
    static int bg_height;
    //float rateX;
    //float rateY;



    private final Paint paint = new Paint();

    public GameMap(Bitmap bgbmp, int width, int height){
        this.bgbmp = bgbmp;
        this.width = width;
        this.height = height;

        bg_width = bgbmp.getWidth();
        WIDTH = bg_width/3;
        bg_height = bgbmp.getHeight();
        //rateX = width / bg_width;
        //rateX = bg_width / width;
        //rateY = height / bg_height;
        //rateY = bg_height / height;

        left = 0;
        top = 0;
        right = width;
        bottom = height;
        //float right = left + bg_width * rateX;
        //float right = left + bg_width;
        //float bottom = top + bg_height * rateY;
        //float bottom = top + bg_height;

        rect = new RectF(left,top,width,bottom);
        //srcRect = new Rect(0,0,bgbmp.getWidth(),bgbmp.getHeight());
        srcRect = new Rect(0,0,bgbmp.getWidth()/3,bgbmp.getHeight());
    }



    void draw(Canvas canvas,int Changebg){
        ChangeBG(Changebg);
        canvas.drawBitmap(bgbmp,srcRect,rect,paint);
    }

    void ChangeBG(int Changebg){
        Rect rectL = new Rect(0,0,WIDTH,bg_height);
        Rect rectC = new Rect(WIDTH,0,WIDTH * 2,bg_height);
        Rect rectR = new Rect(WIDTH * 2,0,WIDTH * 3,bg_height);
        switch (Changebg){
            case 0:
                srcRect = rectL;
                break;
            case 1:
                srcRect = rectC;
                break;
            case 2:
                srcRect = rectR;
                break;

        }
    }

    Bitmap getBITMAP(){
        return bgbmp;
    }

}
