package com.restaurante.model;

import java.util.List;

public class Comida {
    private int idComida;
    private String nombre;
    private String descripcion;
    private double precio;
    private String tipo;
    
    private Categorias categorias;
    
    private List<Detalle_Pedido> detalle_pedido;
    
    public Comida() {}

    public Comida(int idComida, String nombre, String descripcion, double precio, String tipo) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getIdComida() { return idComida; }
    public void setIdComida(int idComida) { this.idComida = idComida; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Categorias getCategorias() { return categorias; }
    public void setCategorias(Categorias categorias) { this.categorias = categorias; }

    public List<Detalle_Pedido> getDetalle_Pedido() { return detalle_pedido; }
    public void setDetalle_Pedido(List<Detalle_Pedido> detalle_pedido) { this.detalle_pedido = detalle_pedido; }

}

