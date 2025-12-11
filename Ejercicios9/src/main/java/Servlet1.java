import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Servlet 1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Servlet 1</h1>");
        out.println("<p>Bienvenido al Servlet 1. Este es un servlet de ejemplo que está siendo monitoreado por el filtro de contador de visitas.</p>");
        out.println("<div class='links'>");
        out.println("<a href='Servlet2'>Ir a Servlet 2</a>");
        out.println("<a href='Servlet3'>Ir a Servlet 3</a>");
        out.println("<a href='EstadisticasVisitas'>Ver Estadísticas de Visitas</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}