package com.example.android_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import Entidades.Plato;
import utilidades.MyAdapter;
import utilidades.MyAdapter2;
import utilidades.Utilidades;

public class MainActivity2 extends AppCompatActivity {

    private LinearLayout linearLayout2;
    private ListView listV_restaurantes;
    private String nombre;
    private ArrayList<Plato> platos_restaurante;
    private ArrayList<String> nombres_restaurantes;
    private ArrayList<Integer> imagenes_restaurantes;

    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "platos", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombres_restaurantes = new ArrayList<>(Arrays.asList("Sushita", "Alfredo´s", "Babel", "Pulcinella", "O´recanto", "Trattoria", "El Asador", "Cantina Tío Paco", "El Rincón del Gourmet", "Minotauro"));
        imagenes_restaurantes = new ArrayList<>(Arrays.asList(R.drawable.sushita3, R.drawable.alfredos, R.drawable.babel, R.drawable.pulcinella, R.drawable.orecanto,
                R.drawable.trattoria, R.drawable.asador, R.drawable.cantina_tio_paco, R.drawable.rincon_gourmet, R.drawable.minotauro));
        listV_restaurantes = (ListView) findViewById(R.id.listV_restaurantes);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            nombre = (String) extras.get("nombre");
        }

        MyAdapter2 myAdapterRest = new MyAdapter2(this, nombres_restaurantes, imagenes_restaurantes);
        listV_restaurantes.setAdapter(myAdapterRest);

        listV_restaurantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                switch (position) {
                    case 0:
                        consultar_carta("Sushita", view);
                        break;

                    case 1:
                        consultar_carta("Alfredo´s", view);
                        break;

                    case 3:
                        consultar_carta("Babel", view);
                        break;

                    case 4:
                        consultar_carta("Pulcinella", view);
                        break;

                    case 5:
                        consultar_carta("O´recanto", view);
                        break;

                    case 6:
                        consultar_carta("Trattoria", view);
                        break;

                    case 7:
                        consultar_carta("El Asador", view);
                        break;

                    case 8:
                        consultar_carta("Cantina Tío Paco", view);
                        break;

                    case 9:
                        consultar_carta("El Rincón del Gourmet", view);
                        break;

                    case 10:
                        consultar_carta("Minotauro", view);

                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.consultar:

                Intent fourthActivity = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(fourthActivity);

                return true;

            case R.id.modificar:

                Intent fiveActivity = new Intent(MainActivity2.this, MainActivity5.class);
                fiveActivity.putExtra("nombre", nombre);
                startActivity(fiveActivity);

                return true;

            case R.id.salir:

                Intent secondActivity = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(secondActivity);

                return true;

            case R.id.pedidos:

                Intent tenActivity = new Intent(MainActivity2.this, MainActivity10.class);
                tenActivity.putExtra("nombre", nombre);
                startActivity(tenActivity);

                return true;

            case R.id.borrar:

                Intent elevenActivity = new Intent(MainActivity2.this, MainActivity11.class);
                elevenActivity.putExtra("nombre", nombre);
                startActivity(elevenActivity);

                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

    public void consultar_carta(String parametro, View v) {

        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {parametro};
        String[] campos = {Utilidades.CAMPO_NOMBRE_PLATO, Utilidades.CAMPO_DESCRIPCION_PLATO, Utilidades.CAMPO_PRECIO_PLATO, Utilidades.CAMPO_TIEMPO_PLATO, Utilidades.CAMPO_NOMBRE_RESTAURANTE};
        platos_restaurante = new ArrayList<>();

        try {

            Cursor cursor = db.query(Utilidades.TABLA_PLATO, campos, Utilidades.CAMPO_NOMBRE_RESTAURANTE + "=?", parametros, null, null, null);

            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

                if (cursor.getString(4).equalsIgnoreCase(parametro)) {

                    Plato p = new Plato();

                    p.setNombre(cursor.getString(0));
                    p.setDescripcion(cursor.getString(1));
                    p.setPrecio(cursor.getDouble(2));
                    p.setTiempo(cursor.getInt(3));
                    p.setNombre_restaurante(cursor.getString(4));

                    platos_restaurante.add(p);
                }
            }

            cursor.close();
            db.close();

            Intent seventhActivity = new Intent(MainActivity2.this, MainActivity7.class);
            seventhActivity.putExtra("carta", platos_restaurante);
            seventhActivity.putExtra("nombre", nombre);
            startActivity(seventhActivity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}