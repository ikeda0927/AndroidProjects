package com.example.ikego.teststorygame1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by ikego on 2018/02/02.
 */

public class StoryView extends SurfaceView implements SurfaceHolder.Callback {

    private static final int DRAW_INTERVAL = 1000/100;

    private final Paint paint = new Paint();

    private static int height; //= canvas.getHeight();
    private static int width; //= canvas.getWidth();

    private final Bitmap bgBitmap;
    //private final Bitmap LbgBitmap;
    //private final Bitmap RbgBitmap;
    private final Bitmap kirbyBitmap;

    private static GameMap gameMap;
    private Kirby kirby;

    private static float x;
    private static float y;
    private static boolean judgeKirby = false;
    private static boolean judgeKirbyFace = false;
    private static int changeBG = 1;

    public StoryView(Context context){
        super(context);
        bgBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.pupupuland_grassfield);
        kirbyBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.kirby8);
        getHolder().addCallback(this);
    }

    private DrawThread drawThread;

    private class DrawThread extends Thread{
        private final AtomicBoolean isFinished = new AtomicBoolean();

        public void finish(){
            isFinished.set(true);
        }

        @Override
        public void run(){
            SurfaceHolder holder = getHolder();
            while(!isFinished.get()){
                if(holder.isCreating()){
                    continue;
                }
                Canvas canvas = holder.lockCanvas();
                if(canvas == null){
                    continue;
                }

                drawStory(canvas);

                holder.unlockCanvasAndPost(canvas);

                synchronized(this){
                    try{
                        wait(DRAW_INTERVAL);
                    }catch (InterruptedException e){
                    }
                }
            }
        }
    }

    public void startDrawThread(){
        stopDrawThread();

        drawThread = new DrawThread();
        drawThread.start();
    }
    public boolean stopDrawThread(){
        if(drawThread == null){
            return false;
        }
        drawThread.finish();
        drawThread = null;
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        startDrawThread();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        stopDrawThread();
    }

    public void drawStory(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        width = canvas.getWidth();
        height = canvas.getHeight();

        //mapの初期化
        if(gameMap == null){
            gameMap = new GameMap(bgBitmap,width,height);
        }

        gameMap.draw(canvas,changeBG);

        if(kirby == null){
            kirby = new Kirby(kirbyBitmap,canvas);
        }

        //kirby.drawKiby(canvas);
        if(judgeKirby){
            kirby.drawKiby(x,y,judgeKirbyFace);
            //judgeKirby = false;
        }
        //canvas.drawBitmap(bgBitmap,100,100,paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                showKirby(event.getX(),event.getY());
                if(judgeKirbyFace){
                    judgeKirbyFace = false;
                }else{
                    judgeKirbyFace = true;
                }
                break;
        }

        return super.onTouchEvent(event);
    }

    private void showKirby(float x,float y){
        this.x = x;
        this.y = y;
        float L_rate = 0.07f;
        float R_rate = 0.93f;
        //kirby.drawKiby(x,y);
        //judgeKirby = true;
        //if(x > width * L_rate && x < width * R_rate){
        if(x <= width * L_rate){
            //judgeKirby = true;
            judgeKirby = false;
            if(changeBG <= 0){
                changeBG = 2;
            }else{
                changeBG--;
            }
        }else if(x >= width * R_rate){
            judgeKirby = false;
            if(changeBG >= 2){
                changeBG = 0;
            }else{
                changeBG++;
            }
        }else{
            judgeKirby = true;
        }

    }

}
