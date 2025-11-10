package ejer2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletError2")
public class ServletError2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String mensaje = (String) request.getAttribute("mensaje");
        if (mensaje == null || mensaje.isEmpty()) {
            mensaje = "No has elegido ninguna tabla. Elige una tabla por favor.";
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Mensaje del Servidor</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; background-color: #f0f0f0; }");
        out.println(".container { background-color: white; border: 2px solid #ccc; padding: 40px; text-align: center; box-shadow: 0 2px 10px rgba(0,0,0,0.1); max-width: 500px; }");
        out.println("h2 { margin-top: 0; margin-bottom: 30px; }");
        out.println(".mensaje { color: red; font-weight: bold; margin: 20px 0; }");
        out.println("a { display: inline-block; margin-top: 20px; color: blue; text-decoration: underline; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h2>Mensaje del Servidor</h2>");
        out.println("<div class='mensaje'>" + mensaje + "</div>");
        out.println("<a href='ejer2.html'>Volver</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}