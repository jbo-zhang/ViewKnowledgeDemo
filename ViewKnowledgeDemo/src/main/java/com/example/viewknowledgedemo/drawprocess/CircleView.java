package com.example.viewknowledgedemo.drawprocess;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.viewknowledgedemo.R;

/**
 * Created by zhangjinbo on 17-8-3.
 */

public class CircleView extends View {
    private int mColor = Color.RED;
    private Paint mPaint;


    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        mColor = ta.getColor(R.styleable.CircleView_circle_color, Color.RED);
        ta.recycle();

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if(widthMode == MeasureSpec.AT_MOST && heightMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(getSuggestedMinimumWidth(), 200);
        } else if(widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(getSuggestedMinimumWidth(), heightSize);
        } else if(heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, 200);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();

        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;

        int radius = Math.min(width, height) / 2;
        mPaint.setColor(mColor);
        canvas.drawCircle(paddingLeft + width/2, paddingTop + height/2, radius, mPaint);
    }
}
