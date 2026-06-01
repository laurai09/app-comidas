package dao;

import conexion.ConexionDB;
import java.sql.*;
/**
 * Clase encargada de realizar operaciones sobre la tabla usuario.
 */
public class UsuarioDAO {
/**
 * Valida las credenciales del usuario en la base de datos.
 * @param usuario Nombre de usuario.
 * @param password Contraseña del usuario.
 * @return true si el usuario existe.
 */
    public boolean login(String usuario, String password) {

        boolean ok = false;

        try {

            Connection con = ConexionDB.conectar();

            String sql = "SELECT * FROM usuario WHERE nombre_usuario=? AND contraseña=? AND estado_cuenta='activo'";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ok = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }
}