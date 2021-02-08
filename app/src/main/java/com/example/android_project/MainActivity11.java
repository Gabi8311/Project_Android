package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import utilidades.Utilidades;

public class MainActivity11 extends AppCompatActivity {

    private ConstraintLayout cl11;
    private EditText ed_111;
    private EditText ed_112;
    private Button btn_111;
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        cl11=findViewById(R.id.cl11);
        ed_111=findViewById(R.id.ed_nombre);
        ed_112=findViewById(R.id.ed_password);
        btn_111=findViewById(R.id.btn_111);
        cl11 = findViewById(R.id.cl11);

        btn_111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    mostrarInfo();

            }
        });

        vaciar_campo(ed_111);

        vaciar_campo(ed_112);

        //Limpia el foco cuando haces click en el constraint Layout
        cl11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_111.clearFocus();
                ed_112.clearFocus();
            }
        });



    }

    private void borrar()   {



        SQLiteDatabase db1 = conn.getWritableDatabase();

        String [] parametros = {ed_111.getText().toString()};

        db1.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_NOMBRE+ "=?",parametros);

        Toast.makeText(getApplicationContext(), "Usuario borrado ", Toast.LENGTH_SHORT).show();

        Intent returnActivity = new Intent(MainActivity11.this, MainActivity.class);

        startActivity(returnActivity);


        db1.close();

    }

    public void mostrarInfo() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {ed_111.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_PASSWORD};


        try {

            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_NOMBRE + "=?", parametros, null, null, null);

            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

                if (cursor.getString(0).equals(ed_111.getText().toString()) && cursor.getString(1).equals(ed_112.getText().toString())) {

                    borrar();


                }

            }
            cursor.close();
            db.close();


        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "Usuario no encontrado ", Toast.LENGTH_SHORT).show();
        }
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