package com.restaurante.model;

import java.util.List;

public class Mesas {
    private int idMesa;
    private int numeroMesa;
    private int capacidad;
    private String estado;

    private List<Reserva> reserva;
    private List<Pedido> pedido;
    
    public Mesas() {}

    public Mesas(int idMesa, int numeroMesa, int capacidad, String estado) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getIdMesa() { return idMesa; }
    public void setIdMesa(int idMesa) { this.idMesa = idMesa; }

    public int getNumeroMesa() { return numeroMesa; }
    public void setNumeroMesa(int numeroMesa) { this.numeroMesa = numeroMesa; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public List<Reserva> getReserva() { return reserva; }
    public void setReserva(List<Reserva> reserva) { this.reserva = reserva; }
    
    public List<Pedido> getPedido() { return pedido; }
    public void setPedido(List<Pedido> pedido) { this.pedido = pedido; }
}
