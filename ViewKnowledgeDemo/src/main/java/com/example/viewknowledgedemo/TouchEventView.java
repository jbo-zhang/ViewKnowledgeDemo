package com.example.viewknowledgedemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhangjinbo on 17-8-2.
 */

public class TouchEventView extends View {
    public TouchEventView(Context context) {
        super(context);
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 分发
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }


    /**
     * 处理
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
