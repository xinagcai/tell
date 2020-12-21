package com.example.tell;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        btLogin = findViewById(R.id.login);
        account = findViewById(R.id.editAccount);
        password = findViewById(R.id.editPassword);
        helper = new DBOpenHelper(this);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               login(account.getText().toString().trim(),password.getText().toString().trim());
            }
        });
    }
    private void login(String account,String pwd){
        if(StringUtils.isEmpty(account)){
            showToast("请输入账号");
            return;
        }
        if(StringUtils.isEmpty(pwd)){
            showToast("请输入密码");
            return;
        }

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("user",null,"account=?",new String[]{account+""},null,null,null);
        if (cursor.getCount()==0){
            showToast("该用户不存在");
        }else {
            cursor.moveToFirst();
            if(pwd.equals(cursor.getString(4))){
                navigation(HomeAcitivity.class);
            }else {
                showToast("密码错误");
            }
        }


    }
}