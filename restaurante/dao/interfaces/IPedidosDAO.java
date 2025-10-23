package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Pedido;

public interface IPedidosDAO {
    boolean add(Pedido pedido);
    boolean update(Pedido pedido);
    boolean delete(int idPedido);
    List<Pedido> listAll();
    Pedido findById(int idPedido);
}
