package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Entidades.Plato;
import utilidades.Utilidades;

public class MainActivity9 extends AppCompatActivity {

    private TextView tv91;
    private TextView tv92;
    private TextView tv93;
    private String nombre;
    private Integer tiempo;
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_pedidos",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        tv91 = findViewById(R.id.tv91);
        tv92 = findViewById(R.id.tv92);
        tv93 = findViewById(R.id.tv93);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            nombre = (String) extras.get("nombre");
            tiempo = (Integer) extras.get("tiempo");

        }

        tv91.setText(nombre);
        tv92.setText("Su pedido llegará a su destino en: " );
        tv93.setText(String.valueOf(tiempo) + " minutos");
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Intent returnActivity = new Intent(MainActivity9.this, MainActivity2.class);
        returnActivity.putExtra("nombre",nombre);
        startActivity(returnActivity);

    }
}