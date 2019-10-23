package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class cuentasAdapter extends BaseAdapter {


    private final Context context;
    private cuenta model;
    private ArrayList<cuenta> list;


    public cuentasAdapter(Context context, ArrayList<cuenta> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View miVista = view;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            miVista = inflater.inflate(R.layout.view_cuentas, viewGroup, false);
        }

        TextView item_models_list_nombres = miVista.findViewById(R.id.item_contacto_list_nombres);
        cuenta model = (cuenta) getItem(i);

        int datosCuenta;
            if (model.getTpCuenta().isEmpty()) {
                datosCuenta = model.getnCuenta();
            } else {
                datosCuenta = model.getUsaldo();
            }
        item_models_list_nombres.setText(datosCuenta);


        return miVista;
    }
}
