package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MostrarDatos extends AppCompatActivity {

    private FloatingActionButton fab_listar;
    RecyclerView recyclerViewCuentas;
    cuentasAdapter mAdapter;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);
        Toolbar toolbar = findViewById(R.id.toolbar_listar);
        setSupportActionBar(toolbar);

        recyclerViewCuentas = findViewById(R.id.recyclercuentas);
        recyclerViewCuentas.setLayoutManager(new LinearLayoutManager(this));
        mFirestore = FirebaseFirestore.getInstance();
        Query query = mFirestore.collection("cuentas");

        FirestoreRecyclerOptions<cuenta>firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<cuenta>().setQuery(query, cuenta.class).build();

        mAdapter = new cuentasAdapter(firestoreRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull Object o) {
                mAdapter.notifyDataSetChanged();
                recyclerViewCuentas.setAdapter(mAdapter);
            }
        };


        fab_listar = findViewById(R.id.fab_listar);



        fab_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        mAdapter.stopListening();
    }

}
