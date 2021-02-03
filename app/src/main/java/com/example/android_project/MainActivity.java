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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


import Entidades.Plato;
import Entidades.Rellenar_carta;
import utilidades.Utilidades;

import static Entidades.Rellenar_carta.rellenar;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout cL_1;
    private TextView tV_user;
    private TextView tV_password;
    private EditText eT_user;
    private EditText eT_password;
    private TextView tV_error;
    private Button btn_enter;
    private TextView tV_registrate;

    private boolean platos_introducidos = false;

    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    ConexionSQLiteHelper conn2 = new ConexionSQLiteHelper(this,"platos",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cL_1 = findViewById(R.id.cL_1);
        btn_enter = findViewById(R.id.btn_enter);
        tV_user = findViewById(R.id.tV_user);
        tV_password = findViewById(R.id.tV_password);
        eT_user = findViewById(R.id.eT_user);
        eT_password = findViewById(R.id.eT_password);
        tV_error = findViewById(R.id.tV_error);
        tV_registrate = findViewById(R.id.tV_registrate);

        cL_1.setBackgroundColor(Color.BLACK);

        //Comprueba si los datos no están incluidos,no vuelve a crear ni insertar los platos
        if(!platos_introducidos){

            insertar_platos();
        }

        tV_registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent thirdActivity = new Intent(MainActivity.this, MainActivity3.class);

                startActivity(thirdActivity);


            }
        });


        btn_enter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                consultar();
            }
        });


        //Vacia el campo del User editText
        vaciar_campo(eT_user);

        //Vacia el campo del password editText
        vaciar_campo(eT_password);
        tV_error.setText("");

        //Limpia el foco cuando haces click en el constraint Layout
        cL_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT_user.clearFocus();
                eT_password.clearFocus();
            }
        });
    }


    public void consultar() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String [] parametros = {eT_user.getText().toString()};
        String [] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_PASSWORD};


        try {

            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_NOMBRE+"=?", parametros, null, null, null);

            cursor.moveToFirst();



            if(cursor.getString(0).equals(eT_user.getText().toString()) && cursor.getString(1).equals(eT_password.getText().toString()))  {

                Toast.makeText(getApplicationContext(), "Bienvenido ", Toast.LENGTH_SHORT).show();

                Intent secondActivity = new Intent(MainActivity.this, MainActivity2.class);
                secondActivity.putExtra("nombre",cursor.getString(0));
                startActivity(secondActivity);

            }


            cursor.close();
            db.close();


        }catch(Exception e){

            Toast.makeText(getApplicationContext(), "Usuario incorrecto ", Toast.LENGTH_SHORT).show();
        }
    }

    public void vaciar_campo(EditText campo) {
        campo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    campo.getText().clear();
                    campo.setTextColor(Color.parseColor(getString(R.color.white)));
                    tV_error.setText("");
                }
            }
        });
    }

    public void insertar_platos() {

        SQLiteDatabase db = conn2.getWritableDatabase();

        ArrayList<ArrayList>all_dishes = new ArrayList<>();
        all_dishes = Rellenar_carta.rellenar();


            for (ArrayList<Plato> carta : all_dishes) {
                for (Plato plato : carta) {

                    ContentValues valores = new ContentValues();
                    valores.put(Utilidades.CAMPO_NOMBRE_PLATO, plato.getNombre());
                    valores.put(Utilidades.CAMPO_DESCRIPCION_PLATO, plato.getDescripcion());
                    valores.put(Utilidades.CAMPO_PRECIO_PLATO, plato.getPrecio());
                    valores.put(Utilidades.CAMPO_TIEMPO_PLATO, plato.getTiempo());
                    valores.put(Utilidades.CAMPO_NOMBRE_RESTAURANTE,plato.getNombre_restaurante());

                    db.insert(Utilidades.TABLA_PLATO, null, valores);
                }
            }

        db.close();
        platos_introducidos = true;
    }

}
