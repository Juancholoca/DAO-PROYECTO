package com.restaurante.dao;

import com.restaurante.model.Detalle_Pedido;
import java.sql.*;
import java.util.*;

public class Detalle_PedidoDAO {
    private Connection conn;

    public Detalle_PedidoDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Detalle_Pedido> listAll() {
        List<Detalle_Pedido> detalles = new ArrayList<>();
        String sql = "SELECT * FROM detalle_pedido";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Detalle_Pedido d = new Detalle_Pedido(
                    rs.getInt("id_detalle"),
                    rs.getInt("id_pedido"),
                    (Integer) rs.getObject("id_comida"),
                    (Integer) rs.getObject("id_postre"),
                    (Integer) rs.getObject("id_bebida"),
                    rs.getInt("cantidad"),
                    rs.getDouble("subtotal")
                );
                detalles.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;
    }

    public boolean add(Detalle_Pedido d) {
        String sql = "INSERT INTO detalle_pedido (id_pedido, id_comida, id_postre, id_bebida, cantidad, subtotal) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, d.getIdPedido());
            stmt.setObject(2, d.getIdComida(), Types.INTEGER);
            stmt.setObject(3, d.getIdPostre(), Types.INTEGER);
            stmt.setObject(4, d.getIdBebida(), Types.INTEGER);
            stmt.setInt(5, d.getCantidad());
            stmt.setDouble(6, d.getSubtotal());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Detalle_Pedido d) {
        String sql = "UPDATE detalle_pedido SET id_pedido=?, id_comida=?, id_postre=?, id_bebida=?, cantidad=?, subtotal=? WHERE id_detalle=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, d.getIdPedido());
            stmt.setObject(2, d.getIdComida(), Types.INTEGER);
            stmt.setObject(3, d.getIdPostre(), Types.INTEGER);
            stmt.setObject(4, d.getIdBebida(), Types.INTEGER);
            stmt.setInt(5, d.getCantidad());
            stmt.setDouble(6, d.getSubtotal());
            stmt.setInt(7, d.getIdDetalle());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM detalle_pedido WHERE id_detalle=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Detalle_Pedido findById(int id) {
        String sql = "SELECT * FROM detalle_pedido WHERE id_detalle=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Detalle_Pedido(
                    rs.getInt("id_detalle"),
                    rs.getInt("id_pedido"),
                    (Integer) rs.getObject("id_comida"),
                    (Integer) rs.getObject("id_postre"),
                    (Integer) rs.getObject("id_bebida"),
                    rs.getInt("cantidad"),
                    rs.getDouble("subtotal")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
