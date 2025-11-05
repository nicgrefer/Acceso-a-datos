package hoja2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Servlet2Ejer2_02Bis
 */
@WebServlet("/Servlet2Ejer2_02Bis")
public class Servlet2Ejer2_02Bis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2Ejer2_02Bis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Persona> listPerson = (ArrayList<Persona>) request.getSession().getAttribute("listPerson");
		
		response.setContentType("text/html");
		response.getWriter().append("<h1>Estás en el servlet " + getServletName() + "</h1>");
		response.getWriter().append("<table>"
				+ "<tr>"
				+ "		<td>Nombre</td>"
				+ "		<td>Edad</td>"
				+ "		<td>Telefono</td>"
				+ "</tr>");
		for (Persona p : listPerson) {
			response.getWriter().append(
					"<tr>"
					+ "		<td>"+p.nombre+"</td>"
					+ "		<td>"+p.edad+"</td>"
					+ "		<td>"+p.telefono+"</td>"
					+ "</tr>");
		}
		response.getWriter().append("</table>");
		response.getWriter().close();
	}

}
