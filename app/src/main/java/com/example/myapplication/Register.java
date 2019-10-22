package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Register extends AppCompatActivity {

    private FloatingActionButton fab_register,fab_register_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbar);
        final EditText userName = (EditText) findViewById(R.id.etNewName);
        final EditText password = (EditText) findViewById(R.id.etNewPassword);
        final EditText email = (EditText) findViewById(R.id.etNewEmail);
        final EditText cedula = (EditText) findViewById(R.id.cedula);

         fab_register = findViewById(R.id.fab_register);
         fab_register_volver = findViewById(R.id.fab_register_volver);
        fab_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String newUser  = userName.getText().toString();
                String newcedula  = cedula.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                // almacena 3 nuevas instancias de sharedprefs. Las claves de usuario y contraseña son las mismas que las de entrada.
                // Debe hacerse de esta manera porque sharedprefs es estúpido e ineficiente. No puede almacenar matrices fácilmente
                // entonces uso cadenas en su lugar.
                editor.putString(newUser,newUser);
                editor.commit();
                editor.putString(newPassword, newPassword);
                editor.commit();
                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail + "\n" + newcedula);
                editor.commit();

                Intent login = new Intent(Register.this, MainActivity.class);
                startActivity(login);
            }
        });

        fab_register_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Register.this, MainActivity.class);
                startActivity(volver);
            }
        });
        }}
