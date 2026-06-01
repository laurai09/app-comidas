package servlet;

import dao.ClienteDAO;
import modelo.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);

        ClienteDAO dao = new ClienteDAO();
        dao.guardarCliente(cliente);

        response.sendRedirect("exito.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().println("Servlet funcionando");
    }
}