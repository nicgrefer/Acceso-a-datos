package hoja3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Servlet3Ejer2_02
 */
@WebServlet("/Servlet3Ejer2_02")
public class Servlet3Ejer2_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3Ejer2_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		HttpSession sesion = request.getSession();
		
		String user = request.getParameter("user");
		
		ArrayList<String> userList = (ArrayList<String>) sesion.getAttribute("userList"); 
		
		if (userList == null) {
			userList = new ArrayList<String>();
		}
		
		if (user != null) {
			
			userList.add(user);
			sesion.setAttribute("userList", userList);
			
			response.getWriter().append("<p>Hola " + user + "</p>");
			response.getWriter().append("<p>Bienvenido a mi primera página Web!</p> ");
			response.getWriter().append("<p>Contigo hoy me han visitado:</p>");
			
			for (String u : userList) {
				response.getWriter().append("<p>"+u+"</p>");
			}
			
		}
	}

}
