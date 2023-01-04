package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    SeekBar seekBar;
    TextInputEditText inputEdtText;
    ImageView enterBtn;
    String Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        listView = findViewById(R.id.listView);
        seekBar=findViewById(R.id.seekBar);

        seekBar.setMax(100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                Toast.makeText(MainActivity.this, "Table "+i, Toast.LENGTH_SHORT).show();
                populate(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void enterValue()
    {
        String Number=inputEdtText.getText().toString();
        int n = Integer.parseInt(Number);
        seekBar.setMax(n);
    }

    public void populate(int table)
    {
        ArrayList<String> mulTable=new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
            mulTable.add(table+" X "+i+" = "+table*i);
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mulTable);
        listView.setAdapter(arrayAdapter);
        textView.setText("Multiplication Table of "+table);
    }
}