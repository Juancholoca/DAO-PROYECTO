package com.restaurante.model;

import java.util.List;

public class Menu {

    private Long idMenu;
    private String nombrePlato;
    private String descripcion;
    private double precio;

    private List<Detalle_Pedido> detalles;
    private List<Categorias> categorias;

    public Menu() {}

    public Menu(String nombrePlato, String descripcion, double precio) {
        this.nombrePlato = nombrePlato;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Menu(Long idMenu, String nombrePlato, String descripcion, double precio) {
        this.idMenu = idMenu;
        this.nombrePlato = nombrePlato;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
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

    public List<Detalle_Pedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle_Pedido> detalles) {
        this.detalles = detalles;
    }

    public List<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categorias> categorias) {
        this.categorias = categorias;
    }
}
