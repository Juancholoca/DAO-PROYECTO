package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Postre;

public interface IPostresDAO {
    boolean add(Postre postre);
    boolean update(Postre postre);
    boolean delete(int idPostre);
    List<Postre> listAll();
    Postre findById(int idPostre);
}
