package com.example.baitaplonandroid.lichSu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baitaplonandroid.DBHelper;
import com.example.baitaplonandroid.Ket_Qua_Sau_Thi;
import com.example.baitaplonandroid.MainActivity;
import com.example.baitaplonandroid.R;
import com.example.baitaplonandroid.Sign_In;

import java.util.ArrayList;

public class LichSu extends AppCompatActivity {

    ListView listView;
    Context context;
    Button goback;
    ArrayList<ItemLichSu> arrayList;
    LichSuAdapter lichSuAdapter;
    //DataBaseLS dataBaseLS;
    DBHelper db;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DBHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lich_su_thi);
        context = this;
        listView = (ListView) findViewById(R.id.lvLichSu);
        goback = (Button) findViewById(R.id.goBack);
        arrayList = new ArrayList<>();
        lichSuAdapter = new LichSuAdapter(this,arrayList,R.layout.item_lich_su);
        listView.setAdapter(lichSuAdapter);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String de = bundle.getString("de");
        int a = bundle.getInt("correct");
        int b= bundle.getInt("wrong");
        int c = bundle.getInt("marks");

        String correct = "Số câu đúng : " + a;
        String wrong = "Số câu sai : " + b;
        String marks = "Tổng Số Câu : " + c;

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LichSu.this, MainActivity.class));
                finish();
            }
        });
        //db.queryData("drop table story");
        Boolean insert = db.insertDataStory(de,correct,wrong,marks);
        if(insert == true)
            Toast.makeText(this, "Ban Da Luu Thanh Cong", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Luu De Thi That Bai", Toast.LENGTH_SHORT).show();

        Cursor cursor = db.getData("select * from story ");
        while (cursor.moveToNext()){
            id = cursor.getInt(0);
            String tende = cursor.getString(1);
            String soCauDung =cursor.getString(2);
            String soCauSai = cursor.getString(3);
            String tongCau = cursor.getString(4);
            arrayList.add(new ItemLichSu(id,tende,soCauDung,soCauSai,tongCau));
        }

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Xác Nhận !");
                dialog.setMessage("Bạn có đồng ý xóa không ?");
                dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.queryData("delete from story where id = " + arrayList.get(pos).id + "");
                        arrayList.remove(pos);
                        lichSuAdapter.notifyDataSetChanged();
                    }
                });

                    dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertDialog = dialog.create();
                    alertDialog.show();
                    return false;
            }
        });

    }
}
