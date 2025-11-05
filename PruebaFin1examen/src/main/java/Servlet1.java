

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String colorPrincipal;   
    private Map<String, String> lib = new HashMap<String,String>()	;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		colorPrincipal = config.getServletContext().getInitParameter("color");
		
		lib.put("java", "67.00");
        lib.put("c", "56.00");
        lib.put("cpp", "63.00");
        lib.put("vr", "52.00");
        lib.put("phyton", "46.00");
		
		config.getServletContext().setAttribute("precios", lib);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		response.setContentType("text/html");

		String color = request.getParameter("color");
		
		if (color == null) {
			color = colorPrincipal;
		}
		
		response.getWriter().append("<h1>Bienvenidos a la WEB LIBRERIA. Seleccione un libro</h1>");
		response.getWriter().append("<p>El color del fondo es " + color+"</p>");
		response.getWriter().append("<form action='' method='post'> <h3>Lista de libros");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String libro = request.getParameter("libros");
		int cantidad = Integer.parseInt(request.getParameter("unidades"));
		int cantidadTotal=0;
		
		Cookie []cookies = request.getCookies();
		
		if (cantidad != 0) {
		
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals(libro)) {
						int cantAntes = Integer.parseInt(c.getValue());
						cantidadTotal = cantAntes+cantidad;
						break;
					}else {
						cantidadTotal= cantidad;
					}
				}
			}else {
				cantidadTotal= cantidad;
			}
				String CantidadTotalString = String.valueOf(cantidadTotal);
				Cookie cookie = new Cookie(libro, CantidadTotalString);
				cookie.setMaxAge(3600);
				response.addCookie(cookie);
				response.getWriter().append("<h1>Usted seleccionó " + libro + "</h1>");
			
			
		}else {
			response.getWriter().append("<h1>No seleccionó unidades</h1>");
		}
		response.getWriter().append("<p><a href='Servlet1'>Sigue comprando</a></p>")
		.append("<p><a href='Servlet2'>Ver compra</a>").append("</body>").append("</html>");
		response.getWriter().close();
		
	}
}
