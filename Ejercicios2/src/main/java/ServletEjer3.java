

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//Inicializamos el contador
		getServletContext().setAttribute("contadorVisitas", 0);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
		
		// Obtener el contador del contexto de la aplicación
        Integer contador = (Integer) getServletContext().getAttribute("contadorVisitas");
        // Aumento
        contador++;
        // Guardo
        getServletContext().setAttribute("contadorVisitas", contador);
        
        response.setContentType("text/html");
        response.getWriter().append("<h1> Contador = " + contador + " usuarios" );
        response.getWriter().close();
		
	}

}
