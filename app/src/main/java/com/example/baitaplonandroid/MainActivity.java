package com.example.baitaplonandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitaplonandroid.lichSu.LichSuMau;

public class MainActivity extends AppCompatActivity {
    TextView thi,name;
    ImageView chinhSach,lichSu,phanHoi,dangXuat;
    DBHelper db;
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);

        thi = (TextView) findViewById(R.id.thi);
        chinhSach = (ImageView) findViewById(R.id.chinhsach);
        lichSu = (ImageView) findViewById(R.id.lichsu);
        phanHoi = (ImageView) findViewById(R.id.phanhoi);
        dangXuat = (ImageView) findViewById(R.id.dangxuat);
        name = (TextView) findViewById(R.id.name);
        DBHelper db = new DBHelper(this);
        dangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Sign Out...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Sign_In.class));
                finish();
            }
        });

        phanHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Phản Hồi...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Phan_Hoi.class));
                finish();
            }
        });

        chinhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Chinh Sach...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Chinh_Sach.class));
                finish();
            }
        });

        thi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Danh_Sach_De_Thi.class));
                finish();
            }
        });

        lichSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Lich Su...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LichSuMau.class));
                finish();
            }
        });

        name.setText("Xin chào : " + Sign_In.getUname());
  }
}