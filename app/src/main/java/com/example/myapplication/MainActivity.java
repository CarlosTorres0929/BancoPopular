package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_main_iniciar,fab_main_register;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        fab_main_iniciar = findViewById(R.id.fab_main_iniciar);
        fab_main_register = findViewById(R.id.fab_main_register);

        fab_main_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = etName.getText().toString();
                String password = etPassword.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                //String savedPassword = preferences.getString(password, "");
                //String savedUserName = preferences.getString(user, "");

                String userDetails = preferences.getString(user + password + "data","LA INFORMACION QUE INGRESASTE ESTA INCORRECTA.. !REGISTRATE!.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",userDetails);
                editor.commit();

                    Intent displayScreen = new Intent(MainActivity.this, DisplayScreen.class);
                    startActivity(displayScreen);

            }
        });


        fab_main_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(MainActivity.this, Register.class);
                startActivity(registerScreen);
            }
        });
    }



}