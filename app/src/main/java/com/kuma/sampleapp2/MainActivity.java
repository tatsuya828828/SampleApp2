package com.kuma.sampleapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    btnSend_onClick(view);
                }
            }
        );
    }

    // ボタンクリック時に入力された名前を表示
    public void btnSend_onClick(View view) {
        EditText txtName = findViewById(R.id.txtName);
        TextView txtResult = findViewById(R.id.txtResult);
        txtResult.setText(String.format("ようこそ、%sさん！", txtName.getText()));
    }
}