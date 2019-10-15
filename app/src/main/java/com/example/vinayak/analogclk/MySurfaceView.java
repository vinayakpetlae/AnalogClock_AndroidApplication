package com.example.vinayak.analogclk;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Calendar;

class MySurfaceView extends SurfaceView implements Runnable {
    private Thread thread = null;
    private SurfaceHolder surfaceHolder = getHolder();
    private boolean running = false;
    SharedPreferences preferences;
    private int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private Rect rect = new Rect();


    private float length;
    private Context context;

    public MySurfaceView(Context context, float l) {
        super(context);
        this.length = l;
        this.context = context;
    }

    public void onResumeMySurfaceView() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void onPauseMySurfaceView() {
        boolean retry = true;
        running = false;
        while (retry) {

            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void run() {
        int hour = 0, min = 0, sec = 0;
        Canvas canvas = surfaceHolder.lockCanvas();
        preferences = context.getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        int greenColorValue = Color.parseColor("#FF0000");
        int greenColorValue1 = Color.parseColor("#FFFF00");


        int color = preferences.getInt("color", greenColorValue);
        int color1 = preferences.getInt("color1", greenColorValue1);


        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(10);

        Paint paint2 = new Paint();
        paint2.setColor(color1);
        paint2.setTextSize(30);
        paint2.setStrokeWidth(5);



        while (running) {
            if (surfaceHolder.getSurface().isValid()) {
                canvas = surfaceHolder.lockCanvas();

                RegPoly secMarks = new RegPoly(60, length, getWidth() / 2, getHeight() / 2, canvas, paint);
                RegPoly hourMarks = new RegPoly(12, length - 20, getWidth() / 2, getHeight() / 2, canvas, paint);
                RegPoly hourHand = new RegPoly(60, length - 180, getWidth() / 2, getHeight() / 2, canvas, paint2);
                RegPoly minHand = new RegPoly(60, length - 60, getWidth() / 2, getHeight() / 2, canvas, paint2);
                RegPoly secHand = new RegPoly(60, length - 30, getWidth() / 2, getHeight() / 2, canvas, paint2);
                RegPoly num = new RegPoly(12, length - 20, getWidth() / 2, getHeight() / 2, canvas, paint);


                canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                secMarks.drawPoints();
                hourMarks.drawPoints();
                drawNumeral(canvas, paint2);


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR);
                min = calendar.get(Calendar.MINUTE);
                sec = calendar.get(Calendar.SECOND);
                secHand.drawRadius(sec + 45);
                minHand.drawRadius(min + 45);
                hourHand.drawRadius(hour * 5 + min / 12 + 45);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void drawNumeral(Canvas canvas, Paint paint) {

        for (int number : numbers) {
            String tmp = String.valueOf(number);
            paint.getTextBounds(tmp, 0, tmp.length(), rect);
            double angle = Math.PI / 6 * (number - 3);
            int x = (int) (getWidth() / 2 + Math.cos(angle) * 380 - rect.width() / 2);
            int y = (int) (getHeight() / 2 + Math.sin(angle) * 380 + rect.height() / 2);
            canvas.drawText(tmp, x, y, paint);
        }
    }
}