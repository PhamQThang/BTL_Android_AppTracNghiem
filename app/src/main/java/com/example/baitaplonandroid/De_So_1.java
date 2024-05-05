package com.example.baitaplonandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class De_So_1 extends AppCompatActivity {
    TextView stt,noiDung,mTextField;
    RadioGroup radioGroup;
    RadioButton r1,r2,r3,r4;
    Button click,ketthuc;
    int i = 1, n = 0;
    String a;
    CountDownTimer Timer;
    public static int flag = 0, correct = 0, wrong = 0;
    static final String question[] = {
            "Who are all ________ people?",
            "Claude is ________.",
            "I ____ a car next year.",
            "They are all ________ ready for the party.",
            "When do you go ________ bed?",
            "London is famous for _____ red buses.",
            "Is there _____ milk in the fridge?",
            "There is a flower shop in front _____ my house.",
            "Where are _____ children? – They go to school.",
            "Those students are working very _____ for their next exams."
    };

    static final String answer[] = {
            "those","a French","am buying","getting","to",
            "its","some","of","the","hard"
    };

    static final String option[] = {
            "this","those","them","that",
            "Frenchman","a French","a Frenchman","French man",
            "buy","am buying","going to buy","bought",
            "getting","going","doing","putting",
            "to","to the","in","in the",
            "it’s","its","it","it is",
            "a lot","many","much","some",
            "of","to","off","in",
            "the","you","a","an",
            "hardly","hard","harder","hardest"
    };

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thi);
        stt = (TextView) findViewById(R.id.stt);
        noiDung = (TextView) findViewById(R.id.noiDung);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        ketthuc = (Button) findViewById(R.id.ketthuc);
        r1 = (RadioButton) findViewById(R.id.rd1);
        r2 = (RadioButton) findViewById(R.id.rd2);
        r3 = (RadioButton) findViewById(R.id.rd3);
        r4 = (RadioButton) findViewById(R.id.rd4);
        click = (Button) findViewById(R.id.click);
        mTextField = (TextView) findViewById(R.id.textView8);
        flag = 0;
        i = 1;
        stt.setText("Câu Hỏi Thứ " + i);
        noiDung.setText(question[flag]);
        r1.setText(option[n]);
        r2.setText(option[n+1]);
        r3.setText(option[n+2]);
        r4.setText(option[n+3]);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
         a = bundle.getString("dethi");

         radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(r1.isChecked()==true) {
            r1.setTextColor(getColor(R.color.red));
            r2.setTextColor(getColor(R.color.black));
            r3.setTextColor(getColor(R.color.black));
            r4.setTextColor(getColor(R.color.black));
        }
        else if(r2.isChecked()==true) {
            r2.setTextColor(getColor(R.color.red));
            r1.setTextColor(getColor(R.color.black));
            r3.setTextColor(getColor(R.color.black));
            r4.setTextColor(getColor(R.color.black));
        }
        else if(r3.isChecked()==true) {
            r3.setTextColor(getColor(R.color.red));
            r2.setTextColor(getColor(R.color.black));
            r1.setTextColor(getColor(R.color.black));
            r4.setTextColor(getColor(R.color.black));
        }
        else if (r4.isChecked()==true) {
            r4.setTextColor(getColor(R.color.red));
            r2.setTextColor(getColor(R.color.black));
            r3.setTextColor(getColor(R.color.black));
            r1.setTextColor(getColor(R.color.black));
        }
    }
});


        Timer = new CountDownTimer(11000, 1000) {
            public void onTick(long millisUntilFinished) {
                mTextField.setText("Thời Gian Còn Lại: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                if(i<=10){
                    if(i<10){
                        Timer.cancel();
                        Timer.start();
                        wrong++;
                        n+=4;
                        flag+=1;
                        stt.setText("Câu Hỏi Thứ " + (i+=1));
                       noiDung.setText(question[flag]);
                        r1.setText(option[n]);
                        r2.setText(option[n+1]);
                        r3.setText(option[n+2]);
                        r4.setText(option[n+3]);
                        if(radioGroup.getCheckedRadioButtonId()== -1){
                            Toast.makeText(De_So_1.this, "Bạn Đã Bị Mất Điểm!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(De_So_1.this, "Bạn Đã Bị Mất Điểm!", Toast.LENGTH_SHORT).show();

                    }
                    else if(i==10){
                        Timer.cancel();
                        wrong++;
                        Intent intent = new Intent(getApplicationContext(),Ket_Qua_Sau_Thi.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("correct", correct);
                        bundle.putInt("wrong", wrong);
                        bundle.putInt("marks",i);
                        bundle.putString("de",a);
                        intent.putExtras(bundle);
                        Toast.makeText(De_So_1.this, "Bạn Đã Bị Mất Điểm!", Toast.LENGTH_SHORT).show();
                        i = 1;
                        n = 0;
                        flag = 0;
                        correct = 0;
                        wrong = 0;
                        startActivity(intent);
                    }
                }
            }

        }.start();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton uans = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(i<=10){
                    Timer.start();
                    if(i<10){
                        if(answer[flag].equals(ansText)){
                            correct++;
                        }
                        else
                            wrong++;
                        n+=4;
                        flag+=1;
                        stt.setText("Câu Hỏi Thứ " + (i+=1));
                        noiDung.setText(question[flag]);
                        r1.setText(option[n]);
                        r2.setText(option[n+1]);
                        r3.setText(option[n+2]);
                        r4.setText(option[n+3]);
                        if(radioGroup.getCheckedRadioButtonId()== -1) {
                            Toast.makeText(De_So_1.this, "Bạn Đã Bị Mất Điểm!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    else if(i==10){
                        Timer.cancel();
                        if(answer[flag].equals(ansText)){
                            correct++;
                        }
                        else
                            wrong++;
                        if(radioGroup.getCheckedRadioButtonId()== -1){
                            Toast.makeText(De_So_1.this, "Bạn Đã Bị Mất Điểm!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Intent intent = new Intent(getApplicationContext(),Ket_Qua_Sau_Thi.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("correct", correct);
                        bundle.putInt("wrong", wrong);
                        bundle.putInt("marks",i);
                        bundle.putString("de",a);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        i = 1;
                        n = 0;
                        flag = 0;
                        correct = 0;
                        wrong = 0;
                    }
                }

            }
        });
        ketthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Timer1.cancel();
                RadioButton uans = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
                if(answer[flag].equals(ansText)){
                    correct++;
                }
                else
                    wrong++;
                Intent intent = new Intent(getApplicationContext(),Ket_Qua_Sau_Thi.class);
                Bundle bundle = new Bundle();
                bundle.putInt("correct", correct);
                bundle.putInt("wrong", wrong);
                bundle.putInt("marks",(i));
                bundle.putString("de",a);
                intent.putExtras(bundle);
                i = 1;
                n = 0;
                flag = 0;
                correct = 0;
                wrong = 0;
                startActivity(intent);

            }
        });


    }

}




