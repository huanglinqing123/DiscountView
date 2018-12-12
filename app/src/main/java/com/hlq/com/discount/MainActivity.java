package com.hlq.com.discount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

        discountView.setDiscountNumber("8");
        discountView.setTextBig("测试");
        discountView.setTextSamll("sad4545");
    }
}
