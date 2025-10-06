package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletEjer5
 */
@WebServlet("/ServletEjer5")
public class ServletEjer5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEjer5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
response.setContentType("text/html;charset=UTF-8");
        
        String[] asignaturas = request.getParameterValues("asignatura");
        String sexo = request.getParameter("sexo");
        String[] actividades = request.getParameterValues("actividades");
        
        response.getWriter().append("<!DOCTYPE html>")
            .append("<html>")
            .append("<head>")
            .append("<meta charset='UTF-8'>")
            .append("<title>Datos recibidos</title>")
            .append("</head>")
            .append("<body>")
            .append("<h1>Datos de la matrícula recibidos</h1>")
            .append("<h2>Asignaturas seleccionadas:</h2>")
            .append("<ul>");
        
        for (String asignatura : asignaturas) {
            response.getWriter().append("<li>").append(asignatura).append("</li>");
        }
        
        response.getWriter().append("</ul>")
            .append("<h2>Sexo:</h2>")
            .append("<p>").append(sexo).append("</p>")
            .append("<h2>Actividades extraescolares:</h2>")
            .append("<ul>");
        
        for (String actividad : actividades) {
            response.getWriter().append("<li>").append(actividad).append("</li>");
        }
        
        response.getWriter().append("</ul>")
           
            .append("</body>")
            .append("</html>");
    }
		
	

}
