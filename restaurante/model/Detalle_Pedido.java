package com.restaurante.model;

public class Detalle_Pedido {

    private int idDetalle;
    private int idPedido;
    private Integer idComida;
    private Integer idPostre;
    private Integer idBebida;
    private int cantidad;
    private double subtotal;

    private Pedido pedido;
    private Comida comida;
    private Postre postre;
    private Bebida bebida;

    public Detalle_Pedido() {}

    public Detalle_Pedido(int idDetalle, int idPedido, Integer idComida, Integer idPostre, Integer idBebida, int cantidad, double subtotal) {
        this.idDetalle = idDetalle;
        this.idPedido = idPedido;
        this.idComida = idComida;
        this.idPostre = idPostre;
        this.idBebida = idBebida;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdDetalle() { return idDetalle; }
    public void setIdDetalle(int idDetalle) { this.idDetalle = idDetalle; }

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }

    public Integer getIdComida() { return idComida; }
    public void setIdComida(Integer idComida) { this.idComida = idComida; }

    public Integer getIdPostre() { return idPostre; }
    public void setIdPostre(Integer idPostre) { this.idPostre = idPostre; }

    public Integer getIdBebida() { return idBebida; }
    public void setIdBebida(Integer idBebida) { this.idBebida = idBebida; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    public Comida getComida() { return comida; }
    public void setComida(Comida comida) { this.comida = comida; }

    public Postre getPostre() { return postre; }
    public void setPostre(Postre postre) { this.postre = postre; }

    public Bebida getBebida() { return bebida; }
    public void setBebida(Bebida bebida) { this.bebida = bebida; }
}