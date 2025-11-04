package hoja3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Servlet3Ejer1
 */
@WebServlet("/Servlet3Ejer1")
public class Servlet3Ejer1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3Ejer1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
		
		response.setContentType("text/html");
		int precio = 0;
		
		String preciosesion = (String) sesion.getAttribute("preciosesion");
		if (preciosesion != null) {
			precio =  Integer.parseInt(preciosesion);
		}
		
		String valor = request.getParameter("letra");
		String tiket = request.getParameter("mostrar");
		
		
		
		if (valor != null && !valor.isBlank()) {
			switch (valor) {
			case "A": {
				precio= precio + 3;
				break;
				}
			case "B": {
				precio= precio + 4;
				break;
				}
			case "C": {
				precio= precio + 5;
				break;
				}
			case "D": {
				precio= precio + 1;
				break;
				}
			
			}
			String precioString = String.valueOf(precio);
			sesion.setAttribute("preciosesion", precioString);
			
			
		}
		response.getWriter().append("<form method=\"get\"> <h1> Tienda letra </h1>");
		
				if (tiket != null && tiket.equals("mostrar")) {
					response.getWriter().append("<p>" + precio + "</p>");	
						}
				
				response.getWriter().append("        <button type=\"submit\" name=\"letra\" value=\"A\">A</button>"
				+ "        <button type=\"submit\" name=\"letra\" value=\"B\">B</button>"
				+ "        <button type=\"submit\" name=\"letra\" value=\"C\">C</button>"
				+ "        <button type=\"submit\" name=\"letra\" value=\"D\">D</button>"
				+ "        <br> <br>"
				+ "        <button type=\"submit\" name=\"mostrar\" value = 'mostrar'>tiket</button>"
				+ "    </form>");
		
	}

}
