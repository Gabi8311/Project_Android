package com.example.android_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private ConstraintLayout cL_2;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
}