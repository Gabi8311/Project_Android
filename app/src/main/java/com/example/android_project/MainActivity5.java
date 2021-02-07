package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import utilidades.Utilidades;

public class MainActivity5 extends AppCompatActivity {

    private EditText ed_nombre;
    private EditText ed_password;
    private EditText ed_password2;
    private EditText ed_8;
    private EditText ed_9;
    private EditText ed_10;
    private Button btn_2;
    private String nombre;

    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        ed_nombre = findViewById(R.id.ed_111);
        ed_password = findViewById(R.id.ed_112);
        ed_password2 = findViewById(R.id.ed_password2);
        ed_8 = findViewById(R.id.ed_8);
        ed_9 = findViewById(R.id.ed_9);
        ed_10 = findViewById(R.id.ed_10);
        btn_2 = findViewById(R.id.btn_2);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {


            nombre = (String) extras.get("nombre");

        }

        mostrarInfo();

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ed_password.getText().toString().equals(ed_password2.getText().toString()) && ed_8.getText().toString().length() != 0 && ed_9.getText().toString().length() != 0
                        && ed_10.getText().toString().length() != 0 && ed_password2.getText().toString().length() != 0
                        ) {

                    modificarUsuario();

                }else{

                    Toast.makeText(getApplicationContext(), "Debe rellenar todos los campos y que su contraseña sea igual  ", Toast.LENGTH_SHORT).show();

                }
            }
        });




    }

    public void mostrarInfo() {


        SQLiteDatabase db = conn.getReadableDatabase();
        String [] parametros = {nombre};
        String [] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_PASSWORD,Utilidades.CAMPO_DIRECCION
                ,Utilidades.CAMPO_TELEFONO,Utilidades.CAMPO_EMAIL};


        try {

            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_NOMBRE+"=?", parametros, null, null, null);

            cursor.moveToFirst();


            if(cursor.getString(0).equals(nombre))  {

                ed_nombre.setText(cursor.getString(0));

                ed_8.setText(cursor.getString(2));
                ed_9.setText(cursor.getString(3));
                ed_10.setText(cursor.getString(4));


            }


            cursor.close();
            db.close();


        }catch(Exception e){

            Toast.makeText(getApplicationContext(), "Usuario no encontrado ", Toast.LENGTH_SHORT).show();


        }


    }

    public void modificarUsuario(){

        SQLiteDatabase db = conn.getWritableDatabase();
        String [] parametros = {ed_nombre.getText().toString()};
        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_PASSWORD,ed_password2.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCION,ed_8.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,ed_9.getText().toString());
        values.put(Utilidades.CAMPO_EMAIL,ed_10.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_NOMBRE+"=?",parametros);

        Toast.makeText(getApplicationContext(), "Base de datos actualizada ", Toast.LENGTH_SHORT).show();
}

}