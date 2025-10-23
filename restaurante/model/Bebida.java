package com.restaurante.model;

import java.util.List;

public class Bebida {
    private int idBebida;
    private String nombre;
    private String descripcion;
    private double precio;
    private String tamaño;

    private Categorias categorias;
    
    private List<Detalle_Pedido> detalle_pedido;
    
    public Bebida() {}

    public Bebida(int idBebida, String nombre, String descripcion, double precio, String tamaño) {
        this.idBebida = idBebida;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tamaño = tamaño;
    }

    public int getIdBebida() { return idBebida; }
    public void setIdBebida(int idBebida) { this.idBebida = idBebida; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getTamaño() { return tamaño; }
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    public Categorias getCategorias() { return categorias; }
    public void setCategorias(Categorias categorias) { this.categorias = categorias; }

    public List<Detalle_Pedido> getDetalle_Pedido() { return detalle_pedido; }
    public void setDetalle_Pedido(List<Detalle_Pedido> detalle_pedido) { this.detalle_pedido = detalle_pedido; }
}

