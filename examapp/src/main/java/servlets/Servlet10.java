package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet10
 */
@WebServlet("/Servlet10")
public class Servlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("<html><body>");
		response.getWriter().append("<form action = 'Servlet10' method = 'post'>"
				+ "<input type = 'submit' name = 'metodo' value = 'include'>"
				+ " <input type = 'submit' name = 'metodo' value = 'forward'>"
				+ "</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("<html><body style = 'background-color: #AAFF9F' >"
				+ "<h1>Ejemplo de requestDispachet</h1> "
				+ "<p>Este serblet usa un despacher que nos lleva a otro servlet </p>");
		// Se puede tomar el dispachador del contexto o de la raquest
		// Contexto; sirve para rutas externas a la appa web pero solo permite rutas absolutas
		// REquest; sirve para rutas del contexto de la app web y permite trabajar con rutas relatibas
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Servlet10Vis");
		if (dispatcher != null) {
			if (request.getParameter("metodo") != null) {
				if (request.getParameter("metodo").equalsIgnoreCase("include")) {
					dispatcher.include(request, response);
				}else {
					dispatcher.forward(request, response);
				}
				
			}
		}
		
		
	}

}
