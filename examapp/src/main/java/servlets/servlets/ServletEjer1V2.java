package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletEjer1V2
 */
@WebServlet("/ServletEjer1V2")
public class ServletEjer1V2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer1V2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mensaje = request.getParameter("mensaje");
		String firma = request.getParameter("firma");
		
		// Configurar la respuesta
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				// Generar HTML de respuesta
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset='UTF-8'>");
				out.println("<title>Saludo - GET</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Método GET</h2>");
				
				if (mensaje != null && !mensaje.isEmpty()) {
					out.println("<p><strong>Mensaje:</strong> " + mensaje + "</p>");
				}
				
				if (firma != null && !firma.isEmpty()) {
					out.println("<p><strong>Firma:</strong> " + firma + "</p>");
				}
				
				
				out.println("</body>");
				out.println("</html>");
				
				out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mensaje = request.getParameter("mensaje");
		String firma = request.getParameter("firma");
		
		// Configurar la respuesta
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				// Generar HTML de respuesta
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset='UTF-8'>");
				out.println("<title>Saludo - POST</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2>Método POST</h2>");
				
				if (mensaje != null && !mensaje.isEmpty()) {
					out.println("<p><strong>Mensaje:</strong> " + mensaje + "</p>");
				}
				
				if (firma != null && !firma.isEmpty()) {
					out.println("<p><strong>Firma:</strong> " + firma + "</p>");
				}
				
				
				out.println("</body>");
				out.println("</html>");
				
				out.close();
		
	}

}
