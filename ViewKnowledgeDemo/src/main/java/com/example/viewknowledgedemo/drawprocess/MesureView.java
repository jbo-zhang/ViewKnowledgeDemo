package com.example.viewknowledgedemo.drawprocess;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zhangjinbo on 1783.
 */

public class MesureView extends View {
    public MesureView(Context context) {
        super(context);
    }

    public MesureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MesureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private TextView mTextBound;

    /**
     * onMeasure的经典写法
     * View的最终大小在layout阶段确定，measure是建议，不过一般八九不离十
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int measureHeight(int measureSpec) {
        int mode = MeasureSpec.getMode(measureSpec);
        int val = MeasureSpec.getSize(measureSpec);
        int result = 0;
        switch (mode) {
            case MeasureSpec.EXACTLY:
                result = val;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                result = getSuggestedMinimumHeight();
                break;
        }
        result = mode == MeasureSpec.AT_MOST ? Math.min(result, val) : result;
        return result + getPaddingTop() + getPaddingBottom();
    }

    private int measureWidth(int measureSpec) {
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        int result = 0;
        switch (mode) {
            case MeasureSpec.EXACTLY:
                result = size;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                result = getSuggestedMinimumWidth();
                break;
        }

        result = mode == MeasureSpec.AT_MOST ? Math.min(result, size) : result;
        return result + getPaddingLeft() + getPaddingRight();
    }


    /**
     * getSuggestedMinimumWidth()源码
     *
     * 根据View的背景与android：minWidth属性的值去确定
     *
     * protected int getSuggestedMinimumWidth() {
     *     return (mBackgroud == null) ? mMinWidth : max(mWinWidth, mBackground.getMinimumWidth());
     * }
     *
     * mBackground.getMinimumWidth返回的是Drawable的原始宽度
     *
     * public int getMinimumWidth() {
     *     final int intrinsicWidth = getIntrinsicWidth();
     *     return intrinsicWidth > 0 ? intrinsicWidth : 0;
     * }
     */


}
