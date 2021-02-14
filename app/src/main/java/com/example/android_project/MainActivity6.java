package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Entidades.Plato;
import utilidades.MyAdapter;
import utilidades.Utilidades;

public class MainActivity6 extends AppCompatActivity {

    private ListView listViewPlatos;
    private ArrayList<String>lista_informacion;
    private ArrayList<Plato>lista_platos;
    private ArrayList<Integer>lista_images;
    ConexionSQLiteHelper conn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        listViewPlatos = findViewById(R.id.listViewPlatos);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"platos",null,1);
        listViewPlatos = (ListView)findViewById(R.id.listViewPlatos);
        consultar_lista_platos();

        MyAdapter adaptador = new MyAdapter(this,lista_informacion,lista_images);

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
            p.setImagen(cursor.getString(5));

            lista_platos.add(p);
        }
        obtener_lista();
    }

    private void obtener_lista() {
        lista_informacion = new ArrayList<String>();
        lista_images = new ArrayList<>();

        for (int i = 0;i < lista_platos.size();i++){
            lista_informacion.add(lista_platos.get(i).getNombre()+"-"+lista_platos.get(i).getDescripcion()+"-"
                    +lista_platos.get(i).getPrecio());
            lista_images.add(R.drawable.comidas);
        }
    }
}