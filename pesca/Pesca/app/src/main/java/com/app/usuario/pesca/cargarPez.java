package com.app.usuario.pesca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cargarPez extends Activity {

    private Button buttonCargar, buttonVolver;
    private EditText nombre, carnada, epoca, peso;
    private Db databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_pez);
        buttonCargar = (Button) findViewById(R.id.buttonCargar);
        buttonVolver = (Button) findViewById(R.id.buttonVolver);
        nombre = (EditText) findViewById(R.id.nombre);
        carnada = (EditText) findViewById(R.id.carnada);
        epoca = (EditText) findViewById(R.id.epoca);
        peso = (EditText) findViewById(R.id.peso);
        databaseHelper = new Db(this);

        buttonCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String car = carnada.getText().toString();
                String epo = epoca.getText().toString();
                int pes = Integer.parseInt( peso.getText().toString() );
                String nom = nombre.getText().toString();
                databaseHelper.addPez(nom,car,epo,pes);
                Toast.makeText(cargarPez.this, "Pez cargado con Exito.", Toast.LENGTH_SHORT).show();
            }
        });

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cargarPez.this, listaPescados.class);
                startActivity(intent);
            }
        });
    }
}
