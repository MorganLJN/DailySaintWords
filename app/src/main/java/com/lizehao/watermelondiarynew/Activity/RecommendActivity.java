package com.lizehao.watermelondiarynew.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;
import com.lizehao.watermelondiarynew.PhotoWall.image;
import com.lizehao.watermelondiarynew.R;
import com.lizehao.watermelondiarynew.ui.AddDiaryActivity;
import com.lizehao.watermelondiarynew.utils.Util;
import com.squareup.haha.perflib.Main;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.panpf.sketch.SketchImageView;
import pl.droidsonroids.gif.GifDrawable;

public class RecommendActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, View.OnClickListener {

    private ImageSwitcher imageSwitcher;
    private int index;
    private List<GifDrawable> list;
    final int FLIP_DISTANCE = 80;
    float x = 0, y = 0;
    GestureDetector detector;

    private ImageButton bt;
    private ImageButton bt1;
    private ImageButton bt2;
    private ImageButton bt3;
    private List<ImageButton> buttonItems = new ArrayList<ImageButton>();
    private int flag = 1; //1表示未弹出 -1表示已经弹出


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RecommendActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //Transition fade = TransitionInflater.from(this).inflateTransition(R.transition.fade);
        //getWindow().setEnterTransition(fade);
        //getWindow().setReenterTransition(fade);
        setContentView(R.layout.activity_recommend);
        ButterKnife.bind(this);
        putData();
        index = list.size()-1;
        bt = (ImageButton) findViewById(R.id.imgTouchShow);
        bt1 = (ImageButton) findViewById(R.id.recom_bt1);
        bt2 = (ImageButton) findViewById(R.id.recom_bt2);
        bt3 = (ImageButton) findViewById(R.id.recom_bt3);
        buttonItems.add(bt1);
        buttonItems.add(bt2);
        buttonItems.add(bt3);


