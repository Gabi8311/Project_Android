package Entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedidos implements Serializable {

    private Integer id_pedidos;
    private String nombre;
    private String plato;
    private Double tiempo_total;

    public Pedidos() {
    }

    public Integer getId_pedidos() {
        return id_pedidos;
    }

    public void setId_pedidos(Integer id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    public Double getTiempo_total() {
        return tiempo_total;
    }

    public void setTiempo_total(Double tiempo_total) {
        this.tiempo_total = tiempo_total;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    @Override
    public String toString() {
        return "Pedido : "+id_pedidos +"\n"+
                "Restaurante= " + plato +"\n"+
                "Tiempo_total=" + tiempo_total
                ;
    }
}