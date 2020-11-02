package com.kuma.sampleapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
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
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // メインのレイアウトファイルactivity_main.xmlを関連付け
        setContentView(R.layout.activity_main);

        // リストに表示するデータを準備
        // タイトル・サブタイトル・詳細を表すデータを配列titles・tags・descsとして準備する。
        String titles[] = {"革命のエチュード", "G線上のアリア", "シャコンヌ", "夜の女王のアリア", "春の海"};
        String tags[] = {"ピアノ", "バイオリン", "チェロ", "声楽", "箏"};
        String descs[] = {"ピアノの詩人と呼ばれたショパンの代表的な...",
                "バッハの作品。バイオリンのG線のみで演奏できることから...",
                "バッハの作品。パルティータ第2番の終曲です。",
                "モーツァルト作曲のオペラ「魔笛」の中のアリアです。",
                "宮城道雄の作品です。曲の舞台は鞆の浦と言われています。"};

        // 配列の内容をListItemオブジェクトに詰め替え
        // アダプターに渡すべきデータをListItemオブジェクト配列配列として用意している
        ArrayList<ListItem> data = new ArrayList<>();
        for(int i = 0; i <titles.length; i++) {
            ListItem item =  new ListItem();
            item.setId((new Random()).nextLong());
            item.setTitle(titles[i]);
            item.setTag(tags[i]);
            item.setDesc(descs[i]);
            data.add(item);
        }

        // ListItem配列とレイアウトを関連付け
        // アダプターとして、自作のアダプターを指定
        MyListAdapter adapter = new MyListAdapter(this, data, R.layout.list_item);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}