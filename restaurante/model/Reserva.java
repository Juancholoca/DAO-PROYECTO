package com.restaurante.model;

import java.sql.Date;
import java.sql.Time;


public class Reserva {
    private int idReserva;
    private int idCliente;
    private int idMesa;
    private Date fecha;
    private Time hora;
    private String estado;

    private Cliente cliente;
    private Mesas mesas;
    
    public Reserva() {}

    public Reserva(int idReserva, int idCliente, int idMesa, Date fecha, Time hora, String estado) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idMesa = idMesa;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdMesa() { return idMesa; }
    public void setIdMesa(int idMesa) { this.idMesa = idMesa; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Time getHora() { return hora; }
    public void setHora(Time hora) { this.hora = hora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    
    public Mesas getMesas() { return mesas; }
    public void setMesas(Mesas mesas) { this.mesas = mesas; }
}

