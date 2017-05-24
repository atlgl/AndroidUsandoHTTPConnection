package com.example.angelus.productosapirest;

/**
 * Created by Angelus on 17/05/2017.
 */

public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String fecha;
    private Object urlfoto;

    public Producto() {
    }

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Producto(int id, String nombre, String descripcion, Double precio, String fecha, Object urlfoto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha = fecha;
        this.urlfoto = urlfoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Object getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(Object urlfoto) {
        this.urlfoto = urlfoto;
    }

    @Override
    public String toString() {
        return "{\"nombre\":\""+this.nombre+
                "\",\"descripcion\":\""+this.descripcion+
                "\",\"precio\":\""+this.precio+
                "\",\"fecha\":\""+this.fecha+"\",\"urlfoto\":null}";
    }
}
