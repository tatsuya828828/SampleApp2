package com.kuma.sampleapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
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

        // リスト項目をArrayListとして準備
        final ArrayList<String> data = new ArrayList<>();
        data.add("胡椒");
        data.add("ターメリック");
        data.add("コリアンダー");
        data.add("生姜");
        data.add("ニンニク");
        data.add("サフラン");

        // 配列アダプターを作成&ListViewに登録
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this, android.R.layout.simple_list_item_multiple_choice, data);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);

        // リスト項目をタッチ、した時の処理を定義
        // Longをつけることで長押し時の処理を設定できる
        list.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    StringBuilder msg = new StringBuilder("選択:");
                    for(int i = 0; i < list.getChildCount(); i++) {
                        CheckedTextView check = (CheckedTextView) list.getChildAt(i);
                        if(check.isChecked()) {
                            msg.append(check.getText()).append(",");
                        }
                    }
                    Toast.makeText(MainActivity.this, msg.substring(0, msg.length() -1),
                            Toast.LENGTH_LONG).show();
                }
            }
        );
    }
}