package com.example.tell.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tell.entity.Email;

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(initLayout());
        initView();
        initDate();
    }

    public void showToast(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }

    public void navigation(Class cls){
        Intent in = new Intent(mContext,cls);
        startActivity(in);
    }
    public void navigationExtra(Class cls, Email email){
        Intent in = new Intent(mContext,cls);
        in.putExtra("emailEntity",email);
        startActivity(in);
    }

    protected abstract int initLayout();
    protected abstract void initView();
    protected abstract void initDate();
}
