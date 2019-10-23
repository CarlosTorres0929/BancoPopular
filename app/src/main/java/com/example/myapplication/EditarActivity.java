package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
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

import static com.example.myapplication.R.id.tipocuenta;
import static com.example.myapplication.R.id.tv_editar_titulo_nombre;


public class EditarActivity extends AppCompatActivity {

    private cuenta model;
    private FloatingActionButton btn_editar_editar;
    private EditText et_editar_nombre,
             et_editar_nCuenta,
             et_editar_tipo,
             et_editar_usaldo;

    private TextView tv_editar_nombre_titulo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Toolbar toolbar = findViewById(R.id.toolbar_editar);
        setSupportActionBar(toolbar);


        et_editar_nCuenta = findViewById(R.id.cuenta);
        et_editar_usaldo = findViewById(tipocuenta);
        et_editar_usaldo = findViewById(R.id.saldo);
        btn_editar_editar = findViewById(R.id.btn_editar_editar);
        tv_editar_nombre_titulo = findViewById(R.id.tv_editar_nombre_titulo);

        String id = getIntent().getStringExtra("id");


        btn_editar_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
               String nucuenta = et_editar_nCuenta.getText().toString();
                String ticuenta = et_editar_tipo.getText().toString();
                String saldo = et_editar_usaldo.getText().toString();





                model.getnCuenta();
                model.setTpCuenta(ticuenta);
                model.getUsaldo();

             //   btn_editar_editar.(model.getUsaldo()).setValue(model)
               //         .addOnSuccessListener(new OnSuccessListener<Void>() {
                 //           @Override
                   //         public void onSuccess(Void aVoid) {
                                Intent detalle = new Intent(EditarActivity.this, DetalleActivity.class);
                                detalle.putExtra("id", model.getUsaldo());
                                startActivity(detalle);
                                finish();
                            }
                        });
                    /*    .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(view, "Error al guardar", Snackbar.LENGTH_LONG).show();
                            }
                        });

            }

        });

        */

    }

}
