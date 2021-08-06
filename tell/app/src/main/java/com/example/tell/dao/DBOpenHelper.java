package com.example.tell.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.tell.R;


public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(@Nullable Context context) {
        super(context, "tell.db", null, 2);
    }

    // 修改此方法后需要删除原来的数据库文件，关闭虚拟机，关闭app，重新启动，否则不会运行
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql[]={
                "create table if not exists user ( avatar integer ,account text primary key, pwd text, name text,sex text,birth text)",
                "create table if not exists email (fro text,sendto text, detail text)",
                "INSERT INTO user VALUES('"+ R.mipmap.avater+"','123','123123','香菜','女','2000-02-05')",
                "INSERT INTO email VALUES('来时的无花果','tell收','有一天，网上很多问我，说马老师，发生什么事了，我一般，一个视频，两个年轻人不讲武德，我大意了，我劝你们耗子尾汁')",
                "INSERT INTO email VALUES('来时的无花果','tell收','有一天，网上很多问我，说马老师，发生什么事了，我一般，一个视频，两个年轻人不讲武德，我大意了，我劝你们耗子尾汁')",
                "INSERT INTO email VALUES('来时的无花果','tell收','有一天，网上很多问我，说马老师，发生什么事了，我一般，一个视频，两个年轻人不讲武德，我大意了，我劝你们耗子尾汁')",
                "INSERT INTO email VALUES('tell','香菜收','有一天，网上很多问我，说马老师，发生什么事了，我一般，一个视频，两个年轻人不讲武德，我大意了，我劝你们耗子尾汁')",
                "INSERT INTO email VALUES('tell','香菜收','有一天，网上很多问我，说马老师，发生什么事了，我一般，一个视频，两个年轻人不讲武德，我大意了，我劝你们耗子尾汁')",
                "INSERT INTO email VALUES('香菜','tell收','有一天，网上很多问我，说马老师，发生什么事了，我一般，一个视频，两个年轻人不讲武德，我大意了，我劝你们耗子尾汁')",
                "INSERT INTO email VALUES('香菜','tell收','有一天，网上很多问我，说马老师，发生什么事了，我一般，一个视频，两个年轻人不讲武德，我大意了，我劝你们耗子尾汁')",
        };
        for(int i=0;i<sql.length;i++){
            sqLiteDatabase.execSQL(sql[i]);
        }
        // ContentActivity所使用的页面
//
//        createUser(sqLiteDatabase);
//        createEmail(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int count(String name, SQLiteDatabase sqLiteDatabase) {
        Cursor cursor = sqLiteDatabase.rawQuery("select count(*) count from " + name, null);
        cursor.moveToNext();
        int count = cursor.getInt(cursor.getColumnIndex("count"));
        cursor.close();
        return count;
    }

//    public void createUser(SQLiteDatabase sqLiteDatabase) {
////        if (count("user", sqLiteDatabase) > 0) {
////            Log.d("createUser", "已有数据，不需要再插入");
////            return;
////        }
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("avatar", R.mipmap.avater);
//        contentValues.put("name", "王霸之气");
//        contentValues.put("account", "123");
//        contentValues.put("pwd", "123123");
//        contentValues.put("sex", "女");
//        contentValues.put("birth", "2000-03-05");
//        sqLiteDatabase.insert("user", null, contentValues);
//
//        contentValues = new ContentValues();
//        contentValues.put("avatar", R.mipmap.avater);
//        contentValues.put("name", "猪猪侠");
//        contentValues.put("account", "135");
//        contentValues.put("pwd", "123123");
//        contentValues.put("sex", "女");
//        contentValues.put("birth", "2000-03-05");
//        sqLiteDatabase.insert("user", null, contentValues);
//
//    }
//
//    /**
//     * ContentActivity所使用的数据库，初始化数据
//     *
//     * @param sqLiteDatabase
//     */
//    public void createEmail(SQLiteDatabase sqLiteDatabase) {
//        Log.d("createEmail", "初始化数据");
////        if (count("email", sqLiteDatabase) > 0) {
////            Log.d("createContent", "已有数据，不需要再插入");
////            return;
////        }
//
//        // 插入数据
//        for (int i = 0; i < 3; ++i) {
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("fro", "123");
//            contentValues.put("sendto", "135");
//            contentValues.put("detail", "我好可怜啊");
//            contentValues.put("next", "");
//            contentValues.put("pre", "");
//            sqLiteDatabase.insert("content", null, contentValues);
//        }
//
//        Log.d("createEmail", "初始化数据完成");
//    }

}
