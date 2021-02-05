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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Entidades.Plato;
import utilidades.Utilidades;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    private ConstraintLayout cL_2;
    private String nombre;
    private ImageView iV_1_res,iV_2_res,iV_3_res,iV_4_res,iV_5_res,iV_6_res,iV_7_res,iV_8_res,iV_9_res,iV_10_res;
    private TextView tV_1_res,tV_2_res,tV_3_res,tV_4_res,tV_5_res,tV_6_res,tV_7_res,tV_8_res,tV_9_res,tV_10_res;
    ArrayList<Plato>platos_restaurante;
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"platos",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        iV_1_res = findViewById(R.id.iV_1_res);
        iV_2_res = findViewById(R.id.iV_2_res);
        iV_3_res = findViewById(R.id.iV_3_res);
        iV_4_res = findViewById(R.id.iV_4_res);
        iV_5_res = findViewById(R.id.iV_5_res);
        iV_6_res = findViewById(R.id.iV_6_res);
        iV_7_res = findViewById(R.id.iV_7_res);
        iV_8_res = findViewById(R.id.iV_8_res);
        iV_9_res = findViewById(R.id.iV_9_res);
        iV_10_res = findViewById(R.id.iV_10_res);

        tV_1_res = findViewById(R.id.tV_1_res);
        tV_2_res = findViewById(R.id.tV_2_res);
        tV_3_res = findViewById(R.id.tV_3_res);
        tV_4_res = findViewById(R.id.tV_4_res);
        tV_5_res = findViewById(R.id.tV_5_res);
        tV_6_res = findViewById(R.id.tV_6_res);
        tV_7_res = findViewById(R.id.tV_7_res);
        tV_8_res = findViewById(R.id.tV_8_res);
        tV_9_res = findViewById(R.id.tV_9_res);
        tV_10_res = findViewById(R.id.tV_10_res);

        iV_1_res.setOnClickListener(this);
        iV_2_res.setOnClickListener(this);
        iV_3_res.setOnClickListener(this);
        iV_4_res.setOnClickListener(this);
        iV_5_res.setOnClickListener(this);
        iV_6_res.setOnClickListener(this);
        iV_7_res.setOnClickListener(this);
        iV_8_res.setOnClickListener(this);
        iV_9_res.setOnClickListener(this);
        iV_10_res.setOnClickListener(this);

        tV_1_res.setOnClickListener(this);
        tV_2_res.setOnClickListener(this);
        tV_3_res.setOnClickListener(this);
        tV_4_res.setOnClickListener(this);
        tV_5_res.setOnClickListener(this);
        tV_6_res.setOnClickListener(this);
        tV_7_res.setOnClickListener(this);
        tV_8_res.setOnClickListener(this);
        tV_9_res.setOnClickListener(this);
        tV_10_res.setOnClickListener(this);

        cL_2 = findViewById(R.id.cL_2);

        cL_2.setBackgroundColor(Color.BLACK);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
             nombre = (String) extras.get("nombre");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.consultar:

                Intent fourthActivity = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(fourthActivity);

                return true;

            case R.id.modificar:

                Intent fiveActivity = new Intent(MainActivity2.this, MainActivity5.class);
                fiveActivity.putExtra("nombre",nombre);
                startActivity(fiveActivity);

                return true;

            case R.id.salir:

                Intent secondActivity = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(secondActivity);

                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iV_1_res:
            case R.id.tV_1_res:
                consultar_carta("Sushita",v);
                break;

            case R.id.iV_2_res:
            case R.id.tV_2_res:
                consultar_carta("Alfredo´s",v);
                break;
            case R.id.iV_3_res:
            case R.id.tV_3_res:
                consultar_carta("Babel",v);
                break;
            case R.id.iV_4_res:
            case R.id.tV_4_res:
                consultar_carta("Pulcinella",v);
                break;
            case R.id.iV_5_res:
            case R.id.tV_5_res:
                consultar_carta("O´recanto",v);
                break;
            case R.id.iV_6_res:
            case R.id.tV_6_res:

            case R.id.iV_7_res:
            case R.id.tV_7_res:

            case R.id.iV_8_res:
            case R.id.tV_8_res:

            case R.id.iV_9_res:
            case R.id.tV_9_res:

            case R.id.iV_10_res:
            case R.id.tV_10_res:

        }
    }
///////////Esto lo tengo que adaptar para que me traiga los platos
    //Tengo que ponerle el compo nombre de restaurnte
    public void consultar_carta(String parametro,View v) {

       SQLiteDatabase db = conn.getReadableDatabase();
        String [] parametros = {parametro};
        String [] campos = {Utilidades.CAMPO_NOMBRE_PLATO,Utilidades.CAMPO_DESCRIPCION_PLATO,Utilidades.CAMPO_PRECIO_PLATO,Utilidades.CAMPO_TIEMPO_PLATO,Utilidades.CAMPO_NOMBRE_RESTAURANTE};
        platos_restaurante = new ArrayList<>();

        try {

            Cursor cursor = db.query(Utilidades.TABLA_PLATO, campos, Utilidades.CAMPO_NOMBRE_RESTAURANTE+"=?", parametros, null, null, null);

            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

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
            startActivity(seventhActivity);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}