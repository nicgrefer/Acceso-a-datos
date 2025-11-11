

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/mostrar")
public class mostrar extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        ServletContext context = getServletContext();
        
        // Recuperamos el número del contexto
        Integer numero = (Integer) context.getAttribute("numeroAlmacenado");
        Long timestamp = (Long) context.getAttribute("timestamp");
        String threadOriginal = (String) context.getAttribute("thread");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Número Almacenado</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 50px; background-color: #f0f0f0; }");
        out.println(".container { background-color: white; padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
        out.println(".numero { font-size: 48px; color: #2196F3; font-weight: bold; }");
        out.println(".info { color: #666; margin: 10px 0; }");
        out.println(".thread { background-color: #fff3cd; padding: 10px; border-left: 4px solid #ffc107; margin: 15px 0; }");
        out.println("a { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 5px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Número Recuperado del Contexto</h1>");
        
        if (numero != null) {
            out.println("<div class='numero'>" + numero + "</div>");
            
            if (timestamp != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
                out.println("<p class='info'>Almacenado el: " + sdf.format(new Date(timestamp)) + "</p>");
            }
            
            out.println("<div class='thread'>");
            out.println("<strong>Thread que almacenó:</strong> " + (threadOriginal != null ? threadOriginal : "N/A") + "<br>");
            out.println("<strong>Thread actual:</strong> " + Thread.currentThread().getName());
            out.println("</div>");
        } else {
            out.println("<p style='color: red;'>No hay ningún número almacenado en el contexto.</p>");
        }
        
        out.println("<a href='javascript:history.back()'>Volver</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}