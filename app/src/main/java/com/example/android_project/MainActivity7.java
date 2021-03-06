package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import Entidades.Plato;
import utilidades.MyAdapter;

import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity {

    private ListView listV_pedido;
    private Button btn_pedido;
    private ArrayList<Plato> lista_platos = new ArrayList<>();
    private ArrayList<Plato> platos_seleccionados;
    private ArrayList<Plato> platos_restaurante;
    private ArrayList<String> platos_rest = new ArrayList<>();
    private ArrayList<Integer> images_platos = new ArrayList<>();
    private String nombre;
    private Integer imagenInt;
    private String nombre_rest;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        listV_pedido = findViewById(R.id.listV_restaurantes);
        btn_pedido = findViewById(R.id.btn_pedido);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "platos", null, 1);

        platos_seleccionados = new ArrayList<>();

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            platos_restaurante = (ArrayList<Plato>) extras.get("carta");
            nombre = (String) extras.get("nombre");
            nombre_rest = (String) extras.get("nombre_rest");

        }

        for (Plato plato : platos_restaurante) {
            platos_rest.add(plato.toString());
            imagenInt = getResources().getIdentifier(plato.getImagen(), "drawable", this.getPackageName());
            images_platos.add(imagenInt);
        }

        MyAdapter adaptador = new MyAdapter(this, platos_rest, images_platos);

        listV_pedido.setAdapter(adaptador);

        listV_pedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String info = getText(R.string.plato_elegido) + platos_restaurante.get(position).getNombre() + "\n";
                info += getText(R.string.precio) + "" + platos_restaurante.get(position).getPrecio();
                Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG).show();

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
                eighthActivity.putExtra("nombre_rest", nombre_rest);

                startActivity(eighthActivity);
            }
        });
    }
}
