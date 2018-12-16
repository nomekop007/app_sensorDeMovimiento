package com.example.drios.tablayout;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.drios.tablayout.model.sensor;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1 extends Fragment {

    private RecyclerView recycler;

    public Tab1() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);


        recycler = view.findViewById(R.id.recycler);


        resultadosSensores();
        return view;
    }

    public void resultadosSensores() {
        String Url = "http://todojava.net/rios_list.php";

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) { //si la conexion es correcta
                    String respuesta = new String(responseBody);
                    Log.e("INFO", respuesta);

                    cargaRecycler(respuesta);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }//end funcion


    public void cargaRecycler(String respuesta) {
        LinearLayoutManager lm = new LinearLayoutManager(null);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(lm);
        try {
            List<sensor> lista = new ArrayList<>();
            //extrae el arreglo en el json
            JSONArray json = new JSONArray(respuesta);
            Log.e("info", respuesta);
            //recorrer arreglo
            for (int i = 0; i < json.length(); i++) {
                sensor c = new sensor();
                c.id = json.getJSONObject(i).getInt("id");
                c.name = json.getJSONObject(i).getString("name");
                c.sensor1 = json.getJSONObject(i).getInt("valor1");
                c.fecha = json.getJSONObject(i).getString("fecha");
                lista.add(c);
            }

            //cargar en el listView la lista de cometarios
            Adaptador ad = new Adaptador(null, R.layout.item_card, lista);
            recycler.setAdapter(ad);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }






}
