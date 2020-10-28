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

        // レーティングバーを取得
        RatingBar rate = findViewById(R.id.ratingBar);
        // レーティングバーにイベントリスナーを登録
        rate.setOnRatingBarChangeListener(
            new RatingBar.OnRatingBarChangeListener(){
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser){
                    Toast.makeText(MainActivity.this, String.format(
                            Locale.JAPAN, "現在の評価は%sです。", rating),
                            Toast.LENGTH_SHORT).show();
                }
            }
        );
    }
}