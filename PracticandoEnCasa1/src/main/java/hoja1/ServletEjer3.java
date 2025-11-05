package hoja1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

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
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		/*
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String direccion = request.getParameter("direccion");
		String tarjeta = request.getParameter("tarjeta");
		String numero = request.getParameter("numero");
		
		
		response.getWriter().append("<table>"
				+ "<tr>"
				+ "		<td>Nombre</td>"
				+ "		<td>Apellidos</td>"
				+ "		<td>Direccion</td>"
				+ "		<td>Tarjeta</td>"
				+ "		<td>Numero</td>"
				+ "</tr>"
				+ "<tr>"
				+ "		<td>"+nombre+"</td>"
				+ "		<td>"+apellidos+"</td>"
				+ "		<td>"+direccion+"</td>"
				+ "		<td>"+tarjeta+"</td>"
				+ "		<td>"+numero+"</td>"
				+ "</tr>");
		*/
		
		Enumeration<String> numParam = request.getParameterNames();
		response.getWriter().append("<html><body><h2>MOSTRAR DATOS</h2><table border='1'>")
							.append("<tr>");
		while (numParam.hasMoreElements()) {
			String nombre = (String) numParam.nextElement();
			String value = request.getParameter(nombre);
			response.getWriter().append("<td>")
								.append(value)
								.append("</td>");
								
		}
		response.getWriter().append("</tr>")
							.append("</table></body></html>");
		response.getWriter().close();
	}

}
