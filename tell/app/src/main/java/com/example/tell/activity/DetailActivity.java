package com.example.tell.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tell.R;
import com.example.tell.entity.Email;
import com.example.tell.fragment.BaseFragment;

public class DetailActivity extends BaseActivity {
    private Email email;
    private TextView detail;
    private ImageView imageBack;
    private TextView textBack;
    private Button answer;
    private Button hug;
    private ImageView image_hug;
    private TextView sendto;
    private TextView fro;


    @Override
    protected int initLayout() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initView() {
        detail = findViewById(R.id.detail);
        imageBack = findViewById(R.id.imageback);
        textBack = findViewById(R.id.textback);
        answer = findViewById(R.id.answer);
        hug = findViewById(R.id.hug);
        image_hug = findViewById(R.id.imagg_hug);
        fro = findViewById(R.id.fro);
        sendto = findViewById(R.id.sendto);

        email = (Email) getIntent().getSerializableExtra("emailEntity");
        detail.setText(email.getDetail());
        fro.setText(email.getFro());
        sendto.setText(email.getSendto());
    }

    @Override
    protected void initDate() {

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigation(HomeAcitivity.class);
            }
        });

        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigation(HomeAcitivity.class);
            }
        });

        answer.setOnClickListener(v -> {
            Intent intent = new Intent(this,AnswerActivity.class);
            intent.putExtra("emailEntity",email);
            startActivity(intent);
        });
        hug.setOnClickListener(view -> {
            image_hug.setImageResource(R.mipmap.hug);
        });

    }
}