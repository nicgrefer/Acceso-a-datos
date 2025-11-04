package hoja3;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Servlet3Ejer3
 */
@WebServlet("/Servlet3Ejer3")
public class Servlet3Ejer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map <String, String> lib = new HashMap<String, String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3Ejer3() {
        super();
        // TODO Auto-generated constructor stub
        
    }

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	lib.put("java", "67.00");
        lib.put("c", "56.00");
        lib.put("cpp", "63.00");
        lib.put("vr", "52.00");
        lib.put("phyton", "46.00");
    	
        config.getServletContext().setAttribute("libros", lib);
        
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		response.getWriter().append("<h1>Bienvenidos a la WEB LIBRERIA. Seleccione un libro</h1>");
		response.getWriter().append("<form action=\"\" method=\"post\"> <h3>Lista de libros");
		response.getWriter().append("<select name=\"libros\" size=\"5\">\r\n"
				+ "            <option value=\"java\" >Java</option>\r\n"
				+ "            <option value=\"c\">C</option>\r\n"
				+ "            <option value=\"cpp\">C++</option>\r\n"
				+ "            <option value=\"vr\">vr</option>\r\n"
				+ "            <option value=\"phyton\">Phyton</option>\r\n"
				+ "        </select>");
		response.getWriter().append(" Unidades <input type=\"text\" name=\"unidades\">\r\n"
				+ "            <button type=\"submit \" onclick=\"enviarPedido()\">enviar</button> </form> ");
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		int cantidadTotal = 0;
		
		String libro = request.getParameter("libros");
		String cantidad = request.getParameter("unidades");
		
		if (!cantidad.equals("0")) {
			
			Cookie []cookies = request.getCookies();
			
			int cantNum = Integer.parseInt(cantidad);
			
			if (cookies!=null) {
				for (Cookie c : cookies) {
					if (c.getName().equals(libro)) {
						int cantAntes = Integer.parseInt(c.getValue());
						cantidadTotal = cantAntes+cantNum;
						break;
					}else {
						cantidadTotal= cantNum;
					}
				}
			}else {
				cantidadTotal= cantNum;
			}
			String SantidadTotalString = String.valueOf(cantidadTotal);
			Cookie cookie = new Cookie(libro, SantidadTotalString);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
	
			response.getWriter().append("<h1>Usted seleccionó " + libro + "</h1>");
			
    	} else {
    		response.getWriter().append("<h1>No seleccionó unidades</h1>");
    	}
		response.getWriter().append("<p><a href='Servlet3Ejer3'>Sigue comprando</a></p>")
		.append("<p><a href='Servlet3Ejer3Bis'>Ver compra</a>").append("</body>").append("</html>");
		response.getWriter().close();
		
	}
	

}
