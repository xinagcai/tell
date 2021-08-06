package com.example.tell.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tell.R;
import com.example.tell.activity.BaseActivity;
import com.example.tell.activity.HomeAcitivity;
import com.example.tell.dao.DBOpenHelper;
import com.example.tell.entity.User;
import com.example.tell.util.StringUtils;


public class LoginActivity extends BaseActivity {
    private Button btLogin;
    private EditText account;
    private EditText password;
    private DBOpenHelper helper;

    @Override
    protected void initDate() {
        helper = new DBOpenHelper(this);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(account.getText().toString().trim(), password.getText().toString().trim());
            }
        });
    }

    @Override
    protected int initLayout() {
        return R.layout.login_activity;
    }

    @Override
    protected void initView() {

        btLogin = findViewById(R.id.login);
        account = findViewById(R.id.editAccount);
        password = findViewById(R.id.editPassword);
    }

    private void login(String account, String pwd) {
        if (StringUtils.isEmpty(account)) {
            showToast("请输入账号");
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
            showToast("请输入密码");
            return;
        }
//        if (!account.equals("123")) {
//            showToast("该用户不存在");
//            return;
//        }
//        if (!pwd.equals("123")){
//            showToast("密码错误");
//            return;
//        } showToast("登录成功");
//        navigation(HomeAcitivity.class);


        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where account=? ", new String[]{account});
//        System.out.println("kkkkkkkk"+cursor);
        if (cursor.getCount() == 0) {
            showToast("该用户不存在");
        } else {
            cursor.moveToFirst();
//            System.out.println(cursor.getString(3));
            if (pwd.equals(cursor.getString(2))) {
                navigation(HomeAcitivity.class);
            } else {
                showToast("密码错误");
            }
        }
    }
}