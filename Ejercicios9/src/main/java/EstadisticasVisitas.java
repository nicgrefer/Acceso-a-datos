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
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; background: linear-gradient(135deg, #a8edea 0%, #fed6e3 100%); min-height: 100vh; }");
        out.println(".container { max-width: 900px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }");
        out.println("h1 { color: #333; text-align: center; border-bottom: 3px solid #a8edea; padding-bottom: 15px; }");
        out.println("table { width: 100%; border-collapse: collapse; margin: 20px 0; }");
        out.println("th { background: linear-gradient(135deg, #a8edea 0%, #fed6e3 100%); padding: 15px; text-align: left; font-weight: bold; color: #333; }");
        out.println("td { padding: 12px 15px; border-bottom: 1px solid #ddd; }");
        out.println("tr:hover { background-color: #f5f5f5; }");
        out.println(".url { color: #667eea; word-break: break-all; }");
        out.println(".visitas { text-align: center; font-weight: bold; color: #f5576c; }");
        out.println(".empty { text-align: center; padding: 40px; color: #999; font-style: italic; }");
        out.println(".total { background: #e8f5e9; padding: 15px; margin: 20px 0; border-radius: 5px; text-align: center; font-size: 18px; font-weight: bold; color: #2e7d32; }");
        out.println(".links { margin-top: 30px; text-align: center; }");
        out.println("a { display: inline-block; margin: 5px; padding: 10px 20px; background: #667eea; color: white; text-decoration: none; border-radius: 5px; }");
        out.println("a:hover { background: #5568d3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>📊 Estadísticas de Visitas a Servlets</h1>");
        
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