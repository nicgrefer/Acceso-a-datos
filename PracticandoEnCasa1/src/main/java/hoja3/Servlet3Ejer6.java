package hoja3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet3Ejer6
 */
@WebServlet("/Servlet3Ejer6")
public class Servlet3Ejer6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3Ejer6() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		String nomGalleta = request.getParameter("galleta");
		String accrion = request.getParameter("groupCookie");
		
		Cookie [] cookies = request.getCookies();
		
		
		switch (accrion) {
		case "muestra": {
			
			if (cookies !=null) {
				response.getWriter().append("<h4>Galletas creadas</h4>");
				for (Cookie c : cookies) {
					if (c.getName().contains("galleta_")) {
						response.getWriter().append("<ul>"+c.getValue()+"</ul>");
					}
					
				}
				break;
			}else {
				response.getWriter().append("<p>No hay galletas disponibles.</p>");
				break;
			}
			
			
		}
		case "cocina":{
			if (nomGalleta.isEmpty()) {
				response.getWriter().append("<p> No has elegido galleta </p>");
				break;
			}else {
				String nomnreGalleta = "galleta_"+nomGalleta;
				Cookie c = new Cookie(nomnreGalleta, nomGalleta);
				c.setMaxAge(6000);
				response.addCookie(c);
				response.getWriter().append("Galleta con nombre " + nomGalleta + " creada correctamente");
				break;
			}
		}
		case "come":{
			boolean encontrada = false;
			if (nomGalleta.isEmpty()) {
				response.getWriter().append("<p> No has elegido galleta </p>");
				break;
			}else {
			
				if (cookies == null ) {
					response.getWriter().append("No existen cookis para buscar");		
				}
				else {
					for (Cookie c : cookies) {
						if (c.getValue().equals(nomGalleta)) {
							c.setMaxAge(0);
							response.addCookie(c);
							response.getWriter().append("<p>La galleta con nombre "+ nomGalleta+" ha sido comida</p>");
							encontrada = true;
						}
					}
					if (!encontrada) {
						response.getWriter().append("<h1>NO ENCONTRADA</h1> </p>La galleta con nombre "+ nomGalleta+" no ha sido encontrada</p>");
					}
					
					break;
				}
			}
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + accrion);
		}
		
		response.getWriter().append("<form action=\"ejercicio6.html\">"
				+ "  <input type=\"submit\" value=\"Volver\">"
				+ "</form>");
		
	}

}
