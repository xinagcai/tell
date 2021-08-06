package com.example.tell.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tell.R;

public class SetActivity extends BaseActivity {
    private ImageView imageBack;
    private TextView textBack;
    private Button exitbt;

    @Override
    protected int initLayout() {
        return R.layout.activity_set;

    }

    @Override
    protected void initDate() {
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        exitbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigation(LoginActivity.class);
            }
        });
    }

    @Override
    protected void initView() {

        imageBack = findViewById(R.id.imageback);
        textBack = findViewById(R.id.textback);
        exitbt = findViewById(R.id.exitbt);
    }

}