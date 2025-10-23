package com.restaurante.dao;
import com.restaurante.model.Pedido;
import java.sql.*;
import java.util.*;

public class PedidoDAO {
    private Connection conn;

    public PedidoDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Pedido> listAll() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pedidos.add(new Pedido(
                    rs.getInt("id_pedido"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_mesa"),
                    rs.getInt("id_empleado"),
                    rs.getTimestamp("fecha_hora"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return pedidos;
    }

    public boolean add(Pedido p) {
        String sql = "INSERT INTO pedidos (id_cliente, id_mesa, id_empleado, fecha_hora, estado) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, p.getIdCliente());
            stmt.setInt(2, p.getIdMesa());
            stmt.setInt(3, p.getIdEmpleado());
            stmt.setTimestamp(4, p.getFechaHora());
            stmt.setString(5, p.getEstado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(Pedido p) {
        String sql = "UPDATE pedidos SET id_cliente=?, id_mesa=?, id_empleado=?, fecha_hora=?, estado=? WHERE id_pedido=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, p.getIdCliente());
            stmt.setInt(2, p.getIdMesa());
            stmt.setInt(3, p.getIdEmpleado());
            stmt.setTimestamp(4, p.getFechaHora());
            stmt.setString(5, p.getEstado());
            stmt.setInt(6, p.getIdPedido());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM pedidos WHERE id_pedido=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Pedido findById(int id) {
        String sql = "SELECT * FROM pedidos WHERE id_pedido=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pedido(
                    rs.getInt("id_pedido"),
                    rs.getInt("id_cliente"),
                    rs.getInt("id_mesa"),
                    rs.getInt("id_empleado"),
                    rs.getTimestamp("fecha_hora"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
}
