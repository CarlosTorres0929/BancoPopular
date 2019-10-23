package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class DetalleActivity extends AppCompatActivity {

    private cuenta model;
    private FloatingActionButton btn_detalle_editar, btn_detalle_eliminar;
    private EditText nCuenta,tpcuenta,usaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = findViewById(R.id.toolbar_detalle);
        setSupportActionBar(toolbar);

        nCuenta = findViewById(R.id.cuenta);
        tpcuenta = findViewById(R.id.tipocuenta);
        usaldo = findViewById(R.id.saldo);
        btn_detalle_editar = findViewById(R.id.btn_detalle_editar);
        btn_detalle_eliminar = findViewById(R.id.btn_detalle_eliminar);

        FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
        Query query = mFirestore.collection("cuentas");


        /*

        model = new cuenta();

        String id = getIntent().getStringExtra("id");
        if(id != null && !id.equals("")){
            child(id).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    model = dataSnapshot.getValue(cuenta.class);
                    if(model != null){
                        String nombre_completo = model.get_nombres() + "\n" + model.get_apellidos();
                        String celular = model.get_();
                        String fijo = model.get_fijo();
                        String trabajo = model.get_trabajo();

                        setTitle("Información de " + model.get_nombres());

                        tv_detalle_nombre.setText(nombre_completo);
                        tv_detalle_celular.setText(celular);
                        tv_detalle_fijo.setText(fijo);
                        tv_detalle_trabajo.setText(trabajo);

                        tv_detalle_correo.setText(model.get_correo());
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(DetalleActivity.this, "Error :" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

         */

        btn_detalle_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar nb = Snackbar.make(view, "¿Esta seguro que desea eliminar a " + model.getnCuenta() + " ?", Snackbar.LENGTH_LONG);
                nb.setAction("¡Sí!", new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {

                        finish();
                    }
                });
                nb.show();
            }
        });

        btn_detalle_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irAEditar();
            }
        });
    }

    public void irAEditar(){
        Intent editar = new Intent(DetalleActivity.this, EditarActivity.class);
            startActivity(editar);
            finish();
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_detalle_salir) {
            finish();
        }else if (id == R.id.action_detalle_editar) {
            irAEditar();
        }
        return super.onOptionsItemSelected(item);
    }
}

