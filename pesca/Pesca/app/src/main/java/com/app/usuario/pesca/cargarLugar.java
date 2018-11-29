package com.app.usuario.pesca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cargarLugar extends Activity {

    private Button buttonCargar, buttonVolver;
    private EditText nombre, latitud, longitud;
    private Db databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_lugar);
        buttonCargar = (Button) findViewById(R.id.buttonCargar);
        buttonVolver = (Button) findViewById(R.id.buttonVolver);
        nombre = (EditText) findViewById(R.id.nombre);
        latitud = (EditText) findViewById(R.id.carnada);
        longitud = (EditText) findViewById(R.id.epoca);
        databaseHelper = new Db(this);

        buttonCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lat = Integer.parseInt( latitud.getText().toString() );
                int lon = Integer.parseInt( longitud.getText().toString() );
                String nom = nombre.getText().toString();
                databaseHelper.addLugar(nom,lat, lon);
                Toast.makeText(cargarLugar.this, "Lugar cargado con Exito.", Toast.LENGTH_SHORT).show();
            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cargarLugar.this, listaLugares.class);
                startActivity(intent);
            }
        });
    }
}