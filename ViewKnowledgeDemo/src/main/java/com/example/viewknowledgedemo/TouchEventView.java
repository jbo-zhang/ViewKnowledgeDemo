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

    private int mLastX, mLastY;
    /**
     * 分发
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //内部拦截法, 父类要配合在onInterceptTouchEvent中的DOWN事件返回false
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                if(parentShouldIntercept(event)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;

        return super.dispatchTouchEvent(event);
    }

    /**
     * 在这里书写需要父类拦截的规则，需要父类处理返回true, 不需要返回false
     * @param event
     * @return
     */
    private boolean parentShouldIntercept(MotionEvent event) {
        return false;
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
