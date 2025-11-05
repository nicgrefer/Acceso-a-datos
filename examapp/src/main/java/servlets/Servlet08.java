package servlets;


import java.io.IOException;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet8
 */
@WebServlet("/Servlet8")
public class Servlet08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet08() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Manejo de sesiones y kuquis
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int c = 0; // Contador
		
		// Creamos la sesion
		
		HttpSession sesion  = request.getSession(true); // recupera sesion. Ya existe??
		if (sesion.getAttribute("cont")== null) { // si no existe se crea
			response.getWriter().append("Hola DAM \n");
		}else {// Si si que esiste Recojo el valor del contador de la sesion
			response.getWriter().append("Hola de nuevo DAM \n");
			c = (int) sesion.getAttribute("cont"); // casteo a lo que necesito
		}
		// Incrementar el contador guardandolo en la sesion
		sesion.setAttribute("cont", c+1);
		
		response.getWriter().append("Recargas " + c+ "\n");
		response.getWriter().append("La sesion fue creada " + new Date (sesion.getCreationTime()));
		response.getWriter().append("El identificador de la sesion: " + sesion.getId());
		response.getWriter().append("Se accesio por ultima vaz a " + new Date(sesion.getLastAccessedTime()));
		response.getWriter().append("Ultima sesion permanece inactiva: " + sesion.getMaxInactiveInterval());
		response.getWriter().close();
		
	}

}
