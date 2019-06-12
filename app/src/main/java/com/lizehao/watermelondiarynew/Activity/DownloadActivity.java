package com.lizehao.watermelondiarynew.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lizehao.watermelondiarynew.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DownloadActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, DownloadActivity.class);
        context.startActivity(intent);
    }

    int index = -2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        ButterKnife.bind(this);
        ImageView IV = (ImageView) findViewById(R.id.dl_img);
        IV.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        index = intent.getIntExtra("date_dl", -2);
        switch (index) {
            case 0: IV.setImageDrawable(getDrawable(R.drawable.j01)); break;
            case 1: IV.setImageDrawable(getDrawable(R.drawable.j02)); break;
            case 2: IV.setImageDrawable(getDrawable(R.drawable.j03)); break;
            case 3: IV.setImageDrawable(getDrawable(R.drawable.j04)); break;
            case 4: IV.setImageDrawable(getDrawable(R.drawable.j05)); break;
            case 5: IV.setImageDrawable(getDrawable(R.drawable.j06)); break;
            case 6: IV.setImageDrawable(getDrawable(R.drawable.j07)); break;
            case 7: IV.setImageDrawable(getDrawable(R.drawable.j08)); break;
            case 8: IV.setImageDrawable(getDrawable(R.drawable.j09)); break;
            case 9: IV.setImageDrawable(getDrawable(R.drawable.j10)); break;
            case 10: IV.setImageDrawable(getDrawable(R.drawable.j11)); break;
            case 11: IV.setImageDrawable(getDrawable(R.drawable.j12)); break;
            case 12: IV.setImageDrawable(getDrawable(R.drawable.j13)); break;
            case 13: IV.setImageDrawable(getDrawable(R.drawable.j14)); break;
            case 14: IV.setImageDrawable(getDrawable(R.drawable.j15)); break;
            case 15: IV.setImageDrawable(getDrawable(R.drawable.j16)); break;
            case 16: IV.setImageDrawable(getDrawable(R.drawable.j17)); break;
            case 17: IV.setImageDrawable(getDrawable(R.drawable.j18)); break;
            case 18: IV.setImageDrawable(getDrawable(R.drawable.j19)); break;
            case 19: IV.setImageDrawable(getDrawable(R.drawable.j20)); break;
            case 20: IV.setImageDrawable(getDrawable(R.drawable.j21)); break;
            case 21: IV.setImageDrawable(getDrawable(R.drawable.j22)); break;
            case 22: IV.setImageDrawable(getDrawable(R.drawable.j23)); break;
            case 23: IV.setImageDrawable(getDrawable(R.drawable.j24)); break;
            case 24: IV.setImageDrawable(getDrawable(R.drawable.j25)); break;
            case 25: IV.setImageDrawable(getDrawable(R.drawable.j26)); break;
            case 26: IV.setImageDrawable(getDrawable(R.drawable.j27)); break;
            case 27: IV.setImageDrawable(getDrawable(R.drawable.j28)); break;
            case 28: IV.setImageDrawable(getDrawable(R.drawable.j29)); break;
            case 29: IV.setImageDrawable(getDrawable(R.drawable.j30)); break;
            case 30: IV.setImageDrawable(getDrawable(R.drawable.j31)); break;
            case 31: IV.setImageDrawable(getDrawable(R.drawable.j01)); break;
            case 32: IV.setImageDrawable(getDrawable(R.drawable.f02)); break;
            case 33: IV.setImageDrawable(getDrawable(R.drawable.f03)); break;
            case 34: IV.setImageDrawable(getDrawable(R.drawable.f04)); break;
            case 35: IV.setImageDrawable(getDrawable(R.drawable.f05)); break;
            case 36: IV.setImageDrawable(getDrawable(R.drawable.f06)); break;
            case 37: IV.setImageDrawable(getDrawable(R.drawable.f07)); break;
            case 38: IV.setImageDrawable(getDrawable(R.drawable.f08)); break;
            case 39: IV.setImageDrawable(getDrawable(R.drawable.f09)); break;
            case 40: IV.setImageDrawable(getDrawable(R.drawable.f10)); break;
            case 41: IV.setImageDrawable(getDrawable(R.drawable.f11)); break;
            case 42: IV.setImageDrawable(getDrawable(R.drawable.f12)); break;
            case 43: IV.setImageDrawable(getDrawable(R.drawable.f13)); break;
            case 44: IV.setImageDrawable(getDrawable(R.drawable.f14)); break;
            case 45: IV.setImageDrawable(getDrawable(R.drawable.f15)); break;
            case 46: IV.setImageDrawable(getDrawable(R.drawable.f16)); break;
            case 47: IV.setImageDrawable(getDrawable(R.drawable.f17)); break;
            case 48: IV.setImageDrawable(getDrawable(R.drawable.f18)); break;
            case 49: IV.setImageDrawable(getDrawable(R.drawable.f19)); break;
            case 50: IV.setImageDrawable(getDrawable(R.drawable.f20)); break;
            case 51: IV.setImageDrawable(getDrawable(R.drawable.f21)); break;
            case 52: IV.setImageDrawable(getDrawable(R.drawable.f22)); break;
            case 53: IV.setImageDrawable(getDrawable(R.drawable.f23)); break;
            case 54: IV.setImageDrawable(getDrawable(R.drawable.f24)); break;
            case 55: IV.setImageDrawable(getDrawable(R.drawable.f25)); break;
            case 56: IV.setImageDrawable(getDrawable(R.drawable.f26)); break;
            case 57: IV.setImageDrawable(getDrawable(R.drawable.f27)); break;
            case 58: IV.setImageDrawable(getDrawable(R.drawable.f28)); break;
            case 59: IV.setImageDrawable(getDrawable(R.drawable.f29)); break;
            case 60: IV.setImageDrawable(getDrawable(R.drawable.m01)); break;
            case 61: IV.setImageDrawable(getDrawable(R.drawable.m02)); break;
            case 62: IV.setImageDrawable(getDrawable(R.drawable.m03)); break;
            case 63: IV.setImageDrawable(getDrawable(R.drawable.m04)); break;
            case 64: IV.setImageDrawable(getDrawable(R.drawable.m05)); break;
            case 65: IV.setImageDrawable(getDrawable(R.drawable.m06)); break;
            case 66: IV.setImageDrawable(getDrawable(R.drawable.m07)); break;
            case 67: IV.setImageDrawable(getDrawable(R.drawable.m08)); break;
            case 68: IV.setImageDrawable(getDrawable(R.drawable.m09)); break;
            case 69: IV.setImageDrawable(getDrawable(R.drawable.m10)); break;
            case 70: IV.setImageDrawable(getDrawable(R.drawable.m11)); break;
            case 71: IV.setImageDrawable(getDrawable(R.drawable.m12)); break;
            case 72: IV.setImageDrawable(getDrawable(R.drawable.m13)); break;
            case 73: IV.setImageDrawable(getDrawable(R.drawable.m14)); break;
            case 74: IV.setImageDrawable(getDrawable(R.drawable.m15)); break;
            case 75: IV.setImageDrawable(getDrawable(R.drawable.m16)); break;
            case 76: IV.setImageDrawable(getDrawable(R.drawable.m17)); break;
            case 77: IV.setImageDrawable(getDrawable(R.drawable.m18)); break;
            case 78: IV.setImageDrawable(getDrawable(R.drawable.m19)); break;
            case 79: IV.setImageDrawable(getDrawable(R.drawable.m20)); break;
            case 80: IV.setImageDrawable(getDrawable(R.drawable.m21)); break;
            case 81: IV.setImageDrawable(getDrawable(R.drawable.m22)); break;
            case 82: IV.setImageDrawable(getDrawable(R.drawable.m23)); break;
            case 83: IV.setImageDrawable(getDrawable(R.drawable.m24)); break;
            case 84: IV.setImageDrawable(getDrawable(R.drawable.m25)); break;
            case 85: IV.setImageDrawable(getDrawable(R.drawable.m26)); break;
            case 86: IV.setImageDrawable(getDrawable(R.drawable.m27)); break;
            case 87: IV.setImageDrawable(getDrawable(R.drawable.m28)); break;
            case 88: IV.setImageDrawable(getDrawable(R.drawable.m29)); break;
            case 89: IV.setImageDrawable(getDrawable(R.drawable.m30)); break;
            case 90: IV.setImageDrawable(getDrawable(R.drawable.m31)); break;
            default: break;
        }
        IV.setVisibility(View.VISIBLE);

    }

    @OnClick({R.id.bt_DlToRecom, R.id.bt_dl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_DlToRecom:
                Intent intent = new Intent(DownloadActivity.this, RecommendActivity.class);
                if(index > -2)
                    intent.putExtra("dateI", index);
                startActivity(intent);
                break;
            case R.id.bt_dl:
                Toast.makeText(DownloadActivity.this, "download successfully", Toast.LENGTH_SHORT).show();
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
