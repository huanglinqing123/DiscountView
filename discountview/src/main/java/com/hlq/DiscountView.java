package com.hlq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hlq.com.com.hlq.R;

/**
 * @author Huanglinqing
 * @create 2018 - 12 - 06 -8:45
 * 打折View
 */

public class DiscountView extends LinearLayout {

    private Paint paintDiscount;
    private Path path;
    private Paint paintDisText;
    private String discountNumber = "9折";
    private boolean isDiscount = true;

    private View mRoot;
    private TextView dataType;
    private TextView price;

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
        mRoot = LayoutInflater.from(getContext()).inflate(R.layout.view_layout, this);
        price = mRoot.findViewById(R.id.small);
        dataType = mRoot.findViewById(R.id.big);
        setWillNotDraw(false);
        initView();
    }


    /**
     * 初始化画笔等属性
     */
    private void initView() {
        paintDiscount = new Paint();
        paintDisText = new Paint();
        paintDisText.setAntiAlias(true);
        paintDisText.setColor(Color.WHITE);
        paintDisText.setStyle(Paint.Style.STROKE);
        paintDiscount.setColor(Color.RED);
        paintDiscount.setStyle(Paint.Style.FILL);
    }

    /**
     * 绘制标签
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = mRoot.getLeft();
        int top = mRoot.getTop();
        int right = mRoot.getRight();
        int bottom = mRoot.getBottom();

        int viewHeight = bottom - top;
        int viewWidth = right - left;


        if (isDiscount) {
            /**
             * 绘制打折
             */
            path = new Path();
            path.moveTo(0, viewHeight / 4);
            path.lineTo(viewWidth / 4, 0);
            path.lineTo(viewWidth / 2, 0);
            path.lineTo(0, viewHeight / 2);
            path.close();
            canvas.drawPath(path, paintDiscount);

//            /**
//             * 绘制折扣文字
//             */
            paintDisText.setTextSize(35f);
            paintDisText.setTextAlign(Paint.Align.LEFT);
            float hOffset = (float) (Math.sqrt((Math.pow(viewHeight / 4.0f, 2) + Math.pow(viewWidth / 4.0f, 2))) / 2.0f) -20f;
            float vOffset = (float) (viewHeight * viewWidth * Math.sqrt((Math.pow(viewHeight, 2) + Math.pow(viewWidth, 2))) / ((Math.pow(viewHeight, 2) + Math.pow(viewWidth, 2))) / 6.0f) + 3f;
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
     * 设置打折文字大小
     *
     * @param size
     */
    public void setDisCountNumber(float size) {
        paintDisText.setTextSize(size);
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
     * 设置较大文字
     */
    public void setTextBig(String big) {
        dataType.setText(big);
    }

    /**
     * 设置较小文字
     *
     * @param small
     */
    public void setTextSamll(String small) {
        price.setText(small);
    }

    /**
     * 设置较大文字大小
     *
     * @param size
     */
    public void setTextzieBig(float size) {
        dataType.setTextSize(size);
    }

    /**
     * 设置较小文字大小
     *
     * @param size
     */
    public void setTextzieSmall(float size) {
        price.setTextSize(size);
    }


}
