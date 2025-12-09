import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
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
        out.println("<title>Servlet 2</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%); min-height: 100vh; }");
        out.println(".container { max-width: 600px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }");
        out.println("h1 { color: #f5576c; text-align: center; }");
        out.println("p { color: #555; line-height: 1.6; }");
        out.println(".links { margin-top: 30px; padding: 20px; background: #f5f5f5; border-radius: 5px; }");
        out.println("a { display: block; margin: 10px 0; padding: 10px; background: #f5576c; color: white; text-decoration: none; border-radius: 5px; text-align: center; }");
        out.println("a:hover { background: #e04858; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>🚀 Servlet 2</h1>");
        out.println("<p>Bienvenido al Servlet 2. Cada visita a esta página está siendo contabilizada automáticamente.</p>");
        out.println("<div class='links'>");
        out.println("<a href='Servlet1'>Ir a Servlet 1</a>");
        out.println("<a href='Servlet3'>Ir a Servlet 3</a>");
        out.println("<a href='EstadisticasVisitas'>Ver Estadísticas de Visitas</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}