package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class DisplayScreen extends AppCompatActivity {

    private FloatingActionButton fab_display_banco,fab_display_salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);
        Toolbar toolbar = findViewById(R.id.toolbar_display);
        setSupportActionBar(toolbar);

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = preferences.getString("display", "");

        TextView displayInfo = (TextView) findViewById(R.id.textViewName);
        displayInfo.setText(display);

        fab_display_banco = findViewById(R.id.fab_display_banco);
        fab_display_salir = findViewById(R.id.fab_display_salir);
        fab_display_banco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent banco = new Intent(DisplayScreen.this, datosBanco.class);
                startActivity(banco);
            }
        });
        fab_display_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent salir = new Intent(DisplayScreen.this, MainActivity.class);
                startActivity(salir);
            }
        });
    }

}
