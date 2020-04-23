package com.example.xposedtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btnChange;
    private TextView tvText;
    private String privateStrTest = "This is gg.";
    private List<CustomBean> customBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChange = findViewById(R.id.btn_change);
        Button newActivity = findViewById(R.id.btn_new);
        tvText = findViewById(R.id.tv_text);
        final Context context = this;

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvText.setText("天秤");
            }
        });

        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, LoginActivity.class);
                startActivity(intent);
            }
        });

        setCustomBeanList();

        Log.d(TAG, "onCreate: test private method = " + testPrivateMethod());
    }

    @Override
    protected void onResume() {
        super.onResume();
        privateStrTest = "on resume 的 privateStr";
    }

    public void setCustomBeanList() {
        customBeans = new ArrayList<>();

        CustomBean a = new CustomBean();
        a.setA("aaa");
        a.setB(111);
        a.setC(true);
        customBeans.add(a);

        CustomBean b = new CustomBean();
        a.setA("bbb");
        a.setB(222);
        a.setC(false);
        customBeans.add(b);

        CustomBean c = new CustomBean();
        a.setA("ccc");
        a.setB(333);
        a.setC(true);
        customBeans.add(c);
    }

    private boolean testPrivateMethod() {
        return false;
    }

    public void testCallParamMethod(CustomBean bean) {
        Log.d(TAG, "testCallParamMethod: a = " + bean.getA());
    }
}
