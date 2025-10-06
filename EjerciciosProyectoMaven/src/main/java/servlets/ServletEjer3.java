package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletEjer3
 */
@WebServlet("/ServletEjer3")
public class ServletEjer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recogemos datos del formulario
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String tipTarjeta = request.getParameter("tipTarjeta");
        String nTarjeta = request.getParameter("nTarjeta");

        // Configuramos el tipo de respuesta
        response.setContentType("text/html;charset=UTF-8");

        // Mostramos los datos en una tabla HTML simple
        response.getWriter().append("<!DOCTYPE html>")
            .append("<html>")
            .append("<head><title>Datos del formulario</title></head>")
            .append("<body>")
            .append("<h2>Datos recibidos</h2>")
            .append("<table border='1'>")
            .append("<tr><th>Campo</th><th>Valor</th></tr>")
            .append("<tr><td>Nombre</td><td>").append(nombre != null ? nombre : "").append("</td></tr>")
            .append("<tr><td>Apellidos</td><td>").append(apellidos != null ? apellidos : "").append("</td></tr>")
            .append("<tr><td>Dirección</td><td>").append(direccion != null ? direccion : "").append("</td></tr>")
            .append("<tr><td>Tipo de tarjeta</td><td>").append(tipTarjeta != null ? tipTarjeta : "").append("</td></tr>")
            .append("<tr><td>Número de tarjeta</td><td>").append(nTarjeta != null ? nTarjeta : "").append("</td></tr>")
            .append("</table>")
            .append("</body>")
            .append("</html>");
    }


}
