package Entidades;

import java.io.Serializable;

public class Plato implements Serializable {

    private int id_plato;
    private String nombre;
    private String descripcion;
    private double precio;
    private int tiempo;
    private String nombre_restaurante;

    public Plato () {

    }

    public Plato(int id_plato, String nombre, String descripcion, double precio, int tiempo,String nombre_restaurante) {
        this.id_plato = id_plato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempo = tiempo;
        this.nombre_restaurante = nombre_restaurante;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getNombre_restaurante() {
        return nombre_restaurante;
    }

    public void setNombre_restaurante(String nombre_restaurante) {
        this.nombre_restaurante = nombre_restaurante;
    }

    @Override
    public String toString() {
        return
                "Nombre --> " + this.nombre +" -->  Precio" + this.precio + "\n" + this.descripcion;
    }
}
