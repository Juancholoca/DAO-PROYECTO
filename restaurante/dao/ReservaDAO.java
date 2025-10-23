package com.restaurante.dao;
import com.restaurante.model.Reserva;
import java.sql.*;
import java.util.*;

public class ReservaDAO {
    private Connection conn;

    public ReservaDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Reserva> listAll() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                reservas.add(new Reserva(
                    rs.getInt("id_reserva"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_mesa"),
                    rs.getDate("fecha"),
                    rs.getTime("hora"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return reservas;
    }

    public boolean add(Reserva r) {
        String sql = "INSERT INTO reservas (id_cliente, id_mesa, fecha, hora, estado) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, r.getIdCliente());
            stmt.setInt(2, r.getIdMesa());
            stmt.setDate(3, r.getFecha());
            stmt.setTime(4, r.getHora());
            stmt.setString(5, r.getEstado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(Reserva r) {
        String sql = "UPDATE reservas SET id_cliente=?, id_mesa=?, fecha=?, hora=?, estado=? WHERE id_reserva=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, r.getIdCliente());
            stmt.setInt(2, r.getIdMesa());
            stmt.setDate(3, r.getFecha());
            stmt.setTime(4, r.getHora());
            stmt.setString(5, r.getEstado());
            stmt.setInt(6, r.getIdReserva());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM reservas WHERE id_reserva=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Reserva findById(int id) {
        String sql = "SELECT * FROM reservas WHERE id_reserva=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Reserva(
                    rs.getInt("id_reserva"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_mesa"),
                    rs.getDate("fecha"),
                    rs.getTime("hora"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}
