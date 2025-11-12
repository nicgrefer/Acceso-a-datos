package ejer2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletTablas2")
public class ServletTablas2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Integer tabla = (Integer) request.getAttribute("tabla");
        String color = (String) request.getAttribute("color");
        String colorCSS = getColorCSS(color);
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Tabla de multiplicar del " + tabla + "</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; background-color: #f0f0f0; }");
        out.println(".container { background-color: white; border: 2px solid #ccc; padding: 20px; text-align: center; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }");
        out.println("h2 { margin-top: 0; }");
        out.println("table { margin: 20px auto; border-collapse: collapse; }");
        out.println("td { padding: 8px 15px; border: 1px solid #000; background-color: " + colorCSS + "; color: white; font-weight: bold; }");
        out.println("a { display: inline-block; margin-top: 20px; color: blue; text-decoration: underline; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h2>Tabla de multiplicar del " + tabla + "</h2>");
        out.println("<table>");
        
        for (int i = 1; i <= 10; i++) {
            int resultado = tabla * i;
            out.println("<tr><td>" + tabla + " x " + i + " = " + resultado + "</td></tr>");
        }
        
        out.println("</table>");
        out.println("<a href='ejer2.html'>Volver</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    private String getColorCSS(String color) {
        if (color == null) return "#000000";
        switch (color) {
            case "Negro": return "#000000";
            case "Rojo": return "#FF0000";
            case "Verde": return "#008000";
            case "Azul": return "#0000FF";
            case "Naranja": return "#FFA500";
            default: return "#000000";
        }
    }
}