package com.kuma.sampleapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnCurrent);
        btn.setOnClickListener(view -> {
            btnCurrent_onClick(view);
            TextView txt = findViewById(R.id.txtResult);
            txt.setText(new Date().toString());
            Log.d("CurrentTime", new Date().toString());
        });
    }

    public void btnCurrent_onClick(View view) {
        Toast toast = Toast.makeText(
                this, new Date().toString(), Toast.LENGTH_LONG);
        toast.show();
    }

    // 画面が破棄される前の状態を保存
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView txtResult = findViewById(R.id.txtResult);
        outState.putString("txtResult", txtResult.getText().toString());
    }

    // 画面が復元される際に状態を取り出し
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView txtResult = findViewById(R.id.txtResult);
        txtResult.setText(savedInstanceState.getString("txtResult"));
    }
}