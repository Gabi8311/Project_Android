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
import utilidades.Utilidades;

public class MainActivity10 extends AppCompatActivity {


    private String nombre;
    private ListView lv1;
    private ArrayAdapter add;
    private ArrayList<Pedidos> pedido;
    private ArrayList<String> pedido_s;
    private TextView tv100;
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_pedidos",null,1);

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

        tv100.setText(nombre +" , sus pedidos son: ");
        consultar();



    }

    public void consultar() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String [] parametros = {nombre};
        String [] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_LISTA_PEDIDOS,Utilidades.CAMPO_TIEMPO_TOTAL};
        pedido = new ArrayList<>();
        pedido_s = new ArrayList<>();
        int contador = 1;

        try {

            Cursor cursor = db.query(Utilidades.TABLA_PEDIDOS, campos, Utilidades.CAMPO_NOMBRE+"=?", parametros, null, null, null);

          for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())  {

                System.out.println("dentro del cursor");

                if (cursor.getString(0).equals(nombre)) {

                    Pedidos p = new Pedidos();


                    p.setPlato(cursor.getString(1));
                    p.setTiempo_total(cursor.getDouble(2));
                    p.setId_pedidos(contador);

                    pedido.add(p);

                    contador++;

                }

            }


            cursor.close();
            db.close();

            for(Pedidos ped : pedido){

                pedido_s.add(ped.toString());


            }

            ArrayAdapter<String> add = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pedido_s);

            lv1.setAdapter(add);


        }catch(Exception e){

            Toast.makeText(getApplicationContext(), "Usuario incorrecto ", Toast.LENGTH_SHORT).show();
        }
    }




}