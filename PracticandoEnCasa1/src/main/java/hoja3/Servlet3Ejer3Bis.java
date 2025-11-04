package hoja3;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Servlet implementation class Servlet3Ejer3Bis
 */
@WebServlet("/Servlet3Ejer3Bis")
public class Servlet3Ejer3Bis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map <String, String> lib;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3Ejer3Bis() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	lib = (Map<String, String>) config.getServletContext().getAttribute("libros");
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie [] cookies = request.getCookies();
		
		response.setContentType("text/html");
		
		response.getWriter().append("<tr>"
				+ "<td>Titulo del libro</td>"
				+ "<td>Unidades</td>"
				+ "<td>Precio</td>"
				+ "</tr>");
		
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("java") || c.getName().equals("c") ||
						c.getName().equals("cpp") || c.getName().equals("vr") ||
						c.getName().equals("phyton")) {
					response.getWriter().append("<tr>"
							+ "<td>"+c.getName()+"</td>"
							+ "<td>"+c.getValue()+"</td>"
							+ "<td></td>"
							+ "</tr>");
				}
				
			}
		}
		
 	}

}
