package com.restaurante.dao;
import com.restaurante.model.Mesas;
import java.sql.*;
import java.util.*;

public class MesasDAO {
    private Connection conn;

    public MesasDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Mesas> listAll() {
        List<Mesas> mesas = new ArrayList<>();
        String sql = "SELECT * FROM mesas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                mesas.add(new Mesas(
                    rs.getInt("id_mesa"),
                    rs.getInt("numero_mesa"),
                    rs.getInt("capacidad"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return mesas;
    }

    public boolean add(Mesas m) {
        String sql = "INSERT INTO mesas (numero_mesa, capacidad, estado) VALUES (?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, m.getNumeroMesa());
            stmt.setInt(2, m.getCapacidad());
            stmt.setString(3, m.getEstado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(Mesas m) {
        String sql = "UPDATE mesas SET numero_mesa=?, capacidad=?, estado=? WHERE id_mesa=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, m.getNumeroMesa());
            stmt.setInt(2, m.getCapacidad());
            stmt.setString(3, m.getEstado());
            stmt.setInt(4, m.getIdMesa());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM mesas WHERE id_mesa=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Mesas findById(int id) {
        String sql = "SELECT * FROM mesas WHERE id_mesa=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Mesas(
                    rs.getInt("id_mesa"),
                    rs.getInt("numero_mesa"),
                    rs.getInt("capacidad"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}
