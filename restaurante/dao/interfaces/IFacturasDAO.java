package com.restaurante.dao.interfaces;
import java.util.List;
import com.restaurante.model.Facturas;

public interface IFacturasDAO {
    boolean add(Facturas factura);
    boolean update(Facturas factura);
    boolean delete(int idFactura);
    List<Facturas> listAll();
    Facturas findById(int idFactura);
}
