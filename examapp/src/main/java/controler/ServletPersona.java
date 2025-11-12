package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mode.pojoPersona;

import java.io.IOException;

/**
 * Servlet implementation class ServletPersona
 */
@WebServlet("/ServletPersona")
public class ServletPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("persona", 
				new pojoPersona(request.getParameter("dni"), request.getParameter("nombre"),
						request.getParameter("apellido"), request.getParameter("direccion"),
						request.getParameter("telefono"), request.getParameter("email")));
		
		String page = request.getParameter("Enviar")!=null? "MostrarPersona.jsp": request.getParameter("Volver")!=null?"RecojidaPersona.jsp":"Ejemplo20Error.jsp";;
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}
