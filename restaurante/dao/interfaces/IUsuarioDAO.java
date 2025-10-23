package com.restaurante.dao.interfaces;

import java.util.List;

import com.restaurante.model.Usuario;

public interface IUsuarioDAO {
    boolean add(Usuario usuario);
    boolean update(Usuario usuario);
    boolean delete(int idUsuario);
    List<Usuario> listAll();
    Usuario findById(int idUsuario);
}