package com.restaurante.dao;

import com.restaurante.model.Bebida;
import java.sql.*;
import java.util.*;

public class BebidaDAO {
    private Connection conn;

    public BebidaDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Bebida> listAll() {
        List<Bebida> bebidas = new ArrayList<>();
        String sql = "SELECT * FROM bebidas";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Bebida b = new Bebida(
                    rs.getInt("id_bebida"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getString("tamaño")
                );
                bebidas.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bebidas;
    }

    public boolean add(Bebida b) {
        String sql = "INSERT INTO bebidas (nombre, descripcion, precio, tamaño) VALUES (?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, b.getNombre());
            stmt.setString(2, b.getDescripcion());
            stmt.setDouble(3, b.getPrecio()); 
            stmt.setString(4, b.getTamaño());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Bebida b) {
        String sql = "UPDATE bebidas SET nombre=?, descripcion=?, precio=?, tamaño=? WHERE id_bebida=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, b.getNombre());
            stmt.setString(2, b.getDescripcion());
            stmt.setDouble(3, b.getPrecio()); 
            stmt.setString(4, b.getTamaño());
            stmt.setInt(5, b.getIdBebida());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM bebidas WHERE id_bebida=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Bebida findById(int id) {
        String sql = "SELECT * FROM bebidas WHERE id_bebida=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Bebida(
                    rs.getInt("id_bebida"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getString("tamaño")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}