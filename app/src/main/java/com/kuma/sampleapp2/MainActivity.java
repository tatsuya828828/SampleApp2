package com.kuma.sampleapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsListView;
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
            this, android.R.layout.simple_list_item_checked, data);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            // 選択項目のチェック状態が変化した時
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {}
            // アクションモードを起動する時
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return true;
            }
            // アクションモードの準備時
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return true;
            }
            // 項目をクリックした時
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return true;
            }
            // アクションモードを終了した時
            @Override
            public void onDestroyActionMode(ActionMode mode) {
                StringBuilder msg = new StringBuilder("選択:");
                // チェック状態の項目だけを追加
                for(int i = 0; i < list.getChildCount(); i++) {
                    CheckedTextView check = (CheckedTextView) list.getChildAt(i);
                    if(check.isChecked()) {
                        msg.append(check.getText()).append(",");
                    }
                }
                Toast.makeText(MainActivity.this, msg.substring(0, msg.length() -1),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}