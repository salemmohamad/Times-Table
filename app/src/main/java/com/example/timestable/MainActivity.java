package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public void timesTableGenerator (int value)
    {
        ArrayList<String> numbers =  new ArrayList<>();
        ArrayAdapter<String> seeking= new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,numbers);
        listView.setAdapter(seeking);
        for(int i=1;i<=12;i++)
        {
            numbers.add(i+" x "+value+" = "+String.valueOf(i*value));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        final TextView textView= findViewById(R.id.textView);

        // same as lines 18-24 (except 23) so that the app at beginning doesn't start off with blanks
        ArrayList<String> numbers =  new ArrayList<>();
        ArrayAdapter<String> seeking= new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,numbers);
        listView.setAdapter(seeking);
        textView.setText("1");
        for(int i=1;i<=12;i++)
        {
            numbers.add(i+" x 1"+" = "+String.valueOf(i));
        }

        final SeekBar movingAround = findViewById(R.id.seekBar2);
        int maxValue=13;
        movingAround.setMax(maxValue);
        movingAround.setProgress(1);
        movingAround.setMin(1);
        movingAround.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                timesTableGenerator(progress);
                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }
}
