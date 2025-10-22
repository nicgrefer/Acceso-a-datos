

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletEjer6
 */
@WebServlet("/ServletEjer6")
public class ServletEjer6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		response.getWriter().append("<form>\r\n"
				+ "        <fieldset>\r\n"
				+ "            <p>Qué galleta quieres? <input type=\"text\"> </p>\r\n"
				+ "            \r\n"
				+ "            <input type=\"radio\" id=\"mostrar\" name=\"galleta\" value=\"mostrar\">\r\n"
				+ "            <label for=\"galleta\">Mostrar Galletas</label>\r\n"
				+ "\r\n"
				+ "            <input type=\"radio\" id=\"cocinar\" name=\"galleta\" value=\"cocinar\">\r\n"
				+ "            <label for=\"galleta\">Cocinar Galletas</label>\r\n"
				+ "\r\n"
				+ "            <input type=\"radio\" id=\"comer\" name=\"galleta\" value=\"comer\">\r\n"
				+ "            <label for=\"galleta\">Comer Galletas</label>\r\n"
				+ "            <br><br>\r\n"
				+ "            <button type=\"submit\">Oído Conina</button>\r\n"
				+ "        </fieldset>\r\n"
				+ "    </form>");
		

	}

}
