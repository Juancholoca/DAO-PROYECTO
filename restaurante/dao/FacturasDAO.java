package com.restaurante.dao;

import com.restaurante.model.Facturas;
import java.sql.*;
import java.util.*;

public class FacturasDAO {
    private Connection conn;

    public FacturasDAO() {
        this.conn = DBCConnection.getConnection();
    }

    public List<Facturas> listAll() {
        List<Facturas> facturas = new ArrayList<>();
        String sql = "SELECT * FROM facturas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                facturas.add(new Facturas(
                    rs.getInt("id_factura"),
                    rs.getInt("id_pedido"),
                    rs.getDouble("monto_total"),
                    rs.getString("metodo_pago"),
                    rs.getTimestamp("fecha")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facturas;
    }

    public boolean add(Facturas f) {
        String sql = "INSERT INTO facturas (id_pedido, monto_total, metodo_pago, fecha) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, f.getIdPedido());
            stmt.setDouble(2, f.getMontoTotal());
            stmt.setString(3, f.getMetodoPago());
            stmt.setTimestamp(4, f.getFecha());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Facturas f) {
        String sql = "UPDATE facturas SET id_pedido=?, monto_total=?, metodo_pago=?, fecha=? WHERE id_factura=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, f.getIdPedido());
            stmt.setDouble(2, f.getMontoTotal());
            stmt.setString(3, f.getMetodoPago());
            stmt.setTimestamp(4, f.getFecha());
            stmt.setInt(5, f.getIdFactura());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM facturas WHERE id_factura=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Facturas findById(int id) {
        String sql = "SELECT * FROM facturas WHERE id_factura=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Facturas(
                    rs.getInt("id_factura"),
                    rs.getInt("id_pedido"),
                    rs.getDouble("monto_total"),
                    rs.getString("metodo_pago"),
                    rs.getTimestamp("fecha")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}