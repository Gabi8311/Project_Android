package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import Entidades.Plato;
import utilidades.Utilidades;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity{

    private ListView listV_pedido;
    private Button btn_pedido;
    private ArrayList<Plato> lista_platos = new ArrayList<>();
    private ArrayList<Plato> platos_seleccionados;
    private ArrayList<Plato>platos_restaurante;
    private ArrayList<String>platos_rest= new ArrayList<>() ;
    private String nombre;

    ConexionSQLiteHelper conn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        listV_pedido = findViewById(R.id.listV_pedido);
        btn_pedido = findViewById(R.id.btn_pedido);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "platos", null, 1);

        platos_seleccionados = new ArrayList<>();

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            platos_restaurante = (ArrayList<Plato>) extras.get("carta");
            nombre = (String) extras.get("nombre");
        }

        for (Plato plato : platos_restaurante) {
            platos_rest.add(plato.toString());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, platos_rest);

        listV_pedido.setAdapter(adaptador);

        listV_pedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String info = "Plato elegido:"+ platos_restaurante.get(position).getNombre()+"\n";
               info += "Precio:" + platos_restaurante.get(position).getPrecio();
               Toast.makeText(getApplicationContext(),info,Toast.LENGTH_LONG).show();

                lista_platos.add(platos_restaurante.get(position));
            }
        });
        ///Para llevarnos los platos pedidos al main8
        btn_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent eighthActivity = new Intent(MainActivity7.this, MainActivity8.class);
                eighthActivity.putExtra("pedido", lista_platos);
                eighthActivity.putExtra("nombre", nombre);
                startActivity(eighthActivity);
            }
        });
    }



}