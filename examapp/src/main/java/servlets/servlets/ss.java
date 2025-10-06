package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ss
 */
@WebServlet("/ss")
public class ss extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ss() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");

	        String idioma = request.getParameter("idioma");
	        String saludo;

	        if (idioma == null || idioma.isEmpty()) {
	            saludo = "No has indicado idioma.";
	        } else {
	            switch (idioma.toLowerCase()) {
	                case "es":
	                    saludo = "Hola mundo";
	                    break;
	                case "in":
	                    saludo = "Hello world";
	                    break;
	                case "fr":
	                    saludo = "Bonjour le monde";
	                    break;
	                default:
	                    saludo = "El idioma no está en nuestra base de datos";
	            }
	        }

	        response.getWriter().append("<html>")
	                            .append("<body>")
	                            .append("<h2>" + saludo + "</h2>")
	                            .append("</body>")
	                            .append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
