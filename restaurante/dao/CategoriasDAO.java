package com.restaurante.dao;
import com.restaurante.model.Categorias;
import java.sql.*;
import java.util.*;

public class CategoriasDAO {
    private Connection conn;

    public CategoriasDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Categorias> listAll() {
        List<Categorias> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categorias.add(new Categorias(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return categorias;
    }

    public boolean add(Categorias c) {
        String sql = "INSERT INTO categorias (nombre, descripcion) VALUES (?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getDescripcion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(Categorias c) {
        String sql = "UPDATE categorias SET nombre=?, descripcion=? WHERE id_categoria=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getDescripcion());
            stmt.setInt(3, c.getIdCategoria());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM categorias WHERE id_categoria=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Categorias findById(int id) {
        String sql = "SELECT * FROM categorias WHERE id_categoria=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Categorias(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}
