package com.lizehao.watermelondiarynew.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.lizehao.watermelondiarynew.PhotoWall.PhotoCollectAdapter;
import com.lizehao.watermelondiarynew.PhotoWall.PhotoWallAdapter;
import com.lizehao.watermelondiarynew.PhotoWall.image;
import com.lizehao.watermelondiarynew.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectActivity extends AppCompatActivity {

    private GridView mPhotoCollect;
    private PhotoCollectAdapter adapter;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ButterKnife.bind(this);

        mPhotoCollect = (GridView) findViewById(R.id.photo_collect);
        adapter = new PhotoCollectAdapter(this, 0, image.imageThumbUrls, mPhotoCollect);
        mPhotoCollect.setAdapter(adapter);
        /*
        mPhotoCollect.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("date111", "allclick"+i);
                index = i;
                Intent intent = new Intent(CollectActivity.this, RecommendActivity.class);
                if(index>=0)
                    intent.putExtra("dateI", index);
                startActivity(intent);
            }
        });*/
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, CollectActivity.class);
        context.startActivity(intent);
    }


    @OnClick({R.id.bt_CollectToMenu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_CollectToMenu:
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
