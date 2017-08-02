package com.example.viewknowledgedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "9095";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        setContentView(R.layout.activity_main);

        //最小滑动距离，每个设备可能不同，本锤子是24
        int scaledTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        Log.d(TAG, "scaledTouchSlop " + scaledTouchSlop);

        //这种方式得到的就是Activity所设置的View
        ((ViewGroup)getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);


    }
}
