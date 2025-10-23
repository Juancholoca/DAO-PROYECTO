package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Comida;

public interface IComidasDAO {
    boolean add(Comida comida);
    boolean update(Comida comida);
    boolean delete(int idComida);
    List<Comida> listAll();
    Comida findById(int idComida);
}
