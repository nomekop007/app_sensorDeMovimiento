package com.example.drios.tablayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.drios.tablayout.model.sensor;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2 extends Fragment {


    public Tab2() {
        // Required empty public constructor
    }


    TextView item_nombre ,item_num , item_fecha , item_id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        item_nombre = view.findViewById(R.id.nombre);
        item_num = view.findViewById(R.id.numero);
        item_fecha = view.findViewById(R.id.fecha);
        item_id = view.findViewById(R.id.id);
    resultadosSensores();

        return  view;
    }

    public void resultadosSensores() {
        String Url = "http://todojava.net/rios_list.php";

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) { //si la conexion es correcta
                    String respuesta = new String(responseBody);
                    Log.e("INFO",respuesta);

                    cargaRecycler(respuesta);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }//end funcion



    public void cargaRecycler(String respuesta) {



        int n = 0;
        String sensor = "";
        String nombre = "";
        String fecha = "";
        String id = "";
        try {
            //extrae el arreglo en el json
            JSONArray json = new JSONArray(respuesta);
            Log.e("info",respuesta);
            //recorrer arreglo
            for (int i = 0; i < json.length(); i++) {
                sensor c = new sensor();
                c.id = json.getJSONObject(i).getInt("id");
                c.name = json.getJSONObject(i).getString("name");
                c.sensor1 = json.getJSONObject(i).getInt("valor1");
                c.fecha = json.getJSONObject(i).getString("fecha");

                if (n < c.id){
                    n = c.id;
                 sensor = c.sensor1+"";
                 nombre = c.name;
                 fecha = c.fecha;
                    id = c.id+"";
                }
            }
          item_nombre.setText(nombre);
            item_num.setText(sensor);
            item_fecha.setText(fecha);
            item_id.setText(id);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
