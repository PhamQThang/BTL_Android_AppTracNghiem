package com.example.baitaplonandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Doi_Mat_Khau extends AppCompatActivity {
    EditText a,b;
    Button c;
    DBHelper db;
    String mkcu;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doimk);
        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        c = (Button) findViewById(R.id.c);
        db = new DBHelper(this);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mkcu = a.getText().toString();
                Boolean check = Sign_Up.check_pass(b.getText().toString());
                if(check == false){
                    Toast.makeText(Doi_Mat_Khau.this, "Mật Khẩu Phải Trên 8 Chữ Số + Có Ký Tự Hoa + Ký Tự Đặc Biệt", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (mkcu.equals(Sign_In.getMk())){
                        db.queryData("update users set password = " + "'" + b.getText().toString().trim() + "'" +
                                "where username = " + "'" + Sign_In.getTk() + "'" +
                                "and password = " + "'" + Sign_In.getMk()+ "'");
                        Toast.makeText(Doi_Mat_Khau.this,Sign_In.getTk() +  Sign_In.getMk(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                    else
                        Toast.makeText(Doi_Mat_Khau.this, Sign_In.getTk() +  Sign_In.getMk(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
