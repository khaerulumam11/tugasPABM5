package com.example.khaerulumam.m5_si3904_36_khaerulumam;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class KalkulatorKonversi extends AppCompatActivity {

    private TextView a,f ;
    private EditText b;
    private RadioGroup c;
    private RadioButton d,e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator_konversi);

        a = (TextView) findViewById(R.id.user);
        f = (TextView) findViewById(R.id.judul);

        b = (EditText) findViewById(R.id.angka);

        c = (RadioGroup) findViewById(R.id.konvert);

        Intent c = getIntent();

        final String username = c.getStringExtra("nama");
        final String judul = c.getStringExtra("judul");

        a.setText(username);
        f.setText(judul);
    }

    public void proses(View view) {
        int selecteditem = c.getCheckedRadioButtonId();

        b = (EditText) findViewById(R.id.angka);

        d = (RadioButton) findViewById(R.id.meterfeet);
        e = (RadioButton) findViewById(R.id.feetmeter);

        if (selecteditem == d.getId()){
            String test = b.getText().toString();
            int angka = Integer.parseInt(test);
             double hasil = angka * 3.28;

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Alert Message");

            alert.setMessage(test + " Meter = "+String.valueOf(hasil))
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog alertDialog = alert.create();

            alertDialog.show();


        } else if (selecteditem == e.getId()){
            String test = b.getText().toString();
            int angka = Integer.parseInt(test);
            double hasil = angka * 0.3048;

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Alert Message");

            alert.setMessage(test + " Feet = "+String.valueOf(hasil))
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog alertDialog = alert.create();

            alertDialog.show();
        }
    }

    public void keluar(View view) {
        Intent ab = new Intent(KalkulatorKonversi.this,List.class);
        startActivity(ab);
    }
}
