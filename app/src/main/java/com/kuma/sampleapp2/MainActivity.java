package com.kuma.sampleapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnCurrent);
        btn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView txt = findViewById(R.id.txtResult);
                    txt.setText(new Date().toString());
                }
            }
        );
    }

    public  void btnCurrent_onClick(View view) {
        TextView txt = findViewById(R.id.txtResult);
        txt.setText(new Date().toString());
    }
}