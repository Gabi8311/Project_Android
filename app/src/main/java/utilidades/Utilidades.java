package utilidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import Entidades.Plato;

public class Utilidades implements Serializable {
    //Clase con las constantes de los nombres de las tablas y los campos

    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="name";
    public static final String CAMPO_DIRECCION="addres";
    public static final String CAMPO_PASSWORD="password";
    public static final String CAMPO_TELEFONO="telefono";
    public static final String CAMPO_EMAIL="email";
    ///////////////////////////////////////////////
    public static final String TABLA_PLATO = "plato";
    public static final String CAMPO_ID_PLATO = "id_plato";
    public static final String CAMPO_NOMBRE_PLATO = "nombre";
    public static final String CAMPO_DESCRIPCION_PLATO = "descripcion";
    public static final String CAMPO_PRECIO_PLATO = "precio";
    public static final String CAMPO_TIEMPO_PLATO = "tiempo";
    public static final String CAMPO_NOMBRE_RESTAURANTE = "nombre_restaurante";

    ///////////////////////////////////////////////
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_ID+" INTEGER,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_DIRECCION
            +" TEXT,"+CAMPO_PASSWORD+" TEXT,"+CAMPO_TELEFONO+" INTEGER,"+CAMPO_EMAIL+" TEXT)";

    public static final String CREAR_TABLA_PLATO = "CREATE TABLE "+ TABLA_PLATO + "("+ CAMPO_ID_PLATO +" INTEGER," + CAMPO_NOMBRE_PLATO + " TEXT," + CAMPO_DESCRIPCION_PLATO
            + " TEXT," + CAMPO_PRECIO_PLATO + " DOUBLE," + CAMPO_TIEMPO_PLATO + " INTEGER," + CAMPO_NOMBRE_RESTAURANTE +" TEXT);";


}
