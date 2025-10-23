package com.restaurante.dao;
import com.restaurante.model.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Cliente> listAll() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clientes.add(new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("direccion")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return clientes;
    }

    public boolean add(Cliente c) {
        String sql = "INSERT INTO clientes (nombre, apellido, telefono, email, direccion) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellido());
            stmt.setString(3, c.getTelefono());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getDireccion());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(Cliente c) {
        String sql = "UPDATE clientes SET nombre=?, apellido=?, telefono=?, email=?, direccion=? WHERE id_cliente=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellido());
            stmt.setString(3, c.getTelefono());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getDireccion());
            stmt.setInt(6, c.getIdCliente());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM clientes WHERE id_cliente=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Cliente findById(int id) {
        String sql = "SELECT * FROM clientes WHERE id_cliente=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("direccion")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}
