package com.example.shiorinakayama.moneybook_0621;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Canvas;



public class Activity1 extends AppCompatActivity {
    public float x;
    public float y;

    public boolean inGreen = false;
    @Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        MyView1 myView =new MyView1(this);
        setContentView(myView);
    }


    class MyView1 extends View {
        private Paint paint;

        public MyView1(Context context) {
            super(context);
            paint = new Paint();
        }


        @Override
        protected void onDraw(Canvas canvas) {
            paint.setARGB(255, 132, 255, 193);
            canvas.drawCircle(550, 400, 350, paint);

            //黄色
            paint.setARGB(255, 255, 255, 153);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawArc(200, 50, 900, 750, 0, 100, true, paint);

            //青
            paint.setARGB(255, 153, 204, 255);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawArc(200, 50, 900, 750, 100, 50, true, paint);


            //赤
            paint.setARGB(255, 255, 153, 153);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawArc(200, 50, 900, 750, 150, 70, true, paint);

            //紫
            paint.setARGB(255, 204, 153, 255);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawArc(200, 50, 900, 750, 220, 50, true, paint);

            //白い縁を真ん中に配置
            paint.setARGB(255, 255, 255, 255);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(550, 400, 170, paint);

            //１ヶ月タッチ

            if (inGreen) {
                paint.setARGB(255, 132, 255, 193);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                Rect rect = new Rect(0, 900, 1200, 2000);
                canvas.drawRect(rect, paint);
            }

            paint.setARGB(255, 255, 255, 255);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            Rect rect = new Rect(0, 900, 1200, 2000);
            canvas.drawRect(rect, paint);


            }
        }


        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = event.getX() - 250.f;
            y = 250.f - event.getY();

            float distance = (float) Math.sqrt(x * x + y * y);

            if (distance > 200){
                inGreen = false;
            }else{
                int angle = (int) Math.sqrt(Math.atan2(x,y));
                angle = angle > 0 ? angle : angle + 360;
                inGreen = angle >= 0 && angle <= 90;
            }


            return true;



        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_top:
                finish();

                return true;

            case R.id.item1:
                finish();
                Intent varIntent1 = new Intent(Activity1.this,Activity1.class);
                startActivity(varIntent1);
                return true;


        }
        return super.onOptionsItemSelected(item);

    }


}
