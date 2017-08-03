package com.example.viewknowledgedemo.drawprocess;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangjinbo on 17-8-3.
 */

public class MyLayoutView extends View {

    public MyLayoutView(Context context) {
        super(context);
    }

    public MyLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 实验证明，是可以通过修改自己的layout让自己跑到任意地方的。
     * 比如让LinearLayout也可以叠加View
     *
     *
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    public void layout(@Px int l, @Px int t, @Px int r, @Px int b) {
        super.layout(100, 100, 100 + getMeasuredWidth(), 100 + getMeasuredHeight());
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
