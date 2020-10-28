package com.kuma.sampleapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSpinner();
    }

    // Spinnerに項目リストを登録するメソッド
    private void createSpinner() {
        ArrayList<String> list = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN);
        Calendar calendar = Calendar.getInstance();
        // 明日から10日後の日付リストを生成
        for(int i = 1; i < 11; i++) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
            list.add(format.format(calendar.getTime()));
        }
        // 配列をウィジェットに渡す準備
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, list);
        // アダプター経由でSpinnerリストを登録
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        // Spinner選択時の処理を定義
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                Toast.makeText(MainActivity.this, String.format("選択項目:%s"
                        , spinner.getSelectedItem()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}