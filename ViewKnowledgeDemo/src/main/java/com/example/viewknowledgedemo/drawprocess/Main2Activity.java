package com.example.viewknowledgedemo.drawprocess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.viewknowledgedemo.R;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "9095";
    private View mTvText;
    private MyLayoutView myLayoutView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTvText = findViewById(R.id.tv_text);
        //得不到宽高，为0
        Log.d(TAG,"onCreate mTvText.getMeasuredWidth()" + mTvText.getMeasuredWidth());
        Log.d(TAG,"onCreate mTvText.getMeasuredHeight()" + mTvText.getMeasuredHeight());
        myLayoutView = (MyLayoutView) findViewById(R.id.my_layout_view);
        myLayoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "click MyLayoutView!");
                Toast.makeText(Main2Activity.this, "click MeasureView!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        //可以得到宽高
        if(hasFocus) {
            Log.d(TAG,"mTvText.getMeasuredWidth()" + mTvText.getMeasuredWidth());
            Log.d(TAG,"mTvText.getMeasuredHeight()" + mTvText.getMeasuredHeight());
        }
    }
}
