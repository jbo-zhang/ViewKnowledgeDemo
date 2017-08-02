package com.example.viewknowledgedemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by zhangjinbo on 17-8-2.
 */

public class TapAndScrollView extends View {
    private static final String TAG = "9095";
    private VelocityTracker mVelocityTracker;
    private GestureDetector mGestureDetector;
    private Scroller mScroller;
    private Paint mPaint;

    public TapAndScrollView(Context context) {
        this(context, null);
    }

    public TapAndScrollView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TapAndScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        mVelocityTracker = VelocityTracker.obtain();

        //不再需要时释放
//        mVelocityTracker.clear();
//        mVelocityTracker.recycle();

        mGestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                Log.d(TAG, "onDown!");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                Log.d(TAG, "onShowPress!");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                Log.d(TAG, "onSingleTapUp!");
                mScroller.startScroll(0,0,300,300,2000);

                /*
                此运算可行，说明Scroller这个类只提供连续的数值变化而已，跟View一点关系都没有，
                 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(mScroller.computeScrollOffset()) {
                            Log.d(TAG, "run: computeScroll: " + mScroller.computeScrollOffset()
                                    + "mScroller.getCurrX(): " + mScroller.getCurrX()
                                    + " mScroller.getCurrY(): " + mScroller.getCurrY());
                            post(new Runnable() {
                                @Override
                                public void run() {
                                    setX(mScroller.getCurrX());
                                    setY(mScroller.getCurrY());
                                }
                            });
                            SystemClock.sleep(20);
                        }
                    }
                }).start();
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                Log.d(TAG, "onScroll!");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                Log.d(TAG, "onLongPress!");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                Log.d(TAG, "onFling!");
                return false;
            }
        });

        mGestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                Log.d(TAG, "onSingleTapConfirmed!");
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                Log.d(TAG, "onDoubleTap!");
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                Log.d(TAG, "onDoubleTapEvent!");
                return false;
            }
        });

        mScroller = new Scroller(getContext());



        // mGestureDetector.setIsLongpressEnabled(false);


        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
    }

    @Override
    public void computeScroll() {
//        Log.d(TAG, "computeScroll: " + mScroller.computeScrollOffset()
//                + "mScroller.getCurrX(): " + mScroller.getCurrX()
//                + " mScroller.getCurrY(): " + mScroller.getCurrY());
        if(mScroller.computeScrollOffset()) {
            //可以直接设置x与y值实现位移
//            setX(mScroller.getCurrX());
//            setY(mScroller.getCurrY());

            //自己本身的scrollTo()只能将自己的内容移动，本身不能移动
            scrollTo(-mScroller.getCurrX(), -mScroller.getCurrY());

            //要想让自己移动，需要自己的父类scrollTo()
            //((View)getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());

            //为了持续触发computeScroll()
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //测量速度
        //cumputeVelocity(event);

        //分析手势
        boolean consume = mGestureDetector.onTouchEvent(event);

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100,100,50,mPaint);
    }

    private void cumputeVelocity(MotionEvent event) {
        mVelocityTracker.addMovement(event);
        mVelocityTracker.computeCurrentVelocity(1000);
        int xVelocity = (int) mVelocityTracker.getXVelocity();
        int yVelocity = (int) mVelocityTracker.getYVelocity();
        Log.d(TAG, "xVelocity: " + xVelocity + " yVelocity: " + yVelocity);
    }

}
