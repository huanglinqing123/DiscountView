package com.hlq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Huanglinqing
 * @create 2018 - 12 - 06 -8:45
 * 打折View
 */

public class DiscountView extends TextView {


    private Paint paintFrame;
    private Paint paintDiscount;
    private Path path;
    private Paint paintDisText;
    private String discountNumber = "9折";
    private boolean isDiscount = true;
    private int boderColor = Color.parseColor("#18abbb");

    public DiscountView(Context context) {
        super(context);
        init();
    }

    public DiscountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DiscountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    /**
     * 初始化
     */
    private void init() {
        paintFrame = new Paint();
        paintDiscount = new Paint();
        paintDisText = new Paint();
        paintFrame.setAntiAlias(true);
        paintFrame.setColor(boderColor);
        paintDisText.setAntiAlias(true);
        paintDisText.setColor(Color.WHITE);
        paintDisText.setStyle(Paint.Style.STROKE);
        paintFrame.setStrokeWidth(2f);
        paintFrame.setStyle(Paint.Style.STROKE);
        paintDiscount.setColor(Color.RED);
        paintDiscount.setStyle(Paint.Style.FILL);
    }


    /**
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int left = width / 4;
        int top = height / 4;
        int right = width - width / 4;
        int bottom = height - height / 4;

        int viewHeight = bottom - top;
        int viewWidth = right - left;
        canvas.drawRect(left, top, right, bottom, paintFrame);

        if (isDiscount) {
            /**
             * 绘制打折
             */
            path = new Path();
            path.moveTo(left, top + viewHeight / 4);
            path.lineTo(left + viewWidth / 4, top);
            path.lineTo(left + viewWidth / 2, top);
            path.lineTo(left, top + viewHeight / 2);
            path.close();
            canvas.drawPath(path, paintDiscount);

            /**
             * 绘制折扣文字
             */
            paintDisText.setTextSize(35f);
            paintDisText.setTextAlign(Paint.Align.LEFT);
            float hOffset = (float) Math.cos(45f) * (viewHeight / 4);
            float vOffset = (float) ((Math.cos(45f) * (viewHeight / 2)) - (Math.cos(45f) * (viewHeight / 4)));
            canvas.drawTextOnPath(discountNumber, path, hOffset, vOffset, paintDisText);
        }


    }

    /**
     * 设置折扣数量
     * 默认是9折
     *
     * @param discountNumber
     */
    public void setDiscountNumber(String discountNumber) {
        this.discountNumber = discountNumber;
        invalidate();
    }

    /**
     * 设置是否绘制打折 默认为true
     *
     * @param discount
     */
    public void setDiscount(boolean discount) {
        this.isDiscount = discount;
        invalidate();
    }

    /**
     * 设置边框颜色 默认为浅蓝绿
     *
     * @param boderColor
     */
    public void setBoderColor(int boderColor) {
        this.boderColor = boderColor;
    }

}
