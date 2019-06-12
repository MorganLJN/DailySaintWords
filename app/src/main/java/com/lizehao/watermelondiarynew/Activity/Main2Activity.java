package com.lizehao.watermelondiarynew.Activity;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.lizehao.watermelondiarynew.Calendar.ToastUtil;
import com.lizehao.watermelondiarynew.R;
import com.lizehao.watermelondiarynew.ui.AddDiaryActivity;
import com.lizehao.watermelondiarynew.ui.MainActivity;
import com.nanchen.calendarview.ClickDataListener;
import com.nanchen.calendarview.MyCalendarView;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private SoundPool pool;
    private Map<String, Integer> poolMap;


    private String date;
    private Animation fringeAnim1, fringeAnim2;
    private ImageView fringe;

    private ImageSwitcher imageSwitcher;
    final int FLIP_DISTANCE = 80;
    GestureDetector detector;
    private int[] imageId=new int[]{
            R.drawable.h0101,R.drawable.h0102,R.drawable.h0103,R.drawable.h0104,R.drawable.h0105,
            R.drawable.h0106,R.drawable.h0107,R.drawable.h0108,R.drawable.h0109,R.drawable.h0110,
            R.drawable.h0111,R.drawable.h0112,R.drawable.h0113,R.drawable.h0114,R.drawable.h0115,
            R.drawable.h0116,R.drawable.h0117,R.drawable.h0118,R.drawable.h0119,R.drawable.h0120,
            R.drawable.h0121,R.drawable.h0122,R.drawable.h0123,R.drawable.h0124,R.drawable.h0125,
            R.drawable.h0126,R.drawable.h0127,R.drawable.h0128,R.drawable.h0129, R.drawable.h0130, R.drawable.h0131,

            R.drawable.h0201,R.drawable.h0202,R.drawable.h0203,R.drawable.h0204,R.drawable.h0205,
            R.drawable.h0206,R.drawable.h0207,R.drawable.h0208,R.drawable.h0209,R.drawable.h0210,
            R.drawable.h0211,R.drawable.h0212,R.drawable.h0213,R.drawable.h0214,R.drawable.h0215,
            R.drawable.h0216,R.drawable.h0217,R.drawable.h0218,R.drawable.h0219,R.drawable.h0220,
            R.drawable.h0221,R.drawable.h0222,R.drawable.h0223,R.drawable.h0224,R.drawable.h0225,
            R.drawable.h0226,R.drawable.h0227,R.drawable.h0228,R.drawable.h0229,

            R.drawable.h0301,R.drawable.h0302,R.drawable.h0303,R.drawable.h0304,R.drawable.h0305,
            R.drawable.h0306,R.drawable.h0307,R.drawable.h0308,R.drawable.h0309,R.drawable.h0310,
            R.drawable.h0311,R.drawable.h0312,R.drawable.h0313,R.drawable.h0314,R.drawable.h0315,
            R.drawable.h0316,R.drawable.h0317,R.drawable.h0318,R.drawable.h0319,R.drawable.h0320,
            R.drawable.h0321,R.drawable.h0322,R.drawable.h0323,R.drawable.h0324,R.drawable.h0325,
            R.drawable.h0326,R.drawable.h0327,R.drawable.h0328,R.drawable.h0329, R.drawable.h0330, R.drawable.h0331

    };
    private int index = 0;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, Main2Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        fringe = (ImageView) findViewById(R.id.fringe);

        detector = new GestureDetector(this, this);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher2);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {
                //makeView返回的是当前需要显示的ImageView控件，用于填充进ImageSwitcher中。
                return new ImageView(Main2Activity.this);
            }
        });
        index = imageId.length-1;
        imageSwitcher.setImageResource(imageId[index]);
        Log.d("home111", "1");


        poolMap = new HashMap<String, Integer>();
        // 实例化SoundPool，大小为1
        pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        // 装载音频进音频池，并且把ID记录在Map中
        poolMap.put("bgm", pool.load(this, R.raw.bgm, 1));

        /*
        pool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                // 每次装载完成均会回调
                //Log.i("sound", "音频池资源id为：" + sampleId + "的资源装载完成");
                // 当前装载完成ID为map的最大值，即为最后一次装载完成
                if (sampleId == poolMap.size()) {
                    Toast.makeText(Main2Activity.this, "加载声音池完成!",
                            Toast.LENGTH_SHORT).show();
                    // 进入应用播放四次声音
                    //pool.play(poolMap.get("bgm"), 1.0f, 1.0f, 0, 3,1.0f);
                }
            }
        });*/
    }


    @Override
    protected void onDestroy() {
        // 销毁的时候释放SoundPool资源
        if (pool != null) {
            pool.release();
            pool = null;
        }
        super.onDestroy();
    }

    @OnClick({R.id.bt_HomeToDiary, R.id.fringe, R.id.bt_HomeToRecom, R.id.bt_HomeToMenu})
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.bt_HomeToDiary:
                if (pool != null)
                    pool.play(poolMap.get("bgm"), 1.0f, 1.0f, 0, 0, 1.0f);
                AddDiaryActivity.startActivity(this);
                break;
            case R.id.fringe:
                fringeAnim1 = AnimationUtils.loadAnimation(this, R.anim.fringe_in);
                fringeAnim2 = AnimationUtils.loadAnimation(this, R.anim.fringe_out);
                fringeAnim1.setFillAfter(true);
                fringeAnim2.setFillAfter(true);
                fringe.startAnimation(fringeAnim1);
                fringeAnim1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        btnClick(view);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case R.id.bt_HomeToRecom:
                if (pool != null)
                    pool.play(poolMap.get("bgm"), 1.0f, 1.0f, 0, 0, 1.0f);
                Intent intent = new Intent(Main2Activity.this, RecommendActivity.class);
                intent.putExtra("dateI", index);
                startActivity(intent);
                //startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.bt_HomeToMenu:
                if (pool != null)
                    pool.play(poolMap.get("bgm"), 1.0f, 1.0f, 0, 0, 1.0f);
                MenuActivity.startActivity(this);
                break;
        }
    }


    public void btnClick(View view) {
        //        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        final AlertDialog dialog = new AlertDialog.Builder(this, R.style.dialog_style).create();
        dialog.show();
        Window window = dialog.getWindow();

        window.setContentView(R.layout.layout_calendar_dialog);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setWindowAnimations(R.style.AnimBottom);
        window.setGravity(Gravity.TOP);

        MyCalendarView calendarView = (MyCalendarView) window.findViewById(R.id.calendarView);
        calendarView.setClickDataListener(new ClickDataListener() {
            @Override
            public void clickData(int year, int month, int day) {
                date = String.format(Locale.CHINA, "%04d-%02d-%02d", year, month, day);
                ToastUtil.showToast(Main2Activity.this,date);
                dialog.cancel();

                Intent intent = new Intent(Main2Activity.this, RecommendActivity.class);
                String date1 = String.format(Locale.CHINA, "%02d%02d", month, day);
                int num = Integer.parseInt(date1);
                Log.d("date111", "原始日期: " + num);
                intent.putExtra("dateS", date1);
                startActivity(intent);
            }
        });

        fringe.startAnimation(fringeAnim2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float v, float v1) {
        Log.d("home111", "11");
        if(event1.getX() - event2.getX() > FLIP_DISTANCE) {
            index++;
            if(index < imageId.length) {
                Log.d("home111", "2");
                imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(Main2Activity.this, R.anim.in_from_right));
                imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(Main2Activity.this, R.anim.out_to_left));
                imageSwitcher.setImageResource(imageId[index]);
            }
            else { //用于循环显示图片
                index = imageId.length - 1;
                Log.d("home111", "3");
            }
            return true;
        }
        if(event2.getX() - event1.getX() > FLIP_DISTANCE) {
            index--;
            if (index >= 0) {
                Log.d("home111", "4");
                imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(Main2Activity.this, R.anim.in_from_left));
                imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(Main2Activity.this, R.anim.out_to_right));
                imageSwitcher.setImageResource(imageId[index]);
            } else {
                index = 0;
                Log.d("home111", "5");
            }
            return true;
        }
        return false;
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
