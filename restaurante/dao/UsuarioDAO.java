package com.restaurante.dao;
import com.restaurante.model.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Usuario> listAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getInt("id_empleado"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("rol"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return usuarios;
    }

    public boolean add(Usuario u) {
        String sql = "INSERT INTO usuarios (id_empleado, username, password, rol, estado) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, u.getIdEmpleado());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getRol());
            stmt.setString(5, u.getEstado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(Usuario u) {
        String sql = "UPDATE usuarios SET id_empleado=?, username=?, password=?, rol=?, estado=? WHERE id_usuario=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, u.getIdEmpleado());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getRol());
            stmt.setString(5, u.getEstado());
            stmt.setInt(6, u.getIdUsuario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM usuarios WHERE id_usuario=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Usuario findById(int id) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getInt("id_empleado"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("rol"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}

