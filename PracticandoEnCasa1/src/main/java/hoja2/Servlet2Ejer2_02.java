package hoja2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Servlet2Ejer2_02
 */
@WebServlet("/Servlet2Ejer2_02")
public class Servlet2Ejer2_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2Ejer2_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String edadSt = request.getParameter("edad");
		String numero = request.getParameter("tf");
		
		ArrayList<Persona> listPerson = (ArrayList<Persona>) request.getSession().getAttribute("listPerson");
		
		if (listPerson == null) {
			listPerson = new ArrayList<Persona>();
			request.setAttribute("listPerson", listPerson);
		}
		
		if (numero != null && edadSt != null && numero != null) {
			Persona p = new Persona();
			p.setNombre(nombre);
			p.setEdad(Integer.parseInt(edadSt));
			p.setTelefono(numero);
			
			listPerson.add(p);
			
			//request.setAttribute("listPerson", listPerson);
			request.getSession().setAttribute("listPerson", listPerson);
			
		}
		
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
		
		response.getWriter().append("<form action = 'Servlet2Ejer2_02Bis' method = 'get' > "
				+ "<button type= 'submit' name='ver'>Ver en servlet 2</button>"
				+ "</form>");
		
		response.getWriter().close();
		
	}

}
