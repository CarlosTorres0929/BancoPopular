package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class datosBanco extends AppCompatActivity {


    EditText nCuenta,saldo,tpCuenta;
    private FloatingActionButton fab_banco;

    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_banco);
        Toolbar toolbar = findViewById(R.id.toolbar_banco);
        setSupportActionBar(toolbar);

        mFirestore = FirebaseFirestore.getInstance();
        saldo = findViewById(R.id.saldo);
        tpCuenta = findViewById(R.id.tipocuenta);
        nCuenta = findViewById(R.id.cuenta);
        fab_banco = findViewById(R.id.fab_banco);
        fab_banco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    crearDatos();

                    startActivity(new Intent(datosBanco.this, MostrarDatos.class));

            }
        });
    }

    private void crearDatos(){

        String cuenta = nCuenta.getText().toString();
        String tcuenta = tpCuenta.getText().toString();
        String usaldo = saldo.getText().toString();

        Map<String, Object> map = new HashMap<>();
        map.put("numeroCuenta", cuenta);
        map.put("tipoCuenta", tcuenta);
        map.put("saldo", usaldo);
        //mFirestore.collection("cuentas").document().set(map).addOnSuccessListener();


            mFirestore.collection("cuentas").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(datosBanco.this, "La Cuenta se creo correctamente", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(datosBanco.this, "La Cuenta No Se Creo Correctamente", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
