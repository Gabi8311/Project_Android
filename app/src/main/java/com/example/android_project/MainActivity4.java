package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Entidades.Plato;
import utilidades.Utilidades;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import utilidades.Utilidades;

public class MainActivity4 extends AppCompatActivity {

    private EditText ed_nombre;
    private EditText ed_password;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;
    private Button btn_1;
    private ListView listViewPlatos;
    private ArrayList<String>lista_informacion;
    private ArrayList<Plato>lista_platos;
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        listViewPlatos = findViewById(R.id.listViewPlatos);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"platos",null,1);
        listViewPlatos = (ListView)findViewById(R.id.listViewPlatos);
        consultar_lista_platos();

        ArrayAdapter adaptador = new ArrayAdapter(this,R.layout.activity_main4,lista_informacion);

        listViewPlatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String informacion = "ID - " + lista_platos.get(position).getId_plato();
                informacion += "Nombre " + lista_platos.get(position).getNombre();
                informacion += "Descripción " + lista_platos.get(position).getDescripcion();
                informacion += "Precio " + lista_platos.get(position).getPrecio();
                informacion += "Tiempo " + lista_platos.get(position).getTiempo();


            }
        });
    }


 ////////////////////////////tV_comentarios6.setMovementMethod(new ScrollingMovementMethod());
    private void consultar_lista_platos() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Plato plato = null;
        lista_platos = new ArrayList<Plato>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PLATO,null);

        while(cursor.moveToNext()){
            Plato p = new Plato();
            p.setId_plato(cursor.getInt(0));
            p.setNombre(cursor.getString(1));
            p.setDescripcion(cursor.getString(2));
            p.setPrecio(cursor.getDouble(3));
            p.setTiempo(cursor.getInt(4));

            lista_platos.add(p);
        }
        obtener_lista();
    }

    private void obtener_lista() {
        lista_informacion = new ArrayList<String>();

        for (int i = 0;i < lista_platos.size();i++){
            lista_informacion.add(lista_platos.get(i).getNombre()+"-"+lista_platos.get(i).getDescripcion()+"-"
                    +lista_platos.get(i).getPrecio());
        }
        ed_nombre = findViewById(R.id.ed_nombre);
        ed_password = findViewById(R.id.ed_password);
        tv_1 = findViewById(R.id.tv_1);
        tv_2 = findViewById(R.id.tv_2);
        tv_3 = findViewById(R.id.tv_3);
        btn_1 = findViewById(R.id.btn_1);


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