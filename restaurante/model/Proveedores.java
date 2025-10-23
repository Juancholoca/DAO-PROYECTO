package com.restaurante.model;

import java.util.List;

public class Proveedores {
    private int idProveedor;
    private String nombre;
    private String telefono;
    private String direccion;

    private List<Producto> producto;
    
    public Proveedores() {}

    public Proveedores(int idProveedor, String nombre, String telefono, String direccion) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public List<Producto> getProducto() { return producto; }
    public void setProducto(List<Producto> producto) { this.producto = producto; }
}

