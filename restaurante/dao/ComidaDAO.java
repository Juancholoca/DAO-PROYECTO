package com.restaurante.dao;

import com.restaurante.model.Comida;
import java.sql.*;
import java.util.*;

public class ComidaDAO {
    private Connection conn;

    public ComidaDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Comida> listAll() {
        List<Comida> comidas = new ArrayList<>();
        String sql = "SELECT * FROM comidas";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Comida c = new Comida(
                    rs.getInt("id_comida"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getString("tipo")
                );
                comidas.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comidas;
    }

    public boolean add(Comida c) {
        String sql = "INSERT INTO comidas (nombre, descripcion, precio, tipo) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getDescripcion());
            stmt.setDouble(3, c.getPrecio());
            stmt.setString(4, c.getTipo());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Comida c) {
        String sql = "UPDATE comidas SET nombre=?, descripcion=?, precio=?, tipo=? WHERE id_comida=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getDescripcion());
            stmt.setDouble(3, c.getPrecio());
            stmt.setString(4, c.getTipo());
            stmt.setInt(5, c.getIdComida());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM comidas WHERE id_comida=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Comida findById(int id) {
        String sql = "SELECT * FROM comidas WHERE id_comida=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Comida(
                    rs.getInt("id_comida"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getString("tipo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}