package com.restaurante.model;

import java.sql.Date;

public class Producto {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private String descripcion;
    private String unidadMedida;
    private Integer idProveedor;
    private Date fechaUltimaCompra;

    private Proveedores proveedores;
    
    public Producto() {}

    public Producto(int idProducto, String nombre, int cantidad, String descripcion, String unidadMedida, Integer idProveedor, Date fechaUltimaCompra) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.idProveedor = idProveedor;
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public Integer getIdProveedor() { return idProveedor; }
    public void setIdProveedor(Integer idProveedor) { this.idProveedor = idProveedor; }

    public Date getFechaUltimaCompra() { return fechaUltimaCompra; }
    public void setFechaUltimaCompra(Date fechaUltimaCompra) { this.fechaUltimaCompra = fechaUltimaCompra; }

    public Proveedores getProveedoresr() { return proveedores; }
    public void setProveedores(Proveedores proveedores) { this.proveedores = proveedores; }
}
