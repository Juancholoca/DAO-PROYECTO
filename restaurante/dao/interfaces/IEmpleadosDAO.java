package com.restaurante.dao.interfaces;

import java.util.List;
import com.restaurante.model.Empleados;

public interface IEmpleadosDAO {
    boolean add(Empleados empleado);
    boolean update(Empleados empleado);
    boolean delete(int idEmpleado);
    List<Empleados> listAll();
    Empleados findById(int idEmpleado);
}
