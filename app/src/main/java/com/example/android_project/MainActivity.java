package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


import Entidades.Plato;
import utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout cL_1;
    private TextView tV_user;
    private TextView tV_password;
    private EditText eT_user;
    private EditText eT_password;
    private TextView tV_error;
    private Button btn_enter;
    private TextView tV_registrate;

    private ArrayList<Plato> platos_Alfredos;
    private ArrayList<Plato> platos_Babel;
    private ArrayList<Plato> platos_Orecanto;
    private ArrayList<Plato> platos_Pulcinella;
    private ArrayList<Plato> platos_Sushita;
    private ArrayList<ArrayList> all_dishes;

    private boolean platos_introducidos = false;

    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cL_1 = findViewById(R.id.cL_1);
        btn_enter = findViewById(R.id.btn_enter);
        tV_user = findViewById(R.id.tV_user);
        tV_password = findViewById(R.id.tV_password);
        eT_user = findViewById(R.id.eT_user);
        eT_password = findViewById(R.id.eT_password);
        tV_error = findViewById(R.id.tV_error);
        tV_registrate = findViewById(R.id.tV_registrate);

        cL_1.setBackgroundColor(Color.BLACK);

        //Comprueba si los datos no están incluidos,no vuelve a crear ni insertar los platos
        if(!platos_introducidos) {

            Plato p1 = new Plato(1, "Hamburguesa BBQ", "Con nuestra salsa BBQ", 12, 5);
            Plato p2 = new Plato(2, "Hamburguesa PHILADELPHIA", "Queso Philadelphia y cebolla a la parrilla", 13, 6);
            Plato p3 = new Plato(3, "Hamburguesa CHILI", "Chile con carne", 9, 4);
            Plato p4 = new Plato(4, "Hamburguesa BTL O QLT", "Bacon, lechuga, tomate y mayonesa", 17, 8);
            Plato p5 = new Plato(5, "Hamburguesa BROOKLYN", "Mozzarella, aceite de oliva virgen extra y orégano", 17, 8);
            Plato p6 = new Plato(6, "Hamburguesa KEFTA", "Con especias marroquíes y ensalada de picadillo", 9, 6);
            Plato p7 = new Plato(7, "Hamburguesa SOUTHERN JACK", "Con especias del sudoeste, queso Monterrey Jack, pimiento frito y cebolla", 18, 9);
            Plato p8 = new Plato(8, "Hamburguesa CLASSIC", "Queso, bacon y nuestra salsa BBQ", 18, 7);
            Plato p9 = new Plato(9, "Hamburguesa GOAT", "Queso de cabra y cebolla caramelizada", 19, 8);
            Plato p10 = new Plato(10, "Hamburguesa VEGGIE", "Nuestra excepción para vegetarianos experimentados", 15, 8);

            platos_Alfredos = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));


            Plato p11 = new Plato(11, "Croquetas con chipirones", "Con aguacate, pepinillo y papaya", 14, 6);
            Plato p12 = new Plato(12, "Huevos rotos", "A baja temperatura al aroma de trufa blanca con crujiente jamón", 10, 6);
            Plato p13 = new Plato(13, "Poke de salmón", "Chile con carne", 9, 4);
            Plato p14 = new Plato(14, "Arroz a banda", "(Para 2 personas)Precio por persona", 10, 10);
            Plato p15 = new Plato(15, "Hamburguesa de picada de vaca", "Madurada con idiazabál y mahonesa de albahaca", 14, 8);
            Plato p16 = new Plato(16, "Bao de pollo", "Con pollo y shitake", 5, 4);
            Plato p17 = new Plato(17, "Bao de costillas", "Con costillas desmijadas estilo cajún", 6, 6);
            Plato p18 = new Plato(18, "Jarrete de ternera", "Asado a baja temperatura con kimchee ahumado y patatas al tomillo", 18, 7);
            Plato p19 = new Plato(19, "Dados de carrillera ibérica", "Con cous cous de verduras", 14, 9);
            Plato p20 = new Plato(20, "Tiradito de atún rojo", "Con coulis de ají amarillo y naranja", 18, 8);

            platos_Babel = new ArrayList<>(Arrays.asList(p11, p12, p13, p14, p15, p16, p17, p18, p19, p20));


            Plato p21 = new Plato(21, "Rabo de toro", "De los mejores del mundo", 17, 8);
            Plato p22 = new Plato(22, "Callos con garbanzos", "Te faltará pan para todo lo que vas a desear mojar en ellos", 17, 9);
            Plato p23 = new Plato(23, "Manitas de cerdo", "Preparadas por los especialistas más codiciados en este sagrado manjar", 14, 10);
            Plato p24 = new Plato(24, "Mariscada cocida", "Gran mariscada para 2 personas mínimo", 85, 10);
            Plato p25 = new Plato(25, "Cigala de tronco", "El precio corresponde a cada Kg", 165, 8);
            Plato p26 = new Plato(26, "Solomillo O´grelo", "La más deliciosa carne que puedas encontrar.Gallega 100%", 55, 8);
            Plato p27 = new Plato(27, "Entrecot de ternera gallega", "Una de nuestras especialidades.Uno de los platos que nos ha hecho famosos", 21, 7);
            Plato p28 = new Plato(28, "Chuletón de vaca gallegaa", "La mejor carne que puedas encontrar.Si encuentra algo mejor le devolvemos el dinero", 59, 8);
            Plato p29 = new Plato(29, "Steak tartere rubia gallega", "Auténtica ambrosía de los dioses", 25, 9);
            Plato p30 = new Plato(30, "Bogavante", "El precio por cada Kg", 80, 8);

            platos_Orecanto = new ArrayList<>(Arrays.asList(p21, p22, p23, p24, p25, p26, p27, p28, p29, p30));


            Plato p31 = new Plato(31, "Paccheri con bogavante", "Con un toque de tomate San Marzano y guindilla", 24, 8);
            Plato p32 = new Plato(32, "Spaghetti Nerano", "Con calabacín.Provolone del Monaco, parmesano y pimienta negra", 13, 8);
            Plato p33 = new Plato(33, "Delizia marí", "Rellena de ricotta y espinacas con crema de pesto de pistacho", 15, 9);
            Plato p34 = new Plato(34, "Pollo alla cacciatora", "Pechuga de pollo con salsa de tomate,champiñones, acompañados de puré de patata trufado", 12, 10);
            Plato p35 = new Plato(35, "Scaloppine al Marsala", "Filetes de ternera blanca al vino Marsala, romero y guindilla", 16, 8);
            Plato p36 = new Plato(36, "Tagliata di Manzo", "Solomillo con salsa de boletus y trufa fresca, acompañado de puré trufado de patata", 20, 8);
            Plato p37 = new Plato(37, "Rigatoni all'indiavolata", "Con champiñones, panceta italiana, mozzarella y guindilla en nuestra salsa de tomate San Marzano", 14, 7);
            Plato p38 = new Plato(38, "Spaghetti alla carbonara", "Preparados según la receta original, con yema de huevo, parmesano,panceta italiana y pimienta negra", 12, 8);
            Plato p39 = new Plato(39, "Pennette salmone e vodka", "Con salmón fresco, cebolla, nata y un toque de vodka", 18, 7);
            Plato p40 = new Plato(40, "Lasagna emiliana", "Con salsa de tomate San Marzano con ternera picada y bechamel", 18, 10);

            platos_Pulcinella = new ArrayList<Plato>(Arrays.asList(p31, p32, p33, p34, p35, p36, p37, p38, p39, p40));


            Plato p41 = new Plato(41, "Rollitos de pato", "Los mejores rollitos del mundo.Relleno de carne de pato", 9, 6);
            Plato p42 = new Plato(42, "Croquetas de atún Katsoubushi", "Uno de nuestros más pedidos por nuestros comensales", 8, 5);
            Plato p43 = new Plato(43, "Rollo tartar de atún picante", "Con atún rojo de máxima calidad y un ligero tono picante", 12, 9);
            Plato p44 = new Plato(44, "California especial", "Maki especial con sémola alrededor, relleno de gamba y quinoa", 12, 10);
            Plato p45 = new Plato(45, "Solomillo con salsa teriyaki", "Carne de máxima calidad con nuestra famosa salsa", 18, 8);
            Plato p46 = new Plato(46, "Mien con trufa, setas y huevo escalfado", "Una de nuestras especialidades.Con un suave sabor a trufa y huevo", 16, 8);
            Plato p47 = new Plato(47, "Pizza crujiente de aguacate con huevo", "Con un suave toque a aguacate y huevo.Súper crujiente", 14, 7);
            Plato p48 = new Plato(48, "Lubina al vapor marinada", "Hecha por las mejores manos de nuestro restaurante", 12, 8);
            Plato p49 = new Plato(49, "Costillas de ternera al josper con salsa picante", "Nuestro nivel de picante es un poco alto.Para estómagos fuertes", 16, 9);
            Plato p50 = new Plato(50, "Arroz frito con confit de pato", "Es una delicia juntando dos de nuestros platos estrella", 11, 8);

            platos_Sushita = new ArrayList<>(Arrays.asList(p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

            all_dishes = new ArrayList<>(Arrays.asList(platos_Alfredos, platos_Babel, platos_Orecanto, platos_Pulcinella, platos_Sushita));

           // insertar_platos();
        }

        tV_registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent thirdActivity = new Intent(MainActivity.this, MainActivity3.class);

                startActivity(thirdActivity);


            }
        });


        btn_enter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                consultar();
            }
        });


        //Vacia el campo del User editText
        vaciar_campo(eT_user);

        //Vacia el campo del password editText
        vaciar_campo(eT_password);
        tV_error.setText("");

        //Limpia el foco cuando haces click en el constraint Layout
        cL_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eT_user.clearFocus();
                eT_password.clearFocus();
            }
        });
    }


    public void consultar() {

        SQLiteDatabase db = conn.getReadableDatabase();
        String [] parametros = {eT_user.getText().toString()};
        String [] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_PASSWORD};


        try {

            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_NOMBRE+"=?", parametros, null, null, null);

            cursor.moveToFirst();



            if(cursor.getString(0).equals(eT_user.getText().toString()) && cursor.getString(1).equals(eT_password.getText().toString()))  {

                Toast.makeText(getApplicationContext(), "Bienvenido ", Toast.LENGTH_SHORT).show();

                Intent secondActivity = new Intent(MainActivity.this, MainActivity2.class);
                secondActivity.putExtra("nombre",cursor.getString(0));
                startActivity(secondActivity);

            }


            cursor.close();
            db.close();


        }catch(Exception e){

            Toast.makeText(getApplicationContext(), "Usuario incorrecto ", Toast.LENGTH_SHORT).show();
        }
    }

    public void vaciar_campo(EditText campo) {
        campo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    campo.getText().clear();
                    campo.setTextColor(Color.parseColor(getString(R.color.white)));
                    tV_error.setText("");
                }
            }
        });
    }

    public void insertar_platos() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "Platos", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        if (db != null) {
            for (ArrayList<Plato> carta : all_dishes) {
                for (Plato plato : carta) {
                    ContentValues valores = new ContentValues();
                    valores.put(Utilidades.CAMPO_ID_PLATO, plato.getId_plato());
                    valores.put(Utilidades.CAMPO_NOMBRE_PLATO, plato.getNombre());
                    valores.put(Utilidades.CAMPO_DESCRIPCION_PLATO, plato.getDescripcion());
                    valores.put(Utilidades.CAMPO_PRECIO_PLATO, plato.getPrecio());
                    valores.put(Utilidades.CAMPO_TIEMPO_PLATO, plato.getTiempo());

                    db.insert(Utilidades.TABLA_PLATO, null, valores);
                }
            }
        }
        db.close();
        platos_introducidos = true;
    }

}
