package com.app.usuario.pesca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button buttonLugar, buttonPez;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLugar = (Button) findViewById(R.id.button);
        buttonPez = (Button) findViewById(R.id.button2);

        buttonLugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, listaLugares.class);
                startActivity(intent);
            }
        });

        buttonPez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, listaPescados.class);
                startActivity(intent);
            }
        });
    }
}
