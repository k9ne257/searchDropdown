package com.example.searchdropdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> fahrer = new ArrayList<>();
    ArrayList<String> auto = new ArrayList<>();
    ArrayList<String> scanner = new ArrayList<>();
    SpinnerDialog sdfahrer;
    SpinnerDialog sdauto;
    SpinnerDialog sdscanner;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList(fahrer, "Fahrer");
        initList(auto, "Fahrzeug");
        initList(scanner, "Scanner");
        selectfahrer();
        selectAuto();
        selectScanner();
    }

    public void selectfahrer() {
        sdfahrer = new SpinnerDialog(MainActivity.this,fahrer,"Select Driver");
        sdfahrer.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this,"Selected: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        btn = (Button) findViewById(R.id.btn_fahrer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdfahrer.showSpinerDialog();
            }
        });
    }

    public void selectAuto() {
        sdauto = new SpinnerDialog(MainActivity.this,auto,"Select Driver");
        sdauto.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this,"Selected: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        btn = (Button) findViewById(R.id.btn_Auto);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdauto.showSpinerDialog();
            }
        });
    }

    public void selectScanner() {
        sdscanner = new SpinnerDialog(MainActivity.this,scanner,"Select Driver");
        sdscanner.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this,"Selected: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        btn = (Button) findViewById(R.id.btn_scanner);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdscanner.showSpinerDialog();
            }
        });
    }

    public void initList(ArrayList<String> items, String type){

        for (int i = 1; i <= 25; i++){
            items.add(type + " " + i);
        }
    }
}