package com.example.baitaplonandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "baithi.db";

    public DBHelper(Context context) {
        super(context,DBNAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table if not exists users(username text primary key, password text,name text)");
    db.execSQL("create table if not exists story(id Integer primary key autoincrement , tenDe text, cauDung text, cauSai text, tongCau text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("drop table if exists users");
    db.execSQL("drop table if exists story");
    onCreate(db);
    }

    public Boolean insertData(String username, String password, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        values.put("name",name);
        long result = db.insert("users",null,values);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Boolean insertDataStory(String tenDe, String cauDung, String cauSai, String tongCau){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("tenDe",tenDe);
        values.put("cauDung",cauDung);
        values.put("cauSai",cauSai);
        values.put("tongCau",tongCau);
        long result = db.insert(" story",null,values);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Boolean checkUserName(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?",new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkUserNamePassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?",new String[] {username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public String getName(String username, String password){
        String ten = "utwrthtrh";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor dataName = db.rawQuery("select name from users where username = ? and password = ?", new String[] {username,password});
        while(dataName.moveToNext()){
             ten = dataName.getString(0);
        }
        return ten;
    }

    public void queryData(String sql){
        SQLiteDatabase dtb = getWritableDatabase();
        dtb.execSQL(sql);
        onCreate(dtb);
    }

    public Cursor getData(String sql){
        SQLiteDatabase dtb = getReadableDatabase();
        return dtb.rawQuery(sql,null);
    }

    public String getUser(String username, String password){
        String ten = "utwrthtrh";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor dataName = db.rawQuery("select username from users where username = ? and password = ?", new String[] {username,password});
        while(dataName.moveToNext()){
            ten = dataName.getString(0);
        }
        return ten;
    }

    public String getPassword(String username, String password){
        String ten = "utwrthtrh";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor dataName = db.rawQuery("select password from users where username = ? and password = ?", new String[] {username,password});
        while(dataName.moveToNext()){
            ten = dataName.getString(0);
        }
        return ten;
    }
}
