package com.app.usuario.pesca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class peces_del_lugar extends Activity {

    private ListView listView;
    private ArrayList<PezModel> pezModelArrayList;
    private customAdapter3 customAdapter3;
    private Db databaseHelper;
    private Button buttonCargar, buttonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peces_lugar);
        listView = (ListView) findViewById(R.id.lv);
        buttonCargar = (Button) findViewById(R.id.button3);
        buttonVolver = (Button) findViewById(R.id.buttonVolver);
        databaseHelper = new Db(this);
        Long id_lug = listaLugares.id_lugar;

        pezModelArrayList = databaseHelper.todosLosPecesDelLugar(id_lug);

        customAdapter3 = new customAdapter3(this,pezModelArrayList);
        listView.setAdapter(customAdapter3);

        buttonCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(peces_del_lugar.this, asignar_pez.class);
                startActivity(intent);
            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(peces_del_lugar.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

