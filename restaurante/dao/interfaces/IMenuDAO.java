package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Menu;

public interface IMenuDAO {
    boolean add(Menu menu);
    boolean delete(Long idMenu);
    boolean update(Menu menu);
    List<Menu> listAll();
    Menu findById(Long idMenu);
}