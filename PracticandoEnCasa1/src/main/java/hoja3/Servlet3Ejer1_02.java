package hoja3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Servlet3Ejer1_02
 */
@WebServlet("/Servlet3Ejer1_02")
public class Servlet3Ejer1_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3Ejer1_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
		
		response.setContentType("text/html");
		
		int precio = 0;
		
		String letra = request.getParameter("letra");
		String mostrar = request.getParameter("mostrar");
		
		String presioSesion = (String) sesion.getAttribute("precios");
		
		if (presioSesion != null) {
			precio = Integer.parseInt(presioSesion);
		}

		if (letra != null) {
			switch (letra) {
				case "A": {
					precio += 3;
					break;
					}
				case "B": {
					precio += 4;
					break;
				}
				case "C": {
					precio += 5;
					break;
				}
				case "D": {
					precio += 1;
					break;
				}
		
			}
		}
		
		String precioS = String.valueOf(precio);
		sesion.setAttribute("precios", precioS);
		
		response.getWriter().append("<form method=\"get\"> <h1> Tienda letra </h1>");
		
		if (mostrar != null) {
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
