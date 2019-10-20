package com.example.myapplication;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class VerificarActivity extends AppCompatActivity {

    private FloatingActionButton fab_verificar;
    private TextView tv_verificar_mensaje;
    private Context context;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar);
        Toolbar toolbar = findViewById(R.id.toolbar_verificar);
        setSupportActionBar(toolbar);

        init();
        boolean sesionActiva = verificarSesion();
        if(sesionActiva){
            String nombre = preferences.getString("nombre_usuario", null);
            String id = preferences.getString("id_usuario", null);
            String rol = preferences.getString("rol_usuario", null);
            String cadena = "Hola " + nombre + ", bienvenido a la APP. Tu rol es: " + rol;
            tv_verificar_mensaje.setText(cadena);
        }else{
            irLogin();
        }

        fab_verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerrarSesion();
            }
        });
    }

    private boolean verificarSesion(){
        String nombre = preferences.getString("nombre_usuario", null);
        if(nombre == null){
            return false;
        }else{
            return true;
        }
    }

    private void cerrarSesion(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("nombre_usuario");
        editor.remove("id_usuario");
        editor.remove("rol_usuario");
        editor.commit(); /* Guarda los cambios en el archivo preferences */

        irLogin();
    }

    private void init(){
        fab_verificar = findViewById(R.id.fab_verificar_nada);
        tv_verificar_mensaje = findViewById(R.id.tv_verificar_mensaje);
        context = this;preferences = context.getSharedPreferences(getString(R.string.sharedPN), Context.MODE_PRIVATE);
    }

    private void irLogin(){
        Intent login = new Intent(this, MainActivity.class);
        startActivity(login);
    }

}
