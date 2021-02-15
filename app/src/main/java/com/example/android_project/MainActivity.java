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

import java.util.ArrayList;

import Entidades.Plato;
import Entidades.Rellenar_carta;
import utilidades.Utilidades;



public class MainActivity extends AppCompatActivity {
    private ConstraintLayout cL_1;
    private TextView tV_user;
    private TextView tV_password;
    private EditText eT_user;
    private EditText eT_password;
    private Button btn_enter;
    private TextView tV_registrate;

    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

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
        tV_registrate = findViewById(R.id.tV_registrate);

        cL_1.setBackgroundColor(Color.BLACK);

        //Comprueba si los datos no están incluidos, no vuelve a crear ni insertar los platos
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

                verificar_carta();
                consultar_usuario();

            }
        });

        vaciar_campo(eT_user);
        vaciar_campo(eT_password);

        //Limpia el foco cuando haces click en el constraint Layout
        cL_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT_user.clearFocus();
                eT_password.clearFocus();
            }
        });
    }

    public void consultar_usuario() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String [] parametros = {eT_user.getText().toString()};
        String [] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_PASSWORD};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_NOMBRE+"=?", parametros, null, null, null);
            cursor.moveToFirst();

            if(cursor.getString(0).equals(eT_user.getText().toString())) {

                if(cursor.getString(0).equals(eT_user.getText().toString()) && cursor.getString(1).equals(eT_password.getText().toString()))  {

                    Toast.makeText(getApplicationContext(), getText(R.string.bienvenido) , Toast.LENGTH_SHORT).show();

                    Intent secondActivity = new Intent(MainActivity.this, MainActivity2.class);
                    secondActivity.putExtra("nombre",cursor.getString(0));
                    startActivity(secondActivity);

                }else{

                    Toast.makeText(getApplicationContext(), getText(R.string.password_incorrecto), Toast.LENGTH_SHORT).show();
                }
            }

            cursor.close();
            db.close();

        }catch(Exception e){

            Toast.makeText(getApplicationContext(), getText(R.string.usuario_incorrecto), Toast.LENGTH_SHORT).show();
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

    //Introducidos los platos la primera vez y luego para no introducirlos de nuevo verificamos que exista la tabla
    public void verificar_carta() {

        ConexionSQLiteHelper conn2 = new ConexionSQLiteHelper(this,"platos",null,1);

        SQLiteDatabase db = conn2.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM plato", null);

        if(!cursor.moveToFirst()){

            insertar_platos();

        }

        db.close();
        cursor.close();
    }

    public void insertar_platos() {

        ConexionSQLiteHelper conn2 = new ConexionSQLiteHelper(this,"platos",null,1);

        SQLiteDatabase db = conn2.getWritableDatabase();

        ArrayList<ArrayList>all_dishes;
        all_dishes = Rellenar_carta.rellenar();

                for (ArrayList<Plato> carta : all_dishes) {
                    for (Plato plato : carta) {

                        ContentValues valores = new ContentValues();
                        valores.put(Utilidades.CAMPO_NOMBRE_PLATO, plato.getNombre());
                        valores.put(Utilidades.CAMPO_DESCRIPCION_PLATO, plato.getDescripcion());
                        valores.put(Utilidades.CAMPO_PRECIO_PLATO, plato.getPrecio());
                        valores.put(Utilidades.CAMPO_TIEMPO_PLATO, plato.getTiempo());
                        valores.put(Utilidades.CAMPO_NOMBRE_RESTAURANTE, plato.getNombre_restaurante());

                valores.put(Utilidades.CAMPO_IMAGEN_PLATO, plato.getImagen());

                        db.insert(Utilidades.TABLA_PLATO, Utilidades.CAMPO_ID_PLATO, valores);

                }
            }

        db.close();
    }
}
