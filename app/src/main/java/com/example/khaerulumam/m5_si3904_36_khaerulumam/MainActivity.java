package com.example.khaerulumam.m5_si3904_36_khaerulumam;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button a, b;
    private EditText c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (Button) findViewById(R.id.ok);
        b = (Button) findViewById(R.id.cancel);

        c = (EditText) findViewById(R.id.username);
        d = (EditText) findViewById(R.id.password);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a.setText("");
                b.setText("");
            }
        });
    }

    public void oke(View view) {
        final String user = c.getText().toString();
        String pass = d.getText().toString();

        if ((user.equals("GNW") && pass.equals("1202154148")) ||(user.equals("1202154148") && pass.equals("36"))){
            Toast.makeText(this,"Anda berhasil login",Toast.LENGTH_LONG).show();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Alert Message");

            alert.setMessage("Login Success")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent d = new Intent(MainActivity.this,List.class);
                            d.putExtra("username",user);
                            startActivity(d);
                        }
                    });

            AlertDialog alertDialog = alert.create();

            alertDialog.show();



        }
        else if (user.isEmpty() && pass.isEmpty()){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Isi dulu bro");

            alert.setMessage("Login Failed")
                    .setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog alertDialog = alert.create();

            alertDialog.show();

        }
        else if (!user.equals("GNW")  && !pass.equals("1202154148")|| !user.equals("1202154148")  && !pass.equals("36")){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Salah bro");

            alert.setMessage("Login Failed")
                    .setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog alertDialog = alert.create();

            alertDialog.show();
        }
    }
    }

