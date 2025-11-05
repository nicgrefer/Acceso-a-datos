package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servle2
 */
@WebServlet("/Servle2")
public class Servlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Indico el tipo de respuesta euq envio al navgador
		response.setContentType("text/html");
		//Creo el flujo de saslida de datos
		response.getWriter().append("<html>")
							.append("<body>")
							.append("<h1>Ejemplo2</h1>")
							.append("<br> hola mundo")
							.append("</body>")
							.append("</html>");
		//Cerramos el flujo
		response.getWriter().close();
		
	}

}
