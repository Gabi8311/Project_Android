package Entidades;

public class Plato {

    private int id_plato;
    private String nombre;
    private String descripcion;
    private double precio;
    private int tiempo;

    public Plato() {

    }

    public Plato(int id_plato, String nombre, String descripcion, double precio, int tiempo) {
        this.id_plato = id_plato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempo = tiempo;
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

    @Override
    public String toString() {
        return "Plato\n" +
                "Id_plato --> " + this.id_plato +
                "- Nombre: " + this.nombre +
                "- Descripción: " + this.descripcion +
                "- Precio: " + this.precio +
                "- Tiempo: " + this.tiempo;
    }
}
