package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Reserva;

public interface IReservaDAO {
    boolean add(Reserva reserva);
    boolean update(Reserva reserva);
    boolean delete(int idReserva);
    List<Reserva> listAll();
    Reserva findById(int idReserva);
}
