package com.restaurante.model;

import java.sql.Timestamp;

public class Facturas {
    private int idFactura;
    private int idPedido;
    private double montoTotal;
    private String metodoPago;
    private Timestamp fecha;

    private Pedido pedido;
    
    public Facturas() {}

    public Facturas(int idFactura, int idPedido, double montoTotal, String metodoPago, Timestamp fecha) {
        this.idFactura = idFactura;
        this.idPedido = idPedido;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
    }

    public int getIdFactura() { return idFactura; }
    public void setIdFactura(int idFactura) { this.idFactura = idFactura; }

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public Timestamp getFecha() { return fecha; }
    public void setFecha(Timestamp fecha) { this.fecha = fecha; }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

}
