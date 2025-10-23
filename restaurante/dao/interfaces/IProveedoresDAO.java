package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Proveedores;

public interface IProveedoresDAO {
    boolean add(Proveedores proveedor);
    boolean update(Proveedores proveedor);
    boolean delete(int idProveedor);
    List<Proveedores> listAll();
    Proveedores findById(int idProveedor);
}
