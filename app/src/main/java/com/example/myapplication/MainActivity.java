package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab, fab_main_verificar_directo;
    private Context context;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        init();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarPreferencias();
            }
        });

        fab_main_verificar_directo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irVerificar();
            }
        });
    }

    private void init(){
        fab = findViewById(R.id.fab_main_verificar);
        fab_main_verificar_directo = findViewById(R.id.fab_main_verificar_directo);
        context = this;
        preferences = context.getSharedPreferences(getString(R.string.sharedPN), Context.MODE_PRIVATE);
    }

    private void irVerificar(){
        Intent verificar = new Intent(this, VerificarActivity.class);
        startActivity(verificar);
    }

    private void guardarPreferencias(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nombre_usuario", "Carlos Jaramillo");
        editor.putString("rol_usuario", "admin");
        editor.putString("id_usuario", "TYF6767HJG879");
        editor.commit();

        irVerificar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
