

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletEjer2
 */
@WebServlet("/ServletEjer2")
public class ServletEjer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		HttpSession session = request.getSession(true);
		String user = request.getParameter("user");
		ArrayList<String>listUsers = (ArrayList<String>) session.getAttribute("list");
		
	if (user != null || listUsers != null) {
		
		
		if (session.getAttribute("list")==null) {
			listUsers = new ArrayList();
		}
		
		if (user != null) {
			listUsers.add(user);
		}
		session.setAttribute("list", listUsers);
		
		response.setContentType("text/html");
        response.getWriter().append("<html><body>");
        response.getWriter().append("<p>Hola " + user + "</p>");
        response.getWriter().append("<p>¡Bienvenido a mi primera página web!</p>");
        response.getWriter().append("<p>Contigo, hoy me han visitado:</p>");
        response.getWriter().append("<table border='1'>");

        for (String usuarios : listUsers) {
            response.getWriter().append("<tr><td>" + usuarios + "</td></tr>");
        }

        response.getWriter().append("</table>");
        response.getWriter().append("</body></html>");
		
		
	}

	}

}
