package com.example.pytorchobjectdetectionapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private Rect mRectSquare;
    private Paint mPaintSquare;

    public CustomView(Context context) {
        super(context);

        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    public void init(@Nullable AttributeSet set) {
        mRectSquare = new Rect();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSquare.setColor(Color.RED);
        mPaintSquare.setStrokeWidth(10);
        mPaintSquare.setStyle(Paint.Style.STROKE);

        mRectSquare.left = 10;
        mRectSquare.top = 10;

        mRectSquare.right = 100;
        mRectSquare.bottom = 100;
    }

    public void moveRectangle() {
//        Log.d("RECTANGLE", "Average luminosity: HOLAAAAAAAAAAAAAAAAAAAAAA");

        if(mRectSquare != null) {
            mRectSquare.left = ( mRectSquare.left + 10 ) % getWidth();
            mRectSquare.top = ( mRectSquare.top + 10 ) % getHeight();

            mRectSquare.right = (mRectSquare.left < ((mRectSquare.right + 10) % getWidth()))? (mRectSquare.right + 10) % getWidth() : mRectSquare.left + 90;
            mRectSquare.bottom = (mRectSquare.top < ((mRectSquare.bottom + 10) % getHeight()))? (mRectSquare.bottom + 10) % getHeight() : mRectSquare.top + 90;
        }

        postInvalidate();
//        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

//        mRectSquare.left = 50;
//        mRectSquare.top = 50;
//
//        mRectSquare.right = mRectSquare.left + 50;
//        mRectSquare.bottom = mRectSquare.top + 50;

        if(mRectSquare == null) {
            Paint clearPaint = new Paint();
            clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawRect(0, 0, 0, 0, clearPaint);
        } else {
            canvas.drawRect(mRectSquare, mPaintSquare);
        }
    }

    public boolean isThereRectangles() {
        return mRectSquare != null;
    }

    public void removeRectangle() {

        mRectSquare = null;
    }

    public void startRectangle() {

        mRectSquare = new Rect();
    }
}
