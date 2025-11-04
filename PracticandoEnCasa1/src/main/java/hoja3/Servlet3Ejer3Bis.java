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
	private static Map<String, String> lib;
       
    public Servlet3Ejer3Bis() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	// ✅ Obtener el Map del ServletContext
    	lib = (Map<String, String>) config.getServletContext().getAttribute("libros");
    	
    	// ✅ DEBUG: Verificar si el Map se cargó correctamente
    	if (lib == null) {
    		System.out.println("❌ ERROR: El Map 'libros' es NULL en Servlet3Ejer3Bis");
    	} else {
    		System.out.println("✅ Map 'libros' cargado correctamente con " + lib.size() + " elementos");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		double precioFin = 0.00;
		
		response.setContentType("text/html; charset=UTF-8");
		
		// ✅ ESTRUCTURA HTML COMPLETA - ESTO ES LO QUE FALTABA
		response.getWriter().append("<!DOCTYPE html>");
		response.getWriter().append("<html>");
		response.getWriter().append("<head>");
		response.getWriter().append("<title>Carrito</title>");
		response.getWriter().append("</head>");
		response.getWriter().append("<body>");
		response.getWriter().append("<h1>Carrito de Compra</h1>");
		
		// Ahora sí la tabla
		response.getWriter().append("<table border='1'>");
		response.getWriter().append("<tr>");
		response.getWriter().append("<td>Titulo del libro</td>");
		response.getWriter().append("<td>Unidades</td>");
		response.getWriter().append("<td>Precio</td>");
		response.getWriter().append("</tr>");
		
		if (cookies != null && lib != null) {
			for (Cookie c : cookies) {
				if (lib.containsKey(c.getName())) {
					String nombreLibro = c.getName();
					int numero = Integer.parseInt(c.getValue());
					double precioUnidad = Double.parseDouble(lib.get(nombreLibro));
					
					double precioProducto = precioUnidad * numero;
					precioFin += precioProducto;
					
					response.getWriter().append("<tr>");
					response.getWriter().append("<td>" + nombreLibro + "</td>");
					response.getWriter().append("<td>" + numero + "</td>");
					response.getWriter().append("<td>" + String.format("%.2f", precioProducto) + "</td>");
					response.getWriter().append("</tr>");
				}
			}
		}
		
		response.getWriter().append("</table>");
		response.getWriter().append("<h3>Total = " + String.format("%.2f", precioFin) + " €</h3>");
		response.getWriter().append("<p><a href='Servlet3Ejer3'>Seguir comprando</a></p>");
		
		// ✅ CERRAR HTML - ESTO TAMBIÉN FALTABA
		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
 	}
}