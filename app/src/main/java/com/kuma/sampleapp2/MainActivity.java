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
                // simple_list_item_multiple_choiceを適用
            this, android.R.layout.simple_list_item_multiple_choice, data);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);

        // リスト項目をタッチした時の処理を定義
        list.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // リスト配下の項目を全て取り出して、
                    // それぞれの項目が選択されていればその値を取り出す、という処理が必要となる
                    // ListView配下の項目数はgetChildCount、i番目の項目はgetChildAtメソッドで取得できる。
                    StringBuilder msg = new StringBuilder("選択:");
                    // 0から順番にリストの項目を取得しCheckedTextViewに型キャストした上で、
                    // isCheckedメソッドでチェックされているかどうかを判定する
                    // もしチェックされている場合には、
                    // 項目テキスト(getTextメソッド)を変数msgにカンマ区切りで追加していく。
                    for(int i = 0; i < list.getChildCount(); i++) {
                        CheckedTextView check = (CheckedTextView) list.getChildAt(i);
                        if(check.isChecked()) {
                            msg.append(check.getText()).append(",");
                        }
                    }
                    // msg.substring(0, msg.length() -1)では文字列末尾のカンマを除去している
                    Toast.makeText(MainActivity.this, msg.substring(0, msg.length() -1),
                            Toast.LENGTH_LONG).show();
                }
            }
        );

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                CharSequence msg = ((TextView) view).getText();
                Toast.makeText(
                        MainActivity.this, String.format("削除:%s", msg.toString()),
                        Toast.LENGTH_SHORT).show();
                adapter.remove((String) ((TextView) view).getText());
                return false;
            }
        });
    }
}