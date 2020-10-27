package com.kuma.sampleapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // radioGroupを取得
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        // radioGroupに対してイベントリスナーを登録
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    // 選択状態に応じてトーストを表示
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton radio = group.findViewById(checkedId);
                        Toast.makeText(MainActivity.this,
                                // isCheckedの値に応じて文字列をトースト表示
                                String.format("[%s]が選択されました。", radio.getText()),
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}