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

    ConexionSQLiteHelper conn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        listV_pedido = findViewById(R.id.listViewPlatos);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "platos", null, 1);
        listV_pedido = (ListView) findViewById(R.id.listViewPlatos);

        //consultar_lista_platos();

        platos_seleccionados = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        ArrayList<String>platos_rest = null;
        if (extras != null) {
            System.out.println(extras.toString()+"extrassssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
            platos_restaurante = (ArrayList<Plato>) extras.get("carta");
            platos_rest = new ArrayList<>();
            for(Plato plato: platos_restaurante){
                System.out.println(plato+"lo que viene del bundleeeeeeeeeeeeeeeeeeeeee");
                platos_rest.add(plato.toString());
            }
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,platos_rest );
        listV_pedido.setAdapter(adaptador);

        listV_pedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                platos_restaurante.add(lista_platos.get(position));

                String informacion = "ID - " + lista_platos.get(position).getId_plato();
                informacion += "Nombre " + lista_platos.get(position).getNombre();
                informacion += "Descripción " + lista_platos.get(position).getDescripcion();
                informacion += "Precio " + lista_platos.get(position).getPrecio();
                informacion += "Tiempo " + lista_platos.get(position).getTiempo();
                informacion += "Nombre del Restaurante" + lista_platos.get(position).getNombre_restaurante();
                Toast.makeText(getApplicationContext(), informacion, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void consultar_lista_platos() {
        SQLiteDatabase db = conn.getReadableDatabase();

        lista_platos = new ArrayList<Plato>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PLATO, null);

        while (cursor.moveToNext()) {

            Plato p = new Plato();
            p.setId_plato(cursor.getInt(0));
            p.setNombre(cursor.getString(1));
            p.setDescripcion(cursor.getString(2));
            p.setPrecio(cursor.getDouble(3));
            p.setTiempo(cursor.getInt(4));

            lista_platos.add(p);
        }
        obtener_lista();
    }

    private void obtener_lista() {

        lista_informacion = new ArrayList<String>();

        for (int i = 0; i < lista_platos.size(); i++) {
            lista_informacion.add(lista_platos.get(i).getNombre() + "-" + lista_platos.get(i).getDescripcion() + "-"
                    + lista_platos.get(i).getPrecio());
        }
    }

}