package com.hlq.com.discount;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;

import com.hlq.DiscountView;

/**
 * @author Huanglinqing
 */
public class MainActivity extends AppCompatActivity {

    private DiscountView discountView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        discountView = findViewById(R.id.textView);
        discountView.setText("800元");
        discountView.setTextSize(18);
        discountView.setDiscountNumber("8折");
    }
}
