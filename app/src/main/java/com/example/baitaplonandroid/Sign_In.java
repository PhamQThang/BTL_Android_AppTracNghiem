package com.example.baitaplonandroid;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Sign_In extends AppCompatActivity {
    EditText username,password;
    TextView signup,hientk,hienmk,hien;
    Button signin;
    DBHelper db;
    public static String Uname;
    public static String tk;
    public static String mk;

    public static String getMk() {
        return mk;
    }

    public static void setMk(String mk) {
        Sign_In.mk = mk;
    }

    public static String getTk() {
        return tk;
    }

    public static void setTk(String tk) {
        Sign_In.tk = tk;
    }

    public static String getUname() {
        return Uname;
    }

    public static void setUname(String uname) {
        Uname = uname;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_nhap);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password1);
        signin = (Button) findViewById(R.id.signin1);
        signup = (TextView) findViewById(R.id.signup1);
        hientk = (TextView) findViewById(R.id.hientk);
        hienmk = (TextView) findViewById(R.id.hienmk);
        hien = (TextView) findViewById(R.id.textView10);
        db = new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user)){
                    Toast.makeText(Sign_In.this,"Ban chua nhap du lieu",Toast.LENGTH_SHORT).show();
                    hientk.setText("Bạn chưa nhập dữ liệu");
                    hien.setText(null);
                    hienmk.setText(null);
                }
                else if(TextUtils.isEmpty(pass)){
                    Toast.makeText(Sign_In.this,"Ban chua nhap du lieu",Toast.LENGTH_SHORT).show();
                    hienmk.setText("Bạn chưa nhập dữ liệu");
                    hien.setText(null);
                    hientk.setText(null);
                }
                else {
                    Boolean checkuserpass = db.checkUserNamePassword(user, pass);
                    if(checkuserpass == true){
                        setUname(db.getName(user,pass));
                        setTk(db.getUser(user,pass));
                        setMk(db.getPassword(user,pass));
                        Toast.makeText(Sign_In.this,"Ban da dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(Sign_In.this,"Dang nhap that bai",Toast.LENGTH_SHORT).show();
                        hien.setText("Thông tin tài khoản hoặc mật khẩu không chính xác !");
                        hientk.setText(null);
                        hienmk.setText(null);
                    }
                }


            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Sign_Up.class);
                startActivity(intent);
            }
        });
    }
}
