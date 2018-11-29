package com.app.usuario.pesca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class asignar_pez extends Activity {

    private Db databaseHelper;
    private Button buttonAsignar, buttonPeces;
    private EditText nombre_pez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asignar_pez);
        databaseHelper = new Db(this);
        buttonAsignar = (Button) findViewById(R.id.buttonAsignar);
        buttonPeces = (Button) findViewById(R.id.buttonPeces);
        databaseHelper = new Db(this);
        nombre_pez = (EditText) findViewById(R.id.nombre);


        buttonAsignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombre_pez.getText().toString();
                String resultado = databaseHelper.asignarPez(nombre);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            }
        });

        buttonPeces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(asignar_pez.this, listaPescados.class);
                startActivity(intent);
            }
        });

    }
}
