package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Bebida;

public interface IBebidasDAO {
    boolean add(Bebida bebida);
    boolean update(Bebida bebida);
    boolean delete(int idBebida);
    List<Bebida> listAll();
    Bebida findById(int idBebida);
}
