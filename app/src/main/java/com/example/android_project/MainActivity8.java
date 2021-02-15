package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import Entidades.Plato;
import utilidades.Utilidades;
import utilidades.MyAdapter;

public class MainActivity8 extends AppCompatActivity {

    private LinearLayout linearLayout8;
    private ListView listV_pedido2;
    private TextView tV_8;
    private ArrayList<Plato> platos_elegidos = new ArrayList<>();
    private ArrayList<String> tu_pedido = new ArrayList<>();
    private Button btn_confirmar;
    private ArrayList<Integer> images = new ArrayList<>();
    private String total_string;
    private double precio_total = 0;
    private Integer tiempo_total = 0;
    private String nombre;
    private Integer imagesInt;
    private String nombre_rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        listV_pedido2 = (ListView) findViewById(R.id.listV_pedido2);
        linearLayout8 = findViewById(R.id.linearLayout8);
        tV_8 = findViewById(R.id.tV_8);
        linearLayout8 = findViewById(R.id.linearLayout8);
        btn_confirmar = findViewById(R.id.btn_confirmar);

        linearLayout8.setBackgroundResource(R.color.black);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            platos_elegidos = (ArrayList<Plato>) extras.get("pedido");
            nombre = (String) extras.get("nombre");
            nombre_rest = (String) extras.get("nombre_rest");


        }

        for (Plato plato : platos_elegidos) {
            tu_pedido.add(plato.toString());
            imagesInt = getResources().getIdentifier(plato.getImagen(), "drawable", this.getPackageName());
            images.add(imagesInt);

            precio_total += plato.getPrecio();
            tiempo_total += plato.getTiempo();
        }
        total_string = Double.toString(precio_total);


        tV_8.setText(getText(R.string.total) + total_string + "€");

        MyAdapter myAdapter = new MyAdapter(this, tu_pedido, images);
        listV_pedido2.setAdapter(myAdapter);


        listV_pedido2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                lanzar_alertD(position, myAdapter, tV_8);

            }
        });

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (platos_elegidos.size() <= 0) {

                    Toast.makeText(getApplicationContext(), getText(R.string.platos_no_introducidos), Toast.LENGTH_SHORT).show();

                } else {

                    registrarPedido();
                }
            }
        });
    }

    public void registrarPedido() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_pedidos", null, 1);

        ContentValues values = new ContentValues();

        SQLiteDatabase db = conn.getWritableDatabase();

        //se añaden 10 min por desplazamiento
        tiempo_total += 10;

        values.put(Utilidades.CAMPO_NOMBRE, nombre);
        values.put(Utilidades.CAMPO_LISTA_PEDIDOS, tu_pedido.toString());
        values.put(Utilidades.CAMPO_TIEMPO_TOTAL, tiempo_total);
        values.put(Utilidades.CAMPO_NOMBRE_REST,nombre_rest);


        Long idFinal = db.insert(Utilidades.TABLA_PEDIDOS, Utilidades.CAMPO_ID_PEDIDO, values);

        Toast.makeText(getApplicationContext(), "id Registro: " + idFinal, Toast.LENGTH_SHORT).show();
        db.close();

        Intent nineActivity = new Intent(MainActivity8.this, MainActivity9.class);

        nineActivity.putExtra("nombre", nombre);
        nineActivity.putExtra("tiempo", tiempo_total);


        startActivity(nineActivity);
    }

    public void lanzar_alertD(int position, MyAdapter myAdapter, TextView tv_8) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

// Configura el titulo.
        alertDialogBuilder.setTitle(getText(R.string.elegir_accion));

// Configura el mensaje.
        alertDialogBuilder
                .setMessage(getText(R.string.eliminar_plato_pedido))
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        precio_total = 0;
                        tu_pedido.remove(position);
                        platos_elegidos.remove(position);
                        myAdapter.notifyDataSetChanged();

                        for (Plato plato : platos_elegidos) {
                            precio_total += plato.getPrecio();
                        }
                        total_string = Double.toString(precio_total);
                        tv_8.setText(getText(R.string.total) + total_string + "€");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                }).create().show();
    }
}
