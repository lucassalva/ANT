package com.app.usuario.pesca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class listaPescados extends Activity {

    private ListView listView;
    private ArrayList<PezModel> pezModelArrayList;
    private customAdapter2 customAdapter2;
    private Db databaseHelper;
    private Button buttonCargar, buttonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traer_peces);
        listView = (ListView) findViewById(R.id.lv);
        buttonCargar = (Button) findViewById(R.id.button3);
        buttonVolver = (Button) findViewById(R.id.buttonVolver);
        databaseHelper = new Db(this);

        pezModelArrayList = databaseHelper.todosLosPeces();

        customAdapter2 = new customAdapter2(this,pezModelArrayList);
        listView.setAdapter(customAdapter2);

        buttonCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listaPescados.this, cargarPez.class);
                startActivity(intent);
            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(listaPescados.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
