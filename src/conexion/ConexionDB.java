package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase encargada de realizar la conexión con la base de datos MySQL.
 */
public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/app_comidas";
    private static final String USER = "root";
    private static final String PASSWORD = "Isa27091x.";

    public static Connection conectar() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }

        return con;
    }
}