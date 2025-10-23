package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Detalle_Pedido;

public interface IDetalle_PedidoDAO {
    boolean add(Detalle_Pedido detalle);
    boolean update(Detalle_Pedido detalle);
    boolean delete(int idDetalle);
    List<Detalle_Pedido> listAll();
    Detalle_Pedido findById(int idDetalle);
}
