package com.example.drios.tablayout;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.drios.tablayout.model.sensor;

import java.util.List;

public class Adaptador  extends RecyclerView.Adapter<Adaptador.SensorHolder>{


    private Activity activity;
    private int recurso;
    private List<sensor> lista;


    public Adaptador(Activity activity, int recurso, List<sensor> lista) {
        this.activity = activity;
        this.recurso = recurso;
        this.lista = lista;
    }

    @NonNull
    @Override
    public SensorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(recurso,viewGroup,false);

        return new SensorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorHolder sensorHolder, int i) {
            sensor s = lista.get(i);
            sensorHolder.txtcicle.setText(s.id+"");
            sensorHolder.txtname.setText(s.name);
            sensorHolder.txtsensor.setText("resultado : "+s.sensor1+"");
            sensorHolder.txtfecha.setText(s.fecha);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public class SensorHolder extends RecyclerView.ViewHolder{
        private TextView txtcicle ,txtname, txtsensor,txtfecha;
        private int id;

        public SensorHolder(@NonNull View itemView) {
            super(itemView);
            txtcicle = itemView.findViewById(R.id.card_circle);
            txtname = itemView.findViewById(R.id.item_name);
            txtsensor = itemView.findViewById(R.id.item_sensor);
            txtfecha = itemView.findViewById(R.id.item_fecha);

        }
    }
}
