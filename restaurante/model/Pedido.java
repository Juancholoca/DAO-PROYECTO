package com.restaurante.model;

import java.sql.Timestamp;
import java.util.List;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private int idMesa;
    private int idEmpleado;
    private Timestamp fechaHora;
    private String estado;
    
    private Cliente cliente;
    private Mesas mesas;
    private Empleados empleados;
    private Facturas facturas;
    
    private List<Detalle_Pedido> detalle_pedido;
    
    
    
    public Pedido() {}

    public Pedido(int idPedido, int idCliente, int idMesa, int idEmpleado, Timestamp fechaHora, String estado) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idMesa = idMesa;
        this.idEmpleado = idEmpleado;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdMesa() { return idMesa; }
    public void setIdMesa(int idMesa) { this.idMesa = idMesa; }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public Timestamp getFechaHora() { return fechaHora; }
    public void setFechaHora(Timestamp fechaHora) { this.fechaHora = fechaHora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
  
    public Mesas getMesas() { return mesas; }
    public void setMesas(Mesas mesas) { this.mesas = mesas; }

    public Empleados getEmpleados() { return empleados; }
    public void setEmpleados(Empleados empleados) { this.empleados = empleados; }
    
    public Facturas getFacturas() { return facturas; }
    public void setFacturas(Facturas facturas) { this.facturas = facturas; }

    public List<Detalle_Pedido> getDetalle_Pedido() { return detalle_pedido; }
    public void setDetalle_Pedido(List<Detalle_Pedido> detalle_pedido) { this.detalle_pedido = detalle_pedido; }

}