package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de procesar el inicio de sesión de los usuarios.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
     * Recibe los datos del formulario y valida el usuario.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener datos del formulario
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        // Validar usuario en BD
        UsuarioDAO dao = new UsuarioDAO();
        boolean valido = dao.login(usuario, password);

        // Redirección según resultado
        if (valido) {
            response.sendRedirect("bienvenido.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}