package com.restaurante.model;

import java.util.List;

public class Empleados {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String cargo;
    private String telefono;
    private double sueldo;

    private List<Pedido> pedido;
    
    public Empleados() {}

    public Empleados(int idEmpleado, String nombre, String apellido, String cargo, String telefono, double sueldo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.telefono = telefono;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }
    
    public List<Pedido> getPedido() { return pedido; }
    public void setPedido(List<Pedido> pedido) { this.pedido = pedido; }
}
