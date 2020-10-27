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

        // チェックボックスを取得
        Switch switch1 = findViewById(R.id.switch1);
        // チェックボックスに対してイベントリスナーを登録
        switch1.setOnCheckedChangeListener(
                //  CompoundButtonオブジェクトは、チェックボックスやラジオボタン、トグルボタンなど、
                //  オンオフの状態を持つボタンのスーパークラス
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    // checkの状態が引数のisCheckedに渡される
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(MainActivity.this,
                                // isCheckedの値に応じて文字列をトースト表示
                                isChecked ? "メール送信をオン" : "メール送信をオフ",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}