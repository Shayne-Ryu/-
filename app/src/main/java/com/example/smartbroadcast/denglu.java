package com.example.smartbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class denglu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);


        final Button denglu = (Button) findViewById(R.id.ButtonDenglu);
        final EditText acc = (EditText) findViewById(R.id.editTextTextAccount);
        final EditText psw = (EditText) findViewById(R.id.editTextTextPassword);
        final String[] acc_string = {""};
        final String[] psw_string = {""};
        denglu.setEnabled(false);
        denglu.setBackgroundColor(Color.rgb(214, 215, 215));
        final int[] accflag = {0};
        final int[] pswflag = {0};
        //添加输入监听内容事件
        acc.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            // afterTextChanged中 editable为EditText显示的内容
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 6) {
                    accflag[0] = 1;
                }
                if (editable.length() < 6) {
                    accflag[0] = 0;
                }
                if (accflag[0] == 1 && pswflag[0] == 1) {
                    denglu.setEnabled(true);
                    denglu.setBackgroundColor(Color.rgb(87, 189, 106));
                } else {
                    denglu.setEnabled(false);
                    denglu.setBackgroundColor(Color.rgb(214, 215, 215));
                }
            }
        });
        psw.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            // afterTextChanged中 editable为EditText显示的内容
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 6) {
                    pswflag[0] = 1;
                }
                if (editable.length() < 6) {
                    pswflag[0] = 0;
                }
                if (accflag[0] == 1 && pswflag[0] == 1) {
                    denglu.setEnabled(true);
                    denglu.setBackgroundColor(Color.rgb(87, 189, 106));
                } else {
                    denglu.setEnabled(false);
                    denglu.setBackgroundColor(Color.rgb(214, 215, 215));
                }
            }
        });



        psw.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // 此处为得到焦点时的处理内容
                } else {
                    // 此处为失去焦点时的处理内容
                    psw_string[0] = psw.getText().toString();
                }
            }

        });

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acc_string[0] = acc.getText().toString();
                psw_string[0] = psw.getText().toString();


            }
        });
    }
}