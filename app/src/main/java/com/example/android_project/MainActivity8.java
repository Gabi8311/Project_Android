package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import Entidades.Plato;
import utilidades.MyAdapter;

public class MainActivity8 extends AppCompatActivity {

    private LinearLayout linearLayout8;
    private ListView listV_pedido2;
    private TextView tv_8;
    private ArrayList<Plato> platos_elegidos = new ArrayList<>();
    private ArrayList<String> tu_pedido = new ArrayList<>();
    private ArrayList<Integer>images = new ArrayList<>();
    private String total_string;
    private double precio_total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        listV_pedido2 = (ListView) findViewById(R.id.listV_pedido2);


        tv_8 = findViewById(R.id.tv_8);
        linearLayout8 = findViewById(R.id.linearLayout8);

        //linearLayout8.setBackgroundResource(R.drawable.comidas);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            platos_elegidos = (ArrayList<Plato>) extras.get("pedido");

        }

        for (Plato plato : platos_elegidos) {
            tu_pedido.add(plato.toString());
            images.add(R.drawable.alfredos);
            precio_total += plato.getPrecio();
        }
        total_string = Double.toString(precio_total);

        tv_8.setText("Total --> " + total_string + "€");

        MyAdapter myAdapter = new MyAdapter(this,tu_pedido,images);
        listV_pedido2.setAdapter(myAdapter);


        listV_pedido2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                lanzar_alertD(position, myAdapter, tv_8);

            }
        });
    }

    public void lanzar_alertD(int position, MyAdapter myAdapter, TextView tv_8) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

// Configura el titulo.
        alertDialogBuilder.setTitle("Elegir acción");

// Configura el mensaje.
        alertDialogBuilder
                .setMessage("Quieres eliminar este plato?")
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
                        tv_8.setText("Total --> " + total_string + "€");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                }).create().show();
    }}