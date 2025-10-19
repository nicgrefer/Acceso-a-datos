

import java.io.IOException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean bandera = false;
		
		response.setContentType("text/html"); 
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    for (Cookie c : cookies) {
		        if (c.getName().equals("carrito")) {
		            String valor = c.getValue(); // ej: "java,3,76.5"
		            String[] datos = valor.split(",");
		            String libroGuardado = datos[0];
		            String cantidadGuardada = datos[1];
		            String totalGuardado = datos[2];

		            response.getWriter().append("<p>Última compra: "
		                    + libroGuardado + " (x" + cantidadGuardada + ") Total: " + totalGuardado + " €</p><hr>");
		        }
		    }
		}
		
		String libro = request.getParameter("libro");
		String cantidadStr = request.getParameter("cantidad");
		int cantidad = 0;
		
		if (cantidadStr != null && !cantidadStr.isEmpty()) {
		    try {
		        cantidad = Integer.parseInt(cantidadStr);
		    } catch (NumberFormatException e) {
		        cantidad = 0;
		    }
		}
		
		
		
		response.getWriter().append("<h1>Bienvenido a Web Librería. Seleccione el libro</h1>"
                + "<h3>"
                + "<form method='get'>"
                + "Lista de libros <select name='libro'>"
                + "<option value='java'>Java</option>"
                + "<option value='c'>C</option>"
                + "<option value='c++'>C++</option>"
                + "<option value='vb'>VB</option>"
                + "<option value='python'>Python</option>"
                + "</select>"
                + " Unidades: <input type='text' name='cantidad'/>"
                + " <button type='submit'>Enviar</button>"
                + "</form>"
                + "</h3>");
		response.getWriter().append(libro+cantidad);
		
	
		 
		
	}



}
