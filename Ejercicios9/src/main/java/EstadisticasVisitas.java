import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EstadisticasVisitas")
public class EstadisticasVisitas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Obtener el HashMap del contexto
        HashMap<String, Integer> contadorVisitas = 
            (HashMap<String, Integer>) getServletContext().getAttribute("contadorVisitas");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Estadísticas de Visitas</title>");
       out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Estadísticas de Visitas a Servlets</h1>");
        
        if (contadorVisitas == null || contadorVisitas.isEmpty()) {
            out.println("<div class='empty'>No se han registrado visitas todavía</div>");
        } else {
            // Calcular total de visitas
            int totalVisitas = 0;
            for (Integer visitas : contadorVisitas.values()) {
                totalVisitas += visitas;
            }
            
            out.println("<div class='total'>Total de visitas: " + totalVisitas + "</div>");
            
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>URL del Servlet</th>");
            out.println("<th style='width: 150px; text-align: center;'>Número de Visitas</th>");
            out.println("</tr>");
            
            // Mostrar cada URL y su contador
            for (Map.Entry<String, Integer> entrada : contadorVisitas.entrySet()) {
                out.println("<tr>");
                out.println("<td class='url'>" + entrada.getKey() + "</td>");
                out.println("<td class='visitas'>" + entrada.getValue() + 
                           (entrada.getValue() == 1 ? " vez" : " veces") + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
        }
        
        out.println("<div class='links'>");
        out.println("<a href='Servlet1'>Servlet 1</a>");
        out.println("<a href='Servlet2'>Servlet 2</a>");
        out.println("<a href='Servlet3'>Servlet 3</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}