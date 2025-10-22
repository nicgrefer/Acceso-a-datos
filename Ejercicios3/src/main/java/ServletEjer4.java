

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class ServletEjer4
 */
@WebServlet("/ServletEjer4")
public class ServletEjer4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int accesos = 0;
		String accion = request.getParameter("boton");;
		
		response.setContentType("text/html");
				
		
		HttpSession sesion  = request.getSession(true); 
		if (sesion.getAttribute("cont")== null) { // si no existe se crea
			response.getWriter().append("Es la primera vez que accede a la web\n");
			
		}else {// Si si que esiste Recojo el valor del contador de la sesion
			
			if (accion.equals("entro")) {
				accesos = (int) sesion.getAttribute("cont"); // casteo a lo que necesito
				response.getWriter().append("Desde la ultima vez has accedido " + accesos + " veces");
			}
			else {
				accesos = 0;
				response.getWriter().append("Es la primera vez que accede a la web\n");
			}
			
		}
		
		sesion.setAttribute("cont", accesos+1);
		
		
		
		
		response.getWriter().append("<form method= 'get'>"
			+ "			<br>"
			+ "        <button type='submit' value='entro' name='boton'>Acceso</button>"
			+ "        <button type='submit' value='nuevaSesion' name='boton'>Nueva sesión</button>"
			+ "    </form>");
			
		
	}

}
