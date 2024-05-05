package com.example.baitaplonandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Chinh_Sach extends AppCompatActivity {
    TextView textView;
    Button pre,next;
    int i=0,n = 0;
    static final String s[] = {
            "Mỗi đề thi sẽ có 10 câu hỏi",
            "Mỗi câu hỏi bạn sẽ nhận được 1 điểm",
            "Điểm sẽ được tổng kết và lưu lại ở phần Lịch Sử",
            "Cám ơn các bạn đã sử dụng ứng dụng của chúng tôi"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chinh_sach);
        textView = (TextView) findViewById(R.id.tv);
        pre = (Button) findViewById(R.id.pre);
        next = (Button) findViewById(R.id.next);

        textView.setText(s[n]);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<=3){
                    if(i==0) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        i = 0;
                        n = 0;
                    }
                    else
                    {
                        textView.setText(s[n-1]);
                        n--;
                        i--;
                    }
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i<=3){
                    if(i==3) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        i = 0;
                        n = 0;
                    }
                    else
                    {
                        textView.setText(s[n+1]);
                        i++;
                        n++;
                    }
                }
            }
        });


    }
}
