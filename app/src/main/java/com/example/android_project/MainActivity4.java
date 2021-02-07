package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Entidades.Plato;
import utilidades.Utilidades;

import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    private ListView listViewPlatos;
    private ArrayList<String>lista_informacion;
    private ArrayList<Plato>lista_platos;
    private EditText ed_nombre;
    private EditText ed_password;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private Button btn_1;
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ed_nombre = findViewById(R.id.ed_111);
        ed_password = findViewById(R.id.ed_112);
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);
        btn_1 = findViewById(R.id.btn_111);


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarInfo();

            }
        });


    }

    public void mostrarInfo() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String [] parametros = {ed_nombre.getText().toString()};
        String [] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_PASSWORD,Utilidades.CAMPO_DIRECCION
        ,Utilidades.CAMPO_TELEFONO,Utilidades.CAMPO_EMAIL};


        try {

            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_NOMBRE+"=?", parametros, null, null, null);

            cursor.moveToFirst();



            if(cursor.getString(0).equals(ed_nombre.getText().toString()) && cursor.getString(1).equals(ed_password.getText().toString()))  {

                tv_1.setText(cursor.getString(2));
                tv_2.setText(cursor.getString(3));
                tv_3.setText(cursor.getString(4));


            }


            cursor.close();
            db.close();


        }catch(Exception e){

            Toast.makeText(getApplicationContext(), "Usuario incorrecto ", Toast.LENGTH_SHORT).show();
        }

    }
}