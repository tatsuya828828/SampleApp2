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

        // 配列の内容をHashMapに詰め替え
        // アダプター側では配列を処理できないため、配列の内容をHashMapのオブジェクト配列に詰め替えている
        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        for(int i = 0; i < titles.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("title", titles[i]);
            item.put("tag", tags[i]);
            item.put("desc", descs[i]);
            data.add(item);
        }

        // HashMap配列とレイアウトとを関連付け
        // HashMap配列ができたら、SimpleAdapterクラスでこれをレイアウトファイルに関連づける
        // HashMap配列「data」の内容を、レイアウトファイルlist_item.xmlを使って
        // リスト項目に整形しなさいという意味になる
        SimpleAdapter adapter = new SimpleAdapter(
            this, data, R.layout.list_item,
            new String[] {"title", "tag", "desc"},
            new int[] {R.id.title, R.id.tag, R.id.desc}
        );

        // アダプターを元にリストを生成
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}