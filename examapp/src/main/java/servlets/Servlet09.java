package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet9
 */
@WebServlet("/Servlet9")
public class Servlet09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet09() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// la primera vez no va a encontrar la cocky y se crea. Despues ya existira y lo encontrara
		boolean bandera = false;
		int n = 0;
		
		response.setContentType("text/plain");
		// Recuperamos el vector de cookis
		Cookie[] cs = request.getCookies();
		
		// Forma normal para recojer la cooky
		if (cs != null) {
			for (int i = 0; i<cs.length && !bandera; i++) {
				// Busco la cooki "cont" en el vector
				if (cs[i].getName().equals("cont")) {
					n=Integer.parseInt(cs[i].getValue())+1;
					bandera = true;
				}
			}
		}
		// Creamos la cookie
		Cookie c = new Cookie("cont", String.valueOf(n));
		c.setMaxAge(60*60*365);// caduca al cabo del año
		// Se envia la coky como respuesta al navegador
		response.addCookie(c);
		response.getWriter().append("Numero de visitas: " + n);
		response.getWriter().close();
		
	}

}
