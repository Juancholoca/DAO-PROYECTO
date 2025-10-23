package com.restaurante.dao;

import com.restaurante.model.Menu;
import java.sql.*;
import java.util.*;

public class MenuDAO {

    private Connection conn;

    public MenuDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Menu> listAll() {
        List<Menu> menus = new ArrayList<>();
        String sql = "SELECT * FROM menu";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Menu menu = new Menu();
                menu.setIdMenu(rs.getLong("id_menu"));
                menu.setNombrePlato(rs.getString("nombre_plato"));
                menu.setDescripcion(rs.getString("descripcion"));
                menu.setPrecio(rs.getDouble("precio"));
                menus.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menus;
    }

    public boolean add(Menu m) {
        String sql = "INSERT INTO menu (nombre_plato, descripcion, precio) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getNombrePlato());
            stmt.setString(2, m.getDescripcion());
            stmt.setDouble(3, m.getPrecio());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Menu m) {
        String sql = "UPDATE menu SET nombre_plato = ?, descripcion = ?, precio = ? WHERE id_menu = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getNombrePlato());
            stmt.setString(2, m.getDescripcion());
            stmt.setDouble(3, m.getPrecio());
            stmt.setLong(4, m.getIdMenu());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(long id) {
        String sql = "DELETE FROM menu WHERE id_menu = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Menu findById(long id) {
        String sql = "SELECT * FROM menu WHERE id_menu = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Menu(
                        rs.getLong("id_menu"),
                        rs.getString("nombre_plato"),
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