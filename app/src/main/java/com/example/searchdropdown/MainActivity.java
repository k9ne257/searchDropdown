package com.example.searchdropdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> fahrer = new ArrayList<>();
    ArrayList<String> beiFahrer = new ArrayList<>();
    ArrayList<String> auto = new ArrayList<>();
    ArrayList<String> scanner = new ArrayList<>();
    ArrayList<String> rescue = new ArrayList<>();
    SpinnerDialog sdfahrer;
    SpinnerDialog sdBeiFahrer;
    SpinnerDialog sdRescue;
    SpinnerDialog sdauto;
    SpinnerDialog sdscanner;
    Button btn;

    private TimePicker startTimepicker;
    private TimePicker endTimepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initArrayLists();
        selectfahrer();
        selectBeiFahrer();
        selectRescue();
        selectAuto();
        selectScanner();

        startTimepicker = (TimePicker)findViewById(R.id.input_start_time);
        startTimepicker.setIs24HourView(true);
        endTimepicker = (TimePicker)findViewById(R.id.input_end_time);
        endTimepicker.setIs24HourView(true);

    }

    public void selectfahrer() {
        sdfahrer = new SpinnerDialog(MainActivity.this,fahrer,"Select Driver");
        sdfahrer.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this,"Selected: " + item, Toast.LENGTH_SHORT).show();
                TextView driverview = (TextView) findViewById(R.id.selected_driver);
                driverview.setText(item);
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

    public void selectBeiFahrer() {
        sdBeiFahrer = new SpinnerDialog(MainActivity.this,beiFahrer,"Select Driver");
        sdBeiFahrer.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this,"Selected: " + item, Toast.LENGTH_SHORT).show();
                TextView beiFahrerrview = (TextView) findViewById(R.id.selected_beifahrer);
                beiFahrerrview.setText(item);
            }
        });

        btn = (Button) findViewById(R.id.btn_beifahrer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdBeiFahrer.showSpinerDialog();
            }
        });
    }

    public void selectRescue() {
        sdRescue = new SpinnerDialog(MainActivity.this,rescue,"Select Driver");
        sdRescue.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this,"Selected: " + item, Toast.LENGTH_SHORT).show();
                TextView rescueview = (TextView) findViewById(R.id.selected_rescue);
                rescueview.setText(item);
            }
        });

        btn = (Button) findViewById(R.id.btn_rescue);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdRescue.showSpinerDialog();
            }
        });
    }

    public void selectAuto() {
        sdauto = new SpinnerDialog(MainActivity.this,auto,"Select Driver");
        sdauto.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {
                Toast.makeText(MainActivity.this,"Selected: " + item, Toast.LENGTH_SHORT).show();
                TextView carview = (TextView) findViewById(R.id.selected_car);
                carview.setText(item);
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
                TextView scannerview = (TextView) findViewById(R.id.selected_scanner);
                scannerview.setText(item);
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

    public void initArrayLists(){
        initList(fahrer, "Fahrer");
        initList(auto, "Fahrzeug");
        initList(scanner, "Scanner");
        initList(rescue, "Rescue");
        initList(beiFahrer, "Beifahrer");

    }
    public void initList(ArrayList<String> items, String type){

        for (int i = 1; i <= 200; i++){
            items.add(type + " " + i);
        }
    }
}