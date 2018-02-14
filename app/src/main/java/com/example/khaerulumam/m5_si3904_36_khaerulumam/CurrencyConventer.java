package com.example.khaerulumam.m5_si3904_36_khaerulumam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyConventer extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    String mSpinnerlabel = "";
    private TextView a,f;
    private EditText b,c;
    private Spinner d,e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_conventer);

        a = (TextView) findViewById(R.id.user);

        f = (TextView) findViewById(R.id.judul);

        Intent c = getIntent();

        final String username = c.getStringExtra("nama");
        final String judul = c.getStringExtra("judul");

        a.setText(username);
        f.setText(judul);


        d = (Spinner) findViewById(R.id.currency);
        e = (Spinner) findViewById(R.id.currency1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (d != null){
            d.setAdapter(adapter);
        }
        if (e != null){
            e.setAdapter(adapter);
        }

    }

    public void convert(View view) {
        b = (EditText) findViewById(R.id.angka1);
        c = (EditText) findViewById(R.id.angka2);
        String cur = d.getSelectedItem().toString();
        String cur2 = e.getSelectedItem().toString();

        if (b ==null && c==null){
            Toast.makeText(this,"Isi dulu bro",Toast.LENGTH_LONG).show();
        } else if (cur.equalsIgnoreCase("usd") && cur2.equalsIgnoreCase("idr")){
            String angka = b.getText().toString();
            int test = Integer.parseInt(angka);
            double hsl = test * 14285.7143;
            String hs11 = String.valueOf(hsl);
            c.setText(hs11);
        } else if (cur.equalsIgnoreCase("idr") && cur2.equalsIgnoreCase("usd")){
            String angka = b.getText().toString();
            int test = Integer.parseInt(angka);
            double hsl = test * 0.000007;
            String hs11 = String.valueOf(hsl);
            c.setText(hs11);
        }
        else if (cur.equalsIgnoreCase("idr") && cur2.equalsIgnoreCase("yen")){
            String angka = b.getText().toString();
            int test = Integer.parseInt(angka);
            double hsl = test * 0.00753498385;
            String hs11 = String.valueOf(hsl);
            c.setText(hs11);
        }
        else if (cur.equalsIgnoreCase("usd") && cur2.equalsIgnoreCase("yen")){
            String angka = b.getText().toString();
            int test = Integer.parseInt(angka);
            double hsl = test * 107.642626;
            String hs11 = String.valueOf(hsl);
            c.setText(hs11);
        }
        else if (cur.equalsIgnoreCase("yen") && cur2.equalsIgnoreCase("idr")){
            String angka = b.getText().toString();
            int test = Integer.parseInt(angka);
            double hsl = test * 132.714286;
            String hs11 = String.valueOf(hsl);
            c.setText(hs11);
        }
        else if (cur.equalsIgnoreCase("yen") && cur2.equalsIgnoreCase("usd")){
            String angka = b.getText().toString();
            int test = Integer.parseInt(angka);
            double hsl = test * 0.00929;
            String hs11 = String.valueOf(hsl);
            c.setText(hs11);
        }
        else if (cur.equalsIgnoreCase("yen") && cur2.equalsIgnoreCase("yen")){
            String angka = b.getText().toString();
            c.setText(angka);
        }
        else if (cur.equalsIgnoreCase("usd") && cur2.equalsIgnoreCase("usd")){
            String angka = b.getText().toString();
            c.setText(angka);
        }
        else if (cur.equalsIgnoreCase("idr") && cur2.equalsIgnoreCase("idr")){
            String angka = b.getText().toString();
            c.setText(angka);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSpinnerlabel = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void close(View view) {
        Intent bc = new Intent(CurrencyConventer.this,List.class);
        startActivity(bc);
    }
}
