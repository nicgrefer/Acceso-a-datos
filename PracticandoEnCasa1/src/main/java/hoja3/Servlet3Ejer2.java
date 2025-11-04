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
 * Servlet implementation class Servlet3Ejer2
 */
@WebServlet("/Servlet3Ejer2")
public class Servlet3Ejer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet3Ejer2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();

		response.setContentType("text/html");

		ArrayList<String> listUsers = (ArrayList<String>) sesion.getAttribute("users");

		if (listUsers == null) {
			listUsers = new ArrayList<String>();
		}
		else {
			String user = request.getParameter("user");

			if (user != null) {

				listUsers.add(user);
				sesion.setAttribute("users", listUsers);

				response.getWriter().append("<p>Hola " + user + "</p>");
				response.getWriter().append("<p>Bienvenido a mi primera página Web!</p> ");
				response.getWriter().append("<p>Contigo: hoy me han visitado:</p>");

				for (String u : listUsers) {
					response.getWriter().append(u + "<br>");

				}
			}
		}
	}
}
