package com.lizehao.watermelondiarynew.Calendar;

import android.content.Context;
import android.widget.Toast;

import butterknife.ButterKnife;


public class ToastUtil {
    private static Toast mToast;

    public static void showToast(Context context,String desc){
        if (mToast == null){
            mToast = Toast.makeText(context.getApplicationContext(),desc,Toast.LENGTH_SHORT);
        }else{
            mToast.setText(desc);
        }
        mToast.show();
    }

}
