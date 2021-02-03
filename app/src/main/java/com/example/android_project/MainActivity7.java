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
import utilidades.Utilidades;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity{

    private ListView listV_pedido;
    private ArrayList<String> lista_informacion;
    private ArrayList<Plato> lista_platos;
    private ArrayList<Plato> platos_seleccionados;
    private String nombre;
    private ArrayList<Plato>platos_restaurante;
    private ArrayList<String>platos_rest= new ArrayList<>() ;

    ConexionSQLiteHelper conn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        listV_pedido = findViewById(R.id.listV_pedido);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "platos", null, 1);


        //consultar_lista_platos();

        platos_seleccionados = new ArrayList<>();

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            platos_restaurante = (ArrayList<Plato>) extras.get("carta");


        }

        System.out.println(platos_restaurante);

        for (Plato plato : platos_restaurante) {


            platos_rest.add(plato.getNombre_restaurante() + "  "+ plato.getNombre() +"  "+ plato.getPrecio() +"  € "+ plato.getDescripcion());

        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, platos_rest);

        listV_pedido.setAdapter(adaptador);


    }




}