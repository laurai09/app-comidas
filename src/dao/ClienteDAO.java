package dao;

import conexion.ConexionDB;
import modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public boolean guardarCliente(Cliente cliente) {

        String sql = "INSERT INTO cliente(nombre, correo, telefono) VALUES (?, ?, ?)";

        try {
            Connection con = ConexionDB.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getTelefono());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
            return false;
        }
    }
}