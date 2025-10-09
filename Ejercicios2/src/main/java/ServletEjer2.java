

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ServletEjer2
 */
@WebServlet("/ServletEjer2")
public class ServletEjer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer2() {
        super();
        // TODO Auto-generated constructor stub
    }

     public ArrayList<Persona> listaPersona = new ArrayList<Persona>();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Recoger parámetros del formulario
	    String nombre = request.getParameter("nombre");
	    String edadStr = request.getParameter("edad");
	    String telefono = request.getParameter("telefono");
		
	    if (nombre != null && edadStr != null && telefono != null) {
	        try {
	            int edad = Integer.parseInt(edadStr);
	            Persona p = new Persona(nombre, edad, telefono);
	            listaPersona.add(p);
	        } catch (NumberFormatException e) {
	            // si no es número, lo ignoramos
	        }
	    }

	    
		response.setContentType("text/html");
		response.getWriter().append("<!DOCTYPE html>")
							.append("<head><meta charset='UTF-8'><title>Lista de Personas</title></head>")
							.append("<body> <h1>Personas Registradas</h1> <table border='1' cellpadding='5' cellspacing='0'>")
							.append("<tr><th>Nombre</th><th>Edad</th><th>Teléfono</th></tr>");
		
		for (Persona p: listaPersona) {
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
							
		// -> http://localhost:8081/Ejercicios2/ServletEjer2?nombre=Paco&&edad=29&&telefono=987654
	}

	

}