        detector = new GestureDetector(this, this);
        Intent intent = getIntent();
        String dateS = intent.getStringExtra("dateS");
        int dateI = intent.getIntExtra("dateI", -2); //-2为无信息传递,-1为首页进入最后一页，其他为所有页进入
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                //makeView返回的是当前需要显示的ImageView控件，用于填充进ImageSwitcher中。
                return new ImageView(RecommendActivity.this);
            }
        });


        if(dateI != -2) {
            if (dateI == -1)
                index = list.size() - 1;
            else if (dateI >= 0)
                index = dateI;
            Log.d("date111", "int_index" + index);
            imageSwitcher.setImageDrawable(list.get(index));
            if(image.collection[index])
                bt2.setBackgroundResource(R.drawable.recom_bt21);
            else
                bt2.setBackgroundResource(R.drawable.recom_bt2);
        }
        else {
            try {
                int num = Integer.parseInt(dateS);
                Log.d("date111", num + "String_date");
                if(num <= 131)
                    index = num-101;
                else if(num >= 201 && num <= 229)
                    index = num-201+31;
                else if(num >= 301 && num <= 331)
                    index = num-301+60;

                imageSwitcher.setImageDrawable(list.get(index));
                if(image.collection[index])
                    bt2.setBackgroundResource(R.drawable.recom_bt21);
                else
                    bt2.setBackgroundResource(R.drawable.recom_bt2);
            } catch (Exception e){
                Log.d("date111", "Wrong!");
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        findViewById(R.id.imgTouchShow).setVisibility(View.INVISIBLE);
        findViewById(R.id.recom_bt1).setVisibility(View.INVISIBLE);
        findViewById(R.id.recom_bt2).setVisibility(View.INVISIBLE);
        findViewById(R.id.recom_bt3).setVisibility(View.INVISIBLE);
        flag = 1;
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) { }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) { return false;}

    @Override
    public void onLongPress(MotionEvent event) {
        bt = (ImageButton) findViewById(R.id.imgTouchShow);
        bt1 = (ImageButton) findViewById(R.id.recom_bt1);
        bt2 = (ImageButton) findViewById(R.id.recom_bt2);
        bt3 = (ImageButton) findViewById(R.id.recom_bt3);
        x = event.getRawX();
        y = event.getRawY();

        Log.d("emmm", String.valueOf(x));
        Log.d("emmm", String.valueOf(y));

        flag = 1;
        findViewById(R.id.recom_bt1).setVisibility(View.INVISIBLE);
        findViewById(R.id.recom_bt2).setVisibility(View.INVISIBLE);
        findViewById(R.id.recom_bt3).setVisibility(View.INVISIBLE);
        bt.setVisibility(View.VISIBLE);
        bt.setX(x-70);
        bt.setY(y-70);
        bt1.setX(x-70);
        bt1.setY(y-70);
        bt2.setX(x-70);
        bt2.setY(y-70);
        bt3.setX(x-70);
        bt3.setY(y-70);
    }

    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        findViewById(R.id.imgTouchShow).setVisibility(View.INVISIBLE);
        //right
        if(event1.getX() - event2.getX() > FLIP_DISTANCE) {
            index++;
            //通过代码设定从左缓进，从右换出的效果。
            if(index < list.size()) {
                imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(RecommendActivity.this, R.anim.in_from_right));
                imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(RecommendActivity.this, R.anim.out_to_left));
                Log.d("wuwuwu", "1");
                Log.d("wuwuwu", "index:" + index);
                Log.d("wuwuwu", "size:" + list.size());
                //设定ImageSwitcher显示新图片
                imageSwitcher.setImageDrawable(list.get(index));
                if(image.collection[index])
                    bt2.setBackgroundResource(R.drawable.recom_bt21);
                else
                    bt2.setBackgroundResource(R.drawable.recom_bt2);
            }
            else
            {
                //用于循环显示图片
                index = list.size() - 1;
                if(image.collection[index])
                    bt2.setBackgroundResource(R.drawable.recom_bt21);
                else
                    bt2.setBackgroundResource(R.drawable.recom_bt2);
                Log.d("wuwuwu", "2");
            }

            return true;
        }
        //left
        if(event2.getX() - event1.getX() > FLIP_DISTANCE) {
            index--;
            if(index >= 0)
            {
                //通过代码设定从左缓进，从右换出的效果。
                imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(RecommendActivity.this, R.anim.in_from_left));
                imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(RecommendActivity.this, R.anim.out_to_right));
                imageSwitcher.setImageDrawable(list.get(index));
                if(image.collection[index])
                    bt2.setBackgroundResource(R.drawable.recom_bt21);
                else
                    bt2.setBackgroundResource(R.drawable.recom_bt2);
                //用于循环显示图片
                //index=0;
                Log.d("wuwuwu", "3");
            }
            else {
                index = 0;
                if(image.collection[index])
                    bt2.setBackgroundResource(R.drawable.recom_bt21);
                else
                    bt2.setBackgroundResource(R.drawable.recom_bt2);
                Log.d("wuwuwu", "4");
            }
            return true;
        }

        if(event2.getY() - event1.getY() > FLIP_DISTANCE) {
            Intent intent = new Intent(RecommendActivity.this, NoteActivity.class);
            intent.putExtra("noteIndex", index);
            startActivity(intent);
            return true;
        }


        return false;
    }



    /**
     * 按钮移动动画
     * @params 子按钮列表
     * @params 弹出时圆形半径radius
     */
    public void buttonAnimation(List<ImageButton> buttonList, int radius) {
        ObjectAnimator objAnimatorX;
        ObjectAnimator objAnimatorY;
        ObjectAnimator objAnimatorRotate;

        for(int i = 0; i < 3; i++) {
            // 将按钮设为可见
            buttonList.get(i).setVisibility(View.VISIBLE);
            // 按钮在X、Y方向的移动距离
            float distanceX = (float) (flag*radius*(Math.cos(Util.getAngle(3,i))));
            float distanceY = -(float) (flag*radius*(Math.sin(Util.getAngle(3,i))));
            // X方向移动
            objAnimatorX = ObjectAnimator.ofFloat(buttonList.get(i), "x", buttonList.get(i).getX(),buttonList.get(i).getX()+distanceX);
            objAnimatorX.setDuration(40);
            objAnimatorX.setStartDelay(20);
            objAnimatorX.start();
            // Y方向移动
            objAnimatorY = ObjectAnimator.ofFloat(buttonList.get(i), "y", buttonList.get(i).getY(),buttonList.get(i).getY()+distanceY);
            objAnimatorY.setDuration(40);
            objAnimatorY.setStartDelay(20);
            objAnimatorY.start();
            // 按钮旋转
            objAnimatorRotate = ObjectAnimator.ofFloat(buttonList.get(i), "rotation", 0, 360);
            objAnimatorRotate.setDuration(40);
            objAnimatorY.setStartDelay(20);
            objAnimatorRotate.start();
            if(flag == -1) {
                objAnimatorX.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        // TODO Auto-generated method stub
                    }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        // TODO Auto-generated method stub
                        // 将按钮设为可见
                        for (int i = 0; i < buttonItems.size(); i++) {
                            buttonItems.get(i).setVisibility(View.INVISIBLE);
                        }
                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        // TODO Auto-generated method stub
                    }
                });
            }
        }
    }



    public void putData() {
        //填充图片的Drawable资源数组
        list = new ArrayList<GifDrawable>();
        try {
            GifDrawable gif1j = new GifDrawable(getResources(), R.drawable.j01);
            GifDrawable gif2j = new GifDrawable(getResources(), R.drawable.j02);
            GifDrawable gif3j = new GifDrawable(getResources(), R.drawable.j03);
            GifDrawable gif4j = new GifDrawable(getResources(), R.drawable.j04);
            GifDrawable gif5j = new GifDrawable(getResources(), R.drawable.j05);
            GifDrawable gif6j = new GifDrawable(getResources(), R.drawable.j06);
            GifDrawable gif7j = new GifDrawable(getResources(), R.drawable.j07);
            GifDrawable gif8j = new GifDrawable(getResources(), R.drawable.j08);
            GifDrawable gif9j = new GifDrawable(getResources(), R.drawable.j09);
            GifDrawable gif10j = new GifDrawable(getResources(), R.drawable.j10);
            GifDrawable gif11j = new GifDrawable(getResources(), R.drawable.j11);
            GifDrawable gif12j = new GifDrawable(getResources(), R.drawable.j12);
            GifDrawable gif13j = new GifDrawable(getResources(), R.drawable.j13);
            GifDrawable gif14j = new GifDrawable(getResources(), R.drawable.j14);
            GifDrawable gif15j = new GifDrawable(getResources(), R.drawable.j15);
            GifDrawable gif16j = new GifDrawable(getResources(), R.drawable.j16);
            GifDrawable gif17j = new GifDrawable(getResources(), R.drawable.j17);
            GifDrawable gif18j = new GifDrawable(getResources(), R.drawable.j18);
            GifDrawable gif19j = new GifDrawable(getResources(), R.drawable.j19);
            GifDrawable gif20j = new GifDrawable(getResources(), R.drawable.j20);
            GifDrawable gif21j = new GifDrawable(getResources(), R.drawable.j21);
            GifDrawable gif22j = new GifDrawable(getResources(), R.drawable.j22);
            GifDrawable gif23j = new GifDrawable(getResources(), R.drawable.j23);
            GifDrawable gif24j = new GifDrawable(getResources(), R.drawable.j24);
            GifDrawable gif25j = new GifDrawable(getResources(), R.drawable.j25);
            GifDrawable gif26j = new GifDrawable(getResources(), R.drawable.j26);
            GifDrawable gif27j = new GifDrawable(getResources(), R.drawable.j27);
            GifDrawable gif28j = new GifDrawable(getResources(), R.drawable.j28);
            GifDrawable gif29j = new GifDrawable(getResources(), R.drawable.j29);
            GifDrawable gif30j = new GifDrawable(getResources(), R.drawable.j31);
            GifDrawable gif31j = new GifDrawable(getResources(), R.drawable.j31);
            GifDrawable gif1 = new GifDrawable(getResources(), R.drawable.f01);
            GifDrawable gif2 = new GifDrawable(getResources(), R.drawable.f02);
            GifDrawable gif3 = new GifDrawable(getResources(), R.drawable.f03);
            GifDrawable gif4 = new GifDrawable(getResources(), R.drawable.f04);
            GifDrawable gif5 = new GifDrawable(getResources(), R.drawable.f05);
            GifDrawable gif6 = new GifDrawable(getResources(), R.drawable.f06);
            GifDrawable gif7 = new GifDrawable(getResources(), R.drawable.f07);
            GifDrawable gif8 = new GifDrawable(getResources(), R.drawable.f08);
            GifDrawable gif9 = new GifDrawable(getResources(), R.drawable.f09);
            GifDrawable gif10 = new GifDrawable(getResources(), R.drawable.f10);
            GifDrawable gif11 = new GifDrawable(getResources(), R.drawable.f11);
            GifDrawable gif12 = new GifDrawable(getResources(), R.drawable.f12);
            GifDrawable gif13 = new GifDrawable(getResources(), R.drawable.f13);
            GifDrawable gif14 = new GifDrawable(getResources(), R.drawable.f14);
            GifDrawable gif15 = new GifDrawable(getResources(), R.drawable.f15);
            GifDrawable gif16 = new GifDrawable(getResources(), R.drawable.f16);
            GifDrawable gif17 = new GifDrawable(getResources(), R.drawable.f17);
            GifDrawable gif18 = new GifDrawable(getResources(), R.drawable.f18);
            GifDrawable gif19 = new GifDrawable(getResources(), R.drawable.f19);
            GifDrawable gif20 = new GifDrawable(getResources(), R.drawable.f20);
            GifDrawable gif21 = new GifDrawable(getResources(), R.drawable.f21);
            GifDrawable gif22 = new GifDrawable(getResources(), R.drawable.f22);
            GifDrawable gif23 = new GifDrawable(getResources(), R.drawable.f23);
            GifDrawable gif24 = new GifDrawable(getResources(), R.drawable.f24);
            GifDrawable gif25 = new GifDrawable(getResources(), R.drawable.f25);
            GifDrawable gif26 = new GifDrawable(getResources(), R.drawable.f26);
            GifDrawable gif27 = new GifDrawable(getResources(), R.drawable.f27);
            GifDrawable gif28 = new GifDrawable(getResources(), R.drawable.f28);
            GifDrawable gif29 = new GifDrawable(getResources(), R.drawable.f29);
            GifDrawable gif1m = new GifDrawable(getResources(), R.drawable.m01);
            GifDrawable gif2m = new GifDrawable(getResources(), R.drawable.m02);
            GifDrawable gif3m = new GifDrawable(getResources(), R.drawable.m03);
            GifDrawable gif4m = new GifDrawable(getResources(), R.drawable.m04);
            GifDrawable gif5m = new GifDrawable(getResources(), R.drawable.m05);
            GifDrawable gif6m = new GifDrawable(getResources(), R.drawable.m06);
            GifDrawable gif7m = new GifDrawable(getResources(), R.drawable.m07);
            GifDrawable gif8m = new GifDrawable(getResources(), R.drawable.m08);
            GifDrawable gif9m = new GifDrawable(getResources(), R.drawable.m09);
            GifDrawable gif10m = new GifDrawable(getResources(), R.drawable.m10);
            GifDrawable gif11m = new GifDrawable(getResources(), R.drawable.m11);
            GifDrawable gif12m = new GifDrawable(getResources(), R.drawable.m12);
            GifDrawable gif13m = new GifDrawable(getResources(), R.drawable.m13);
            GifDrawable gif14m = new GifDrawable(getResources(), R.drawable.m14);
            GifDrawable gif15m = new GifDrawable(getResources(), R.drawable.m15);
            GifDrawable gif16m = new GifDrawable(getResources(), R.drawable.m16);
            GifDrawable gif17m = new GifDrawable(getResources(), R.drawable.m17);
            GifDrawable gif18m = new GifDrawable(getResources(), R.drawable.m18);
            GifDrawable gif19m = new GifDrawable(getResources(), R.drawable.m19);
            GifDrawable gif20m = new GifDrawable(getResources(), R.drawable.m20);
            GifDrawable gif21m = new GifDrawable(getResources(), R.drawable.m21);
            GifDrawable gif22m = new GifDrawable(getResources(), R.drawable.m22);
            GifDrawable gif23m = new GifDrawable(getResources(), R.drawable.m23);
            GifDrawable gif24m = new GifDrawable(getResources(), R.drawable.m24);
            GifDrawable gif25m = new GifDrawable(getResources(), R.drawable.m25);
            GifDrawable gif26m = new GifDrawable(getResources(), R.drawable.m26);
            GifDrawable gif27m = new GifDrawable(getResources(), R.drawable.m27);
            GifDrawable gif28m = new GifDrawable(getResources(), R.drawable.m28);
            GifDrawable gif29m = new GifDrawable(getResources(), R.drawable.m29);
            GifDrawable gif30m = new GifDrawable(getResources(), R.drawable.m30);
            GifDrawable gif31m = new GifDrawable(getResources(), R.drawable.m31);

            //Glide.with(this).load("http://kan.027cgb.com/619969/%E4%B8%80%E6%9C%88/0101.jpg").into(imageSwitcher);

            list.add(gif1j);
            list.add(gif2j);
            list.add(gif3j);
            list.add(gif4j);
            list.add(gif5j);
            list.add(gif6j);
            list.add(gif7j);
            list.add(gif8j);
            list.add(gif9j);
            list.add(gif10j);
            list.add(gif11j);
            list.add(gif12j);
            list.add(gif13j);
            list.add(gif14j);
            list.add(gif15j);
            list.add(gif16j);
            list.add(gif17j);
            list.add(gif18j);
            list.add(gif19j);
            list.add(gif20j);
            list.add(gif21j);
            list.add(gif22j);
            list.add(gif23j);
            list.add(gif24j);
            list.add(gif25j);
            list.add(gif26j);
            list.add(gif27j);
            list.add(gif28j);
            list.add(gif29j);
            list.add(gif30j);
            list.add(gif31j);
            list.add(gif1);
            list.add(gif2);
            list.add(gif3);
            list.add(gif4);
            list.add(gif5);
            list.add(gif6);
            list.add(gif7);
            list.add(gif8);
            list.add(gif9);
            list.add(gif10);
            list.add(gif11);
            list.add(gif12);
            list.add(gif13);
            list.add(gif14);
            list.add(gif15);
            list.add(gif16);
            list.add(gif17);
            list.add(gif18);
            list.add(gif19);
            list.add(gif20);
            list.add(gif21);
            list.add(gif22);
            list.add(gif23);
            list.add(gif24);
            list.add(gif25);
            list.add(gif26);
            list.add(gif27);
            list.add(gif28);
            list.add(gif29);
            list.add(gif1m);
            list.add(gif2m);
            list.add(gif3m);
            list.add(gif4m);
            list.add(gif5m);
            list.add(gif6m);
            list.add(gif7m);
            list.add(gif8m);
            list.add(gif9m);
            list.add(gif10m);
            list.add(gif11m);
            list.add(gif12m);
            list.add(gif13m);
            list.add(gif14m);
            list.add(gif15m);
            list.add(gif16m);
            list.add(gif17m);
            list.add(gif18m);
            list.add(gif19m);
            list.add(gif20m);
            list.add(gif21m);
            list.add(gif22m);
            list.add(gif23m);
            list.add(gif24m);
            list.add(gif25m);
            list.add(gif26m);
            list.add(gif27m);
            list.add(gif28m);
            list.add(gif29m);
            list.add(gif30m);
            list.add(gif31m);

        } catch(Exception e){
            System.out.println("Wrong!");
        }
    }





    @OnClick({R.id.bt_RecomToHome, R.id.imgTouchShow, R.id.recom_bt1, R.id.recom_bt2, R.id.recom_bt3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_RecomToHome:
                Main2Activity.startActivity(this);
                break;
            case R.id.imgTouchShow:
                buttonAnimation(buttonItems, 270);
                flag = 0 - flag;
                break;
            case R.id.recom_bt1:
                Intent intent = new Intent(RecommendActivity.this, DownloadActivity.class);
                intent.putExtra("date_dl", index);
                startActivity(intent);
                break;
            case R.id.recom_bt2:
                if(!image.collection[index]) {
                    image.collection[index] = true;
                    Log.d("collect111", "index:"+index+"was collected");
                    bt2.setBackgroundResource(R.drawable.recom_bt21);
                    Toast.makeText(RecommendActivity.this,"collect successfully",Toast.LENGTH_SHORT).show();
                }
                else {
                    image.collection[index] = false;
                    bt2.setBackgroundResource(R.drawable.recom_bt2);
                    Toast.makeText(RecommendActivity.this,"cancel collection",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.recom_bt3:
                AddDiaryActivity.startActivity(this);
                break;
            default:
                break;
        }
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


}
