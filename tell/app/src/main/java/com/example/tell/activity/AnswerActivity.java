package com.example.tell.activity;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tell.R;
import com.example.tell.dao.DBOpenHelper;
import com.example.tell.entity.Email;

public class AnswerActivity extends BaseActivity {
    private Email email;
    private ImageView imageBack;
    private TextView textBack;
    private TextView sendto;
    private EditText answer;
    private Button send;
    private DBOpenHelper helper;


    @Override
    protected int initLayout() {
        return R.layout.activity_answer;
    }

    @Override
    protected void initView() {
        imageBack = findViewById(R.id.imageback);
        textBack = findViewById(R.id.textback);
        send = findViewById(R.id.send);
        sendto = findViewById(R.id.sendto);
        answer = findViewById(R.id.answer);
        email = (Email) getIntent().getSerializableExtra("emailEntity");
        sendto.setText(email.getFro()+"收");
    }

    @Override
    protected void initDate() {
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationExtra(DetailActivity.class,email);
            }
        });

        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigationExtra(DetailActivity.class,email);

            }
        });
        send.setOnClickListener(v -> {
            helper = new DBOpenHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("sendto", sendto.getText().toString());
            contentValues.put("detail", answer.getText().toString());
            contentValues.put("fro", "香菜");
            db.insert("email", null, contentValues);
            navigation(HomeAcitivity.class);
            showToast("发送成功");
        });

    }
}