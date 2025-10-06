package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import codigoJava.Persona;

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

    public Persona [] lista = new Persona[3];
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Inicializar el array
        lista = new Persona[3];
        
        // Recoger datos de las personas
        lista[0] = new Persona(
            request.getParameter("nombre1"),
            request.getParameter("apellido1"),
            Integer.parseInt(request.getParameter("edad1")),
            request.getParameter("contacto1")
        );
        
        lista[1] = new Persona(
            request.getParameter("nombre2"),
            request.getParameter("apellido2"),
            Integer.parseInt(request.getParameter("edad2")),
            request.getParameter("contacto2")
        );
        
        lista[2] = new Persona(
            request.getParameter("nombre3"),
            request.getParameter("apellido3"),
            Integer.parseInt(request.getParameter("edad3")),
            request.getParameter("contacto3")
        );
        
        // Configurar la respuesta
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        // Obtener el PrintWriter
        PrintWriter out = response.getWriter();
        
        // Generar el HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Lista de Personas</title>");
        out.println("<style>");
        out.println("table { border-collapse: collapse; width: 80%; margin: 20px auto; }");
        out.println("th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }");
        out.println("th { background-color: #4CAF50; color: white; }");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println("h1 { text-align: center; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Lista de Personas</h1>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Nombre</th>");
        out.println("<th>Apellido</th>");
        out.println("<th>Edad</th>");
        out.println("<th>Contacto</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        
        // Recorrer el array y generar las filas
        for(int i = 0; i < lista.length; i++) {
            out.println("<tr>");
            out.println("<td>" + lista[i].getNombre() + "</td>");
            out.println("<td>" + lista[i].getApellido() + "</td>");
            out.println("<td>" + lista[i].getEdad() + "</td>");
            out.println("<td>" + lista[i].getContacto() + "</td>");
            out.println("</tr>");
        }
        
        out.println("</tbody>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
		
		
		//http://localhost:8080/EjerciciosProyectoMaven/ServletEjer2?nombre1=Juan&apellido1=Garc%C3%ADa&edad1=25&contacto1=juan@mail.com&nombre2=Ana&apellido2=L%C3%B3pez&edad2=30&contacto2=ana@mail.com&nombre3=Pedro&apellido3=Mart%C3%ADnez&edad3=35&contacto3=pedro@mail.com
	

	
}
