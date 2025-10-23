package com.restaurante.dao;
import com.restaurante.model.Producto;
import java.sql.*;
import java.util.*;

public class ProductoDAO {
    private Connection conn;

    public ProductoDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Producto> listAll() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                productos.add(new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getInt("cantidad"),
                    rs.getString("descripcion"),
                    rs.getString("unidad_medida"),
                    rs.getInt("id_proveedor"),
                    rs.getDate("fecha_ultima_compra")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return productos;
    }

    public boolean add(Producto p) {
        String sql = "INSERT INTO producto (nombre, cantidad, descripcion, unidad_medida, id_proveedor, fecha_ultima_compra) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getCantidad());
            stmt.setString(3, p.getDescripcion());
            stmt.setString(4, p.getUnidadMedida());
            stmt.setObject(5, p.getIdProveedor(), Types.INTEGER);
            stmt.setDate(6, p.getFechaUltimaCompra());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(Producto p) {
        String sql = "UPDATE producto SET nombre=?, cantidad=?, descripcion=?, unidad_medida=?, id_proveedor=?, fecha_ultima_compra=? WHERE id_producto=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getCantidad());
            stmt.setString(3, p.getDescripcion());
            stmt.setString(4, p.getUnidadMedida());
            stmt.setObject(5, p.getIdProveedor(), Types.INTEGER);
            stmt.setDate(6, p.getFechaUltimaCompra());
            stmt.setInt(7, p.getIdProducto());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM producto WHERE id_producto=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Producto findById(int id) {
        String sql = "SELECT * FROM producto WHERE id_producto=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getInt("cantidad"),
                    rs.getString("descripcion"),
                    rs.getString("unidad_medida"),
                    rs.getInt("id_proveedor"),
                    rs.getDate("fecha_ultima_compra")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}

