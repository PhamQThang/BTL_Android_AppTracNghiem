package com.example.baitaplonandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitaplonandroid.danhSachDeThi.Adapter_De_Thi;
import com.example.baitaplonandroid.danhSachDeThi.Item_De_Thi;

import java.util.ArrayList;

public class Danh_Sach_De_Thi extends AppCompatActivity {
    private ArrayList<Item_De_Thi> deThiArrayList;
    private Adapter_De_Thi adapterDeThi;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thitracnghiem);

        listView = (ListView) findViewById(R.id.thitracnghiem);

        deThiArrayList = new ArrayList<>();
        deThiArrayList.add(new Item_De_Thi(R.drawable.de_thi,"Đề số 1"));
        deThiArrayList.add(new Item_De_Thi(R.drawable.de_thi,"Đề số 2"));
        deThiArrayList.add(new Item_De_Thi(R.drawable.de_thi,"Đề số 3"));
        adapterDeThi = new Adapter_De_Thi(this,deThiArrayList,R.layout.item_thi);
        listView.setAdapter(adapterDeThi);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0) {
                    Intent intent = new Intent(Danh_Sach_De_Thi.this,De_So_1.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("dethi", "Đề Số 1");
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                else if(i==1) {
                    Intent intent = new Intent(Danh_Sach_De_Thi.this, De_So_2.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("dethi", "Đề Số 2");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else if(i==2)
                    Toast.makeText(Danh_Sach_De_Thi.this,"Bai Kiem Tra 3",Toast.LENGTH_LONG).show();
            }
        });
    }
}
