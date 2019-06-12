package com.lizehao.watermelondiarynew.Activity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.lizehao.watermelondiarynew.R;
import com.lizehao.watermelondiarynew.ui.MainActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {

    private SoundPool pool;
    private Map<String, Integer> poolMap;
    boolean m = true;


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MenuActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        Log.d("munu111", "1");

        if(m) {
            poolMap = new HashMap<String, Integer>();
            // 实例化SoundPool，大小为1
            pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
            // 装载音频进音频池，并且把ID记录在Map中
            poolMap.put("bgm", pool.load(this, R.raw.bgm, 1));
        }

    }


    @OnClick({R.id.bt_MenuToHome, R.id.bt_MenuToDiary, R.id.bt_all, R.id.bt_about, R.id.bt_collection, R.id.bt_music, R.id.bt_theme})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_MenuToDiary:
                if (pool != null)
                    pool.play(poolMap.get("bgm"), 1.0f, 1.0f, 0, 0, 1.0f);
                MainActivity.startActivity(this);
                break;
            case R.id.bt_all:
                if (pool != null)
                    pool.play(poolMap.get("bgm"), 1.0f, 1.0f, 0, 0, 1.0f);
                AllImageActivity.startActivity(this);
                break;
            case R.id.bt_about:
                if (pool != null)
                    pool.play(poolMap.get("bgm"), 1.0f, 1.0f, 0, 0, 1.0f);
                AboutActivity.startActivity(this);
                break;
            case R.id.bt_collection:
                if (pool != null)
                    pool.play(poolMap.get("bgm"), 1.0f, 1.0f, 0, 0, 1.0f);
                CollectActivity.startActivity(this);
                break;
            case R.id.bt_music:
                Button music = (Button)findViewById(R.id.bt_music);
                //Log.d("alpha", "wuwuwu"+music.getAlpha());
                if(music.getAlpha() > 0.7) {
                    m = false;
                    music.setAlpha((float)0.6);
                    if (pool != null) {
                        pool.release();
                        pool = null;
                    }
                }
                else {
                    m = true;
                    music.setAlpha(1);
                    if(pool==null) {
                        poolMap = new HashMap<String, Integer>();
                        // 实例化SoundPool，大小为1
                        pool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
                        // 装载音频进音频池，并且把ID记录在Map中
                        poolMap.put("bgm", pool.load(this, R.raw.bgm, 1));
                    }
                }
                break;
            case R.id.bt_theme:
                if (pool != null)
                    pool.play(poolMap.get("bgm"), 1.0f, 1.0f, 0, 0, 1.0f);
                ThemeActivity.startActivity(this);
                break;
            case R.id.bt_MenuToHome:
                Main2Activity.startActivity(this);
                break;
        }
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
