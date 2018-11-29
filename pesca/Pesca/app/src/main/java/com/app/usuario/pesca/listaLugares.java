package com.app.usuario.pesca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listaLugares extends Activity {

    private ListView listView;
    private ArrayList<MapaModel> mapaModelArrayList;
    private customAdapter customAdapter;
    private Db databaseHelper;
    private Button buttonCargar, buttonVolver;
    public static Long id_lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traer_lugares);
        listView = (ListView) findViewById(R.id.lv);
        buttonCargar = (Button) findViewById(R.id.button3);
        buttonVolver = (Button) findViewById(R.id.buttonVolver);
        databaseHelper = new Db(this);

        mapaModelArrayList = databaseHelper.todosLosLugares();

        customAdapter = new customAdapter(this,mapaModelArrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(listaLugares.this, peces_del_lugar.class);
                id_lugar = id;
                startActivity(intent);

            }
        });

        buttonCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listaLugares.this, cargarLugar.class);
                startActivity(intent);
            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listaLugares.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
