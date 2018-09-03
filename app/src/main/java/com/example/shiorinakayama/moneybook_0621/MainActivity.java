package com.example.shiorinakayama.moneybook_0621;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);



    }


    class MyView extends View {
        private Paint paint;
        private short xRect = 0;
        private short xRect2 = 0;
        private float xRect3 = 0;
        private float yRect = 0;
        public boolean x = false;
        private final String TAG = "Square_1";
        private float rest;
        private float a;
        private float b;







        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //xRect = event.getX();
            yRect = event.getY();

            if (x){
                xRect = (short)event.getX();
            }else{
                xRect2 = (short)event.getX();
            }
            Log.d("TouchEvent","Y:"+yRect);

            switch (event.getAction()){
                case MotionEvent.ACTION_UP:

                    break;
            }






            this.invalidate();


            return true;
        }

        public  MyView(Context context){
            super(context);
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas){
            //背景
            canvas.drawARGB(255,255,255,255);

            Bitmap out = BitmapFactory.decodeResource(getResources(),R.drawable.out64);
            Bitmap  in = BitmapFactory.decodeResource(getResources(),R.drawable.in64);

            //黄色円
            paint.setARGB(255,255,255,137);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawArc(120,10,970,800,0,0 + xRect2/3,true,paint);



            //緑の円
            paint.setARGB(255,132,255,193);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            canvas.drawCircle(550,400,350, paint);



            //白い円
            paint.setARGB(255, 255, 255, 255);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(550, 400, 170, paint);
            //白い弧
            canvas.drawArc(130,20,1050,850,0,0 + a ,true,paint);

            if (xRect >= 1079){
                a = 360;

            }else{
                a = - 1*xRect/3;
            }

            //ピンク短形（右）
            /*paint.setColor(Color.argb(255, 255, 142, 198));
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(860 + xRect3, 1200 , 1080, 1450, paint);**/



            //ピンク短形
            paint.setColor(Color.argb(255, 255, 142, 198));
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(0 , 1200 , 220 + xRect2, 1450, paint);
            canvas.drawBitmap(in,20 + xRect2,1230,paint);
           // Log.d("onTouchEvent","ピンクを引っ張っている長さは「"+ 180+xRect+"」");



            //アイコン


            //青短径
            paint.setColor(Color.argb(255, 147, 201, 255));
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(0, 850, 220+xRect , 1100, paint);
            canvas.drawBitmap(out,20 + xRect,880,paint);

            //テキスト
            Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            textPaint.setTextSize(50);

            if(yRect >= 1400){
                x = false;

            }else if (yRect <= 1230){
                x = true;
            }
            rest =1500 - xRect + xRect2;


            String text = ""+rest+"";

            canvas.drawText(text,460,420,textPaint  );

            //青テキスト
            paint.setARGB(255,147,201,255);
            paint.setTextSize(90);

            String btext = "" + xRect + "";
            canvas.drawText(btext,200 + xRect,860,paint);

            //赤テキスト
            paint.setARGB(255,255,142,198);
            paint.setTextSize(90);
            String rtext = "" + xRect2 + "";
            canvas.drawText(rtext,200 + xRect2,1210,paint);




        }


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

                Intent varIntent_back = new Intent(MainActivity.this,MainActivity.class);
                startActivity(varIntent_back);
                return true;

            case R.id.item1:
                Intent varIntent1 = new Intent(MainActivity.this,Activity1.class);
                startActivity(varIntent1);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}
