package com.restaurante.model;

import java.util.List;

public class Postre {
    private int idPostre;
    private String nombre;
    private String descripcion;
    private double precio;

    private Categorias categorias;
    private List<Detalle_Pedido> detalle_pedido;
    
    public Postre() {}

    public Postre(int idPostre, String nombre, String descripcion, double precio) {
        this.idPostre = idPostre;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIdPostre() { return idPostre; }
    public void setIdPostre(int idPostre) { this.idPostre = idPostre; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public Categorias getCategorias() { return categorias; }
    public void setCategorias(Categorias categorias) { this.categorias = categorias; }

    public List<Detalle_Pedido> getDetalle_Pedido() { return detalle_pedido; }
    public void setDetalle_Pedido(List<Detalle_Pedido> detalle_pedido) { this.detalle_pedido = detalle_pedido; }

}


