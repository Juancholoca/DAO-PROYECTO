package com.restaurante.dao;

import com.restaurante.model.Postre;
import java.sql.*;
import java.util.*;

public class PostreDAO {
    private Connection conn;

    public PostreDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Postre> listAll() {
        List<Postre> postres = new ArrayList<>();
        String sql = "SELECT * FROM postres";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Postre p = new Postre(
                    rs.getInt("id_postre"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio")
                );
                postres.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postres;
    }

    public boolean add(Postre p) {
        String sql = "INSERT INTO postres (nombre, descripcion, precio) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getDescripcion());
            stmt.setDouble(3, p.getPrecio());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Postre p) {
        String sql = "UPDATE postres SET nombre=?, descripcion=?, precio=? WHERE id_postre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getDescripcion());
            stmt.setDouble(3, p.getPrecio());
            stmt.setInt(4, p.getIdPostre());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM postres WHERE id_postre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Postre findById(int id) {
        String sql = "SELECT * FROM postres WHERE id_postre=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Postre(
                    rs.getInt("id_postre"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio") 
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}