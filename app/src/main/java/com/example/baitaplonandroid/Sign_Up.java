package com.example.baitaplonandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_Up extends AppCompatActivity {
    EditText name,username, password, repassword;
    Button signup;
    TextView signin;
    DBHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_ky);

        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password1);
        signin = (TextView) findViewById(R.id.signin1);
        signup = (Button) findViewById(R.id.signup1);
        repassword = (EditText) findViewById(R.id.repassword1);
        db = new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = name.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(Sign_Up.this,"Ban chua nhap du lieu",Toast.LENGTH_SHORT).show();
                else {
                    Boolean check = check_pass(pass);
                    if(check==false){
                        Toast.makeText(Sign_Up.this, "Mật Khẩu Phải Trên 8 Chữ Số + Có Ký Tự Hoa + Ký Tự Đặc Biệt", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if (pass.equals(repass)) {
                            Boolean checkuser = db.checkUserName(user);
                            if (checkuser == false) {
                                Boolean insert = db.insertData(user, pass, uname);
                                if (insert == true) {
                                    Sign_In.setUname(uname);
                                    Toast.makeText(Sign_Up.this, "Ban da dang ky thanh cong", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else
                                    Toast.makeText(Sign_Up.this, "Dang ky that bai", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(Sign_Up.this, "Nguoi dung da ton tai", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(Sign_Up.this, "Mật khẩu không giống nhau. Đăng Ký Thất Bại !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Sign_In.class);
                startActivity(intent);
            }
        });
    }
    public static boolean check_pass(String password)
    {
        if(password.length()>=8)
        {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasLetter.find() && hasDigit.find() && hasSpecial.find();

        }
        else
            return false;

    }
}

