package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Cliente;

public interface IClienteDAO {
    boolean add(Cliente cliente);
    boolean update(Cliente cliente);
    boolean delete(int idCliente);
    List<Cliente> listAll();
    Cliente findById(int idCliente);
}
