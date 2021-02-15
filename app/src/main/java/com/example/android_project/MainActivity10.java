package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Entidades.Pedidos;
import utilidades.MyAdapter;
import utilidades.Utilidades;

public class MainActivity10 extends AppCompatActivity {

    private String nombre;
    private ListView lv1;
    private ArrayList<Pedidos> pedido;
    private ArrayList<String> pedido_s;
    private TextView tv100;
    private ArrayList<Integer> images_platos = new ArrayList<>();
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_pedidos", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        lv1 = (findViewById(R.id.lv1));
        tv100 = findViewById(R.id.tv100);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            nombre = (String) extras.get("nombre");
        }

        tv100.setText(nombre + " , "+ R.string.suspe +": ");
        consultar();

    }

    public void consultar() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {nombre};
        String[] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_LISTA_PEDIDOS, Utilidades.CAMPO_TIEMPO_TOTAL,Utilidades.CAMPO_NOMBRE_REST};
        pedido = new ArrayList<>();
        pedido_s = new ArrayList<>();
        int contador = 1;

        try {

            Cursor cursor = db.query(Utilidades.TABLA_PEDIDOS, campos, Utilidades.CAMPO_NOMBRE + "=?", parametros, null, null, null);

            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

                if (cursor.getString(0).equals(nombre)) {

                    Pedidos p = new Pedidos();

                    p.setPlato(cursor.getString(1));
                    p.setTiempo_total(cursor.getDouble(2));
                    p.setId_pedidos(contador);
                    p.setNombre_rest(cursor.getString(3));

                    pedido.add(p);

                    contador++;

                }
            }

            cursor.close();
            db.close();

            for (Pedidos ped : pedido) {

                pedido_s.add(ped.toString());
                images_platos.add(R.drawable.silueta);

            }

            MyAdapter add = new MyAdapter(this, pedido_s, images_platos);

            lv1.setAdapter(add);

        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), R.string.pedidos, Toast.LENGTH_SHORT).show();
        }
    }
}