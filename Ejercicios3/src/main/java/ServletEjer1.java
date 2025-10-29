

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class ServletEjer1
 */
@WebServlet("/ServletEjer1")
public class ServletEjer1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession sesion = request.getSession(true);
		
		if (sesion.getAttribute("total") == null) {// crear sesion
			
			sesion.setAttribute("total", 0);
			
		}
		
		
		// Recuperamos valor actual de la sesion
		Integer precioTotal = (Integer) sesion.getAttribute("total");
		
		String boton = request.getParameter("boton");
		
		if (boton != null) {
			
			switch (boton) {
				case "A": {
					
					precioTotal+=3;
					break;					
				}
				case "B":{
					precioTotal+=4;
					break;
				}
				case "C":{
					precioTotal+=5;
					break;
				}
				case "D":{
					precioTotal+=1;
					break;
				}
				case "ticket":{
					break;
				}
				
			}
			
			sesion.setAttribute("total", precioTotal);	
		}
		
		response.setContentType("text/html");
		response.getWriter().append("<body>\r\n");
		response.getWriter().append("    <h1>Tienda LeterA</h1>\r\n");
		if (boton != null && boton.equals("ticket")){
		response.getWriter().append("    <p>Total acumulado: " + precioTotal + "€</p>\r\n");
		}
		response.getWriter().append("    <form method=\"get\">\r\n");
		response.getWriter().append("        <table>\r\n");
		response.getWriter().append("        <tr>\r\n");
		response.getWriter().append("            <td><button type=\"submit\" value=\"A\" name=\"boton\">A (3€)</button></td>\r\n");
		response.getWriter().append("            <td><button type=\"submit\" value=\"B\" name=\"boton\">B (4€)</button></td>\r\n");
		response.getWriter().append("            <td><button type=\"submit\" value=\"C\" name=\"boton\">C (5€)</button></td>\r\n");
		response.getWriter().append("            <td><button type=\"submit\" value=\"D\" name=\"boton\">D (1€)</button></td>\r\n");
		response.getWriter().append("        </tr>\r\n");
		response.getWriter().append("    </table>\r\n");
		response.getWriter().append("    <br>\r\n");
		response.getWriter().append("    <button type=\"submit\" name=\"boton\" value=\"ticket\">Ver Tiket</button>\r\n");
		response.getWriter().append("    </form>\r\n");
		response.getWriter().append("</body>");
		response.getWriter().close();
	}

}
