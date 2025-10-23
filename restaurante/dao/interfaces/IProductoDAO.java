package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Producto;

public interface IProductoDAO {
    boolean add(Producto producto);
    boolean update(Producto producto);
    boolean delete(int idProducto);
    List<Producto> listAll();
    Producto findById(int idProducto);
}