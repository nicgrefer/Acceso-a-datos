package hoja2;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Servlet2Ejer2
 */
@WebServlet("/Servlet2Ejer2")
public class Servlet2Ejer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2Ejer2() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("user");
		String edad = request.getParameter("edad");
		String telefono = request.getParameter("telf");
		
		ArrayList<Persona> listaUsuers = (ArrayList<Persona>) request.getSession().getAttribute("listpers");
		
		if (listaUsuers == null) {
			listaUsuers = new ArrayList<Persona>();
		}
		
		if (nombre != null && edad != null && telefono != null) {
			int edadNum = Integer.parseInt(edad);
			Persona p1 = new Persona(nombre, edadNum, telefono);
			listaUsuers.add(p1);
			
			request.getSession().setAttribute("listpers", listaUsuers);
			
		}
		
		response.setContentType("text/html");
		response.getWriter().append("<!DOCTYPE html>")
							.append("<head><meta charset='UTF-8'><title>Lista de Personas</title></head>")
							.append("<body> <h1>Personas Registradas</h1> <table border='1' cellpadding='5' cellspacing='0'>")
							.append("<tr><th>Nombre</th><th>Edad</th><th>Teléfono</th></tr>");
		
		for (Persona p: listaUsuers) {
			response.getWriter().append("<tr>")
	        					.append("<td>")
	        					.append(p.getNombre()).append("</td>")
	        					.append("<td>")
	        					.append(String.valueOf(p.getEdad())).append("</td>")
	        					.append("<td>")
	        					.append(p.getTelefono())
	        					.append("</td>")
	        					.append("</tr>");
		}
		
		response.getWriter().append("</table>")
							.append("<br>")
							.append("<form action='ServletEjer2V2' method='get'>")
					        .append("<button type='submit'>Ir al segundo servlet</button>")
					        .append("</form>")
	    					.append("</body></html>");
		
		response.getWriter().close();
		
	}


}
