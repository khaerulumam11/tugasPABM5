package com.example.khaerulumam.m5_si3904_36_khaerulumam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class List extends AppCompatActivity {

    ListView simpleList;
    String nama[] = {"1.Kalkulator Konversi", "2.Currency Converter"};


    private Button a ;
    private TextView b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        a = (Button) findViewById(R.id.keluar);

        b = (TextView) findViewById(R.id.nama);

        Intent c = getIntent();

        final String username = c.getStringExtra("username");

        b.setText(username);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b =  new Intent(List.this,MainActivity.class);
                startActivity(b);
            }
        });

        simpleList = (ListView) findViewById(R.id.listview);
        CustomAdapterList customAdapter = new CustomAdapterList(getApplicationContext(),nama);
        simpleList.setAdapter(customAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent a = new Intent(List.this,KalkulatorKonversi.class);
                        a.putExtra("nama",username);
                        a.putExtra("judul","1. Kalkulator Konversi");
                        startActivity(a);
                        break;
                    case 1:
                        Intent b = new Intent(List.this,CurrencyConventer.class);
                        b.putExtra("nama",username);
                        b.putExtra("judul","2. Currency Ceonverter");
                        startActivity(b);
                        break;
                }
            }
        });
    }
    }

