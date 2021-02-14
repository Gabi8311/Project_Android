package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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

    private EditText ed_1;
    private EditText ed_2;
    private EditText ed_3;
    private EditText ed_4;
    private EditText ed_5;
    private Button btn_registrar;
    private ConstraintLayout cl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cl3 = findViewById(R.id.cl3);
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

        vaciar_campo(ed_1);
        vaciar_campo(ed_2);
        vaciar_campo(ed_3);
        vaciar_campo(ed_4);
        vaciar_campo(ed_5);

        //Limpia el foco cuando haces click en el constraint Layout
        cl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_1.clearFocus();
                ed_2.clearFocus();
                ed_3.clearFocus();
                ed_4.clearFocus();
                ed_5.clearFocus();
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

            if (ed_1.getText().toString().length() != 0 && ed_2.getText().toString().length() > 7
                    && ed_3.getText().toString().length() != 0 && ed_4.getText().toString().length() != 0
                    && ed_5.getText().toString().length() != 0) {

                registrarUsuario();

                Intent firstActivity = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(firstActivity);
            } else if(ed_2.getText().toString().length() <= 7){

                Toast.makeText(getApplicationContext(), "La contraseña debe ser mayor de 8 digitos", Toast.LENGTH_SHORT).show();

            }else{

                Toast.makeText(getApplicationContext(), "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();

            }
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
                }
            }
        });
    }
}