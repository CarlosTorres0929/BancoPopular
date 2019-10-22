package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public abstract class cuentasAdapter extends FirestoreRecyclerAdapter {


    public cuentasAdapter(@NonNull FirestoreRecyclerOptions<cuenta> options){
        super(options);
    }



    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull cuenta cuenta) {
               holder.nCuenta.setText(String.valueOf(cuenta.getnCuenta()));
               holder.tpCuenta.setText(cuenta.getTpCuenta());
               holder.usaldo.setText(String.valueOf(cuenta.getUsaldo()));
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_cuentas, viewGroup, false);
        return new ViewHolder(view);
    }



    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView nCuenta,tpCuenta,usaldo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nCuenta = itemView.findViewById(R.id.ncuenta);
            tpCuenta = itemView.findViewById(R.id.tpCuenta);
            usaldo = itemView.findViewById(R.id.usaldo);
        }

    }
}
