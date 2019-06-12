package com.lizehao.watermelondiarynew.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.lizehao.watermelondiarynew.PhotoWall.image;
import com.lizehao.watermelondiarynew.R;
import com.lizehao.watermelondiarynew.PhotoWall.PhotoWallAdapter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllImageActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, AllImageActivity.class);
        context.startActivity(intent);
    }

    /**
     * 用于展示照片墙的GridView
     */
    private GridView mPhotoWall;

    /**
     * GridView的适配器
     */
    private PhotoWallAdapter adapter;

    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_image);
        ButterKnife.bind(this);

        mPhotoWall = (GridView) findViewById(R.id.photo_wall);
        adapter = new PhotoWallAdapter(this, 0, image.imageThumbUrls, mPhotoWall);
        mPhotoWall.setAdapter(adapter);
        mPhotoWall.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("date111", "allclick"+i);
                index = i;
                Intent intent = new Intent(AllImageActivity.this, RecommendActivity.class);
                if(index>=0)
                    intent.putExtra("dateI", index);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 退出程序时结束所有的下载任务
        adapter.cancelAllTasks();
    }

    @OnClick({R.id.bt_AllToMenu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_AllToMenu:
                MenuActivity.startActivity(this);
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
