package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import utilidades.Utilidades;

public class MainActivity3 extends AppCompatActivity {

    TextView ed_1;
    TextView ed_2;
    TextView ed_3;
    TextView ed_4;
    TextView ed_5;
    Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ed_1 = findViewById(R.id.ed_1);
        ed_2 = findViewById(R.id.ed_2);
        ed_3 = findViewById(R.id.ed_3);
        ed_4 = findViewById(R.id.ed_4);
        ed_5 = findViewById(R.id.ed_5);
        btn_registrar = findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                comprobarUsuario();

            }
        });
    }

    private void comprobarUsuario() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

        ContentValues values = new ContentValues();

        Boolean verificar = false;

        SQLiteDatabase dbRead = conn.getReadableDatabase();//El nombre de usuario es único,no se repite,leo las tablas para saber si esta.
        String[] parametros = {ed_1.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE};

        Cursor cursor = dbRead.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_NOMBRE + "=?", parametros, null, null, null);

        if (cursor.moveToFirst() && cursor != null) {

            if (cursor.getString(0).equals(ed_1.getText().toString())) {

                Toast.makeText(getApplicationContext(), "Nombre de usuario ya registrado ", Toast.LENGTH_SHORT).show();

                verificar = true;
            }
        }

        cursor.close();
        dbRead.close();

        if (!verificar) {

            registrarUsuario();

            Intent firstActivity = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(firstActivity);
        }
    }

    public void registrarUsuario() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

        ContentValues values = new ContentValues();

        SQLiteDatabase db = conn.getWritableDatabase();

        values.put(Utilidades.CAMPO_NOMBRE, ed_1.getText().toString());
        values.put(Utilidades.CAMPO_PASSWORD, ed_2.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCION, ed_3.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, ed_4.getText().toString());
        values.put(Utilidades.CAMPO_EMAIL, ed_5.getText().toString());

        Long idFinal = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);

        Toast.makeText(getApplicationContext(), "id Registro: " + idFinal, Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void vaciar_campo(EditText campo) {
        campo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    campo.getText().clear();
                    campo.setTextColor(Color.parseColor(getString(R.color.white)));
                }
            }
        });
    }
}