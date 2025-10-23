package com.restaurante.dao;
import com.restaurante.model.Proveedores;
import java.sql.*;
import java.util.*;

public class ProveedoresDAO {
    private Connection conn;

    public ProveedoresDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Proveedores> listAll() {
        List<Proveedores> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                proveedores.add(new Proveedores(
                    rs.getInt("id_proveedor"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return proveedores;
    }

    public boolean add(Proveedores p) {
        String sql = "INSERT INTO proveedores (nombre, telefono, direccion) VALUES (?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getTelefono());
            stmt.setString(3, p.getDireccion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(Proveedores p) {
        String sql = "UPDATE proveedores SET nombre=?, telefono=?, direccion=? WHERE id_proveedor=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getTelefono());
            stmt.setString(3, p.getDireccion());
            stmt.setInt(4, p.getIdProveedor());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM proveedores WHERE id_proveedor=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Proveedores findById(int id) {
        String sql = "SELECT * FROM proveedores WHERE id_proveedor=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Proveedores(
                    rs.getInt("id_proveedor"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}
