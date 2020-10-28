package com.kuma.sampleapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // スピナーを取得
        Spinner sp = findViewById(R.id.spinner);
        // スピナーに対してイベントリスナーを登録
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 項目が選択された場合の処理
            // onItemSelectedメソッドでは選択された項目が格納されている
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                // 選択項目を取得し、その値をトースト表示
                // Spinnerが取得できてしまえば、あとはそのgetSelectedItemメソッドで選択された項目を取得できるため
                // これを整形してトースト表示する
                // getSelectedItemメソッドの戻り値はObject型のため、取得した値は必要に応じてString型にキャストする
                Toast.makeText(MainActivity.this, String.format("選択項目:%s", spinner.getSelectedItem()),
                Toast.LENGTH_SHORT).show();
            }

            // 項目が選択されなかった場合の処理
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}