package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Entidades.Plato;

public class MainActivity8 extends AppCompatActivity {

    private LinearLayout linearLayout8;
    private ListView listV_pedido2;
    private TextView tv_8;
    private ArrayList<Plato>platos_elegidos = new ArrayList<>();
    private ArrayList<String>tu_pedido = new ArrayList<>();
    private double precio_total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        listV_pedido2 = (ListView)findViewById(R.id.listV_pedido2);
        tv_8 = findViewById(R.id.tV_8);
        linearLayout8 = findViewById(R.id.linearLayout8);

        linearLayout8.setBackgroundResource(R.drawable.comidas);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            platos_elegidos = (ArrayList<Plato>) extras.get("pedido");

        }

        for (Plato plato : platos_elegidos) {
            tu_pedido.add(plato.toString());
            precio_total += plato.getPrecio();
        }
        String total_string = Double.toString(precio_total);

        tv_8.setText("Total --> "+ total_string + "€");

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tu_pedido);

        listV_pedido2.setAdapter(adaptador2);

        listV_pedido2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {



            }
        });
    }
}