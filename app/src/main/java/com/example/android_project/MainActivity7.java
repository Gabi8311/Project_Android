package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import Entidades.Plato;
import utilidades.Utilidades;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {
    private TextView tV_pedido;
    private ListView listV_pedido;
    private ArrayList<String> lista_informacion;
    private ArrayList<Plato> platos_seleccionados;
    private ArrayList<Plato> platos_restaurante;
    private String nombre_restaurante;
    private ArrayList<String> platos_rest = null;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "platos", null, 1);
        listV_pedido = (ListView) findViewById(R.id.listV_pedido);
        tV_pedido = findViewById(R.id.tV_pedido);
        platos_seleccionados = new ArrayList<>();

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            nombre_restaurante = (String) extras.get("restaurante");
        }

        platos_seleccionados = consultar_carta(nombre_restaurante);

        for(Plato p:platos_seleccionados){
            System.out.println(p+"dsdfsdfsdfsdfsdfsdfsdfsdf");
            platos_rest.add(p.toString());
        }


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, platos_rest);

        listV_pedido.setAdapter(adaptador);

//        listV_pedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {

//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                platos_restaurante2.add(lista_platos.get(position));
//
//                String informacion = "ID - " + lista_platos.get(position).getId_plato();
//                informacion += "Nombre " + lista_platos.get(position).getNombre();
//                informacion += "Descripción " + lista_platos.get(position).getDescripcion();
//                informacion += "Precio " + lista_platos.get(position).getPrecio();
//                informacion += "Tiempo " + lista_platos.get(position).getTiempo();
//                informacion += "Nombre del Restaurante" + lista_platos.get(position).getNombre_restaurante();
//                Toast.makeText(getApplicationContext(), informacion, Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
    public ArrayList<Plato> consultar_carta(String parametro) {
        System.out.println("Entroppppppppppppppppppppppppppppppppppppppppppppp");
        SQLiteDatabase db = conn.getReadableDatabase();
        Plato plato = null;
        String [] parametros = {parametro};
        String [] campos = {Utilidades.CAMPO_ID_PLATO,Utilidades.CAMPO_NOMBRE_PLATO,Utilidades.CAMPO_DESCRIPCION_PLATO,Utilidades.CAMPO_PRECIO_PLATO,Utilidades.CAMPO_TIEMPO_PLATO,Utilidades.CAMPO_NOMBRE_RESTAURANTE};
        platos_restaurante = new ArrayList<>();
        try {
        Cursor cursor = db.query(Utilidades.TABLA_PLATO, campos, Utilidades.CAMPO_NOMBRE_RESTAURANTE+"=?", parametros, null, null, null);
        while(cursor.moveToNext()) {

            if (cursor.getString(4).equalsIgnoreCase(parametro)) {
                System.out.println("Entroffffffffffffffffffffffffff");
                plato = new Plato();
                plato.setId_plato(cursor.getInt(0));
                plato.setNombre(cursor.getString(1));
                plato.setDescripcion(cursor.getString(2));
                plato.setPrecio(cursor.getDouble(3));
                plato.setTiempo(cursor.getInt(4));
                plato.setNombre_restaurante(cursor.getString(5));
                System.out.println(plato.toString()+"soy el platoooooooooooooooooooooooooooooooo");
                platos_restaurante.add(plato);
            }
        }
            cursor.close();
            db.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return platos_restaurante;
    }
//    private void consultar_lista_platos() {
//        SQLiteDatabase db = conn.getReadableDatabase();
//
//        lista_platos = new ArrayList<Plato>();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PLATO, null);
//
//        while (cursor.moveToNext()) {
//
//            Plato p = new Plato();
//            p.setId_plato(cursor.getInt(0));
//            p.setNombre(cursor.getString(1));
//            p.setDescripcion(cursor.getString(2));
//            p.setPrecio(cursor.getDouble(3));
//            p.setTiempo(cursor.getInt(4));
//
//            lista_platos.add(p);
//        }
//        obtener_lista();
//    }
//
    private void obtener_lista() {

        lista_informacion = new ArrayList<String>();

        for (int i = 0; i < platos_restaurante.size(); i++) {
            lista_informacion.add(platos_restaurante.get(i).getNombre() + "-" + platos_restaurante.get(i).getDescripcion() + "-"
                    + platos_restaurante.get(i).getPrecio());
        }
    }

}