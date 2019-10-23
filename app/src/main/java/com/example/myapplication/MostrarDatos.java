package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class MostrarDatos extends AppCompatActivity {

    private FloatingActionButton fab_listar;
    private ListView lv_main_contenido;
    private ArrayList<cuenta> list;
    private cuenta model;
    private Button btn_main_atras;
    private ImageButton ibtn_main_buscar;
    private EditText et_main_buscar_cuenta;
    cuentasAdapter mAdapter;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);
        Toolbar toolbar = findViewById(R.id.toolbar_listar);
        setSupportActionBar(toolbar);

        mFirestore = FirebaseFirestore.getInstance();
        Query query = mFirestore.collection("cuentas");
        lv_main_contenido = findViewById(R.id.lv_main_contenido);

        btn_main_atras = findViewById(R.id.btn_main_atras);
        ibtn_main_buscar = findViewById(R.id.ibtn_main_buscar);
        et_main_buscar_cuenta = findViewById(R.id.et_main_buscar_cuenta);
        list = new ArrayList<>();
        model = new cuenta();

        fab_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(MostrarDatos.this, datosBanco.class);
                startActivity(registro);
            }
        });

        btn_main_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });


        lv_main_contenido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                model = (cuenta) parent.getItemAtPosition(position);
                Intent detalle = new Intent(MostrarDatos.this, DetalleActivity.class);
                detalle.putExtra("id", model.getnCuenta());
                startActivity(detalle);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
