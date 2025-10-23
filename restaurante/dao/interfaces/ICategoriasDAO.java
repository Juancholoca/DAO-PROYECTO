package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Categorias;

public interface ICategoriasDAO {
    boolean add(Categorias categoria);
    boolean delete(Integer idCategoria);
    boolean update(Categorias categoria);
    
    List<Categorias> listAll();
    Categorias findById(Integer idCategoria);
}
