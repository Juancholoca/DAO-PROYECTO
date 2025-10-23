package com.restaurante.dao;

import com.restaurante.model.Empleados;
import java.sql.*;
import java.util.*;

public class EmpleadosDAO {
    private Connection conn;

    public EmpleadosDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Empleados> listAll() {
        List<Empleados> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                empleados.add(new Empleados(
                    rs.getInt("id_empleado"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("cargo"),
                    rs.getString("telefono"),
                    rs.getDouble("sueldo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public boolean add(Empleados e) {
        String sql = "INSERT INTO empleados (nombre, apellido, cargo, telefono, sueldo) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getApellido());
            stmt.setString(3, e.getCargo());
            stmt.setString(4, e.getTelefono());
            stmt.setDouble(5, e.getSueldo());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(Empleados e) {
        String sql = "UPDATE empleados SET nombre=?, apellido=?, cargo=?, telefono=?, sueldo=? WHERE id_empleado=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getApellido());
            stmt.setString(3, e.getCargo());
            stmt.setString(4, e.getTelefono());
            stmt.setDouble(5, e.getSueldo());
            stmt.setInt(6, e.getIdEmpleado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM empleados WHERE id_empleado=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Empleados findById(int id) {
        String sql = "SELECT * FROM empleados WHERE id_empleado=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Empleados(
                    rs.getInt("id_empleado"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("cargo"),
                    rs.getString("telefono"),
                    rs.getDouble("sueldo")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
