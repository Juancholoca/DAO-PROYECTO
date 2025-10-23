package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Mesas;

public interface IMesasDAO {
    boolean add(Mesas mesa);
    boolean update(Mesas mesa);
    boolean delete(int idMesa);
    List<Mesas> listAll();
    Mesas findById(int idMesa);
}

